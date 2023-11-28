package data_access;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatistics;
import use_case.video_search.VideoSearchDataAccessInterface;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.*;

public class YouTubeDataAccess implements VideoSearchDataAccessInterface {

//    private static final String CLIENT_SECRETS= "client_secret.json";
    private static final Collection<String> SCOPES =
            Arrays.asList("https://www.googleapis.com/auth/youtube.readonly");

    private static final String APPLICATION_NAME = "API code samples";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    public YouTubeDataAccess() throws IOException {
    }

    /**
     * Create an authorized Credential object.
     *
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize(final NetHttpTransport httpTransport) throws IOException {
        // Load client secrets.
        FileInputStream fis = new FileInputStream(new File(".\\client_secret.json"));
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(fis));
//        InputStream in = YouTubeDataAccess.class.getResourceAsStream(CLIENT_SECRETS);
//        GoogleClientSecrets clientSecrets =
//                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                        .build();
        Credential credential =
                new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        return credential;
    }

    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential = authorize(httpTransport);
        return new YouTube.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static VideoListResponse getVideoResponse(String videoId) throws GeneralSecurityException, IOException {
        YouTube youtubeService = getService();
        YouTube.Videos.List request = youtubeService.videos().list("snippet, statistics");
        return request.setId(videoId).execute();
    }

    @Override
    public entities.Video get(String videoId) throws GeneralSecurityException, IOException {
        VideoListResponse response = getVideoResponse(videoId);
        String jsonString = response.toPrettyString();
        Video video = response.getItems().get(0);
        VideoSnippet snippet = video.getSnippet();
        VideoStatistics statistics = video.getStatistics();

        entities.Video videoEn = new entities.Video(videoId, snippet.getChannelTitle(), snippet.getTitle(),
                snippet.getDescription(), snippet.getPublishedAt(), statistics.getViewCount().intValue(),
                statistics.getLikeCount().intValue(), statistics.getCommentCount().intValue());

        return videoEn;
    }

//    public static entities.Video getYuh(String videoId) throws GeneralSecurityException, IOException {
//        VideoListResponse response = getVideoResponse(videoId);
//        String jsonString = response.toPrettyString();
//        Video video = response.getItems().get(0);
//        VideoSnippet snippet = video.getSnippet();
//        VideoStatistics statistics = video.getStatistics();
//
//        entities.Video videoEn = new entities.Video(videoId, snippet.getChannelTitle(), snippet.getTitle(),
//                snippet.getDescription(), snippet.getPublishedAt(), statistics.getViewCount().intValue(),
//                statistics.getLikeCount().intValue(), statistics.getCommentCount().intValue());
//
//        return videoEn;
//    }
//
//    @Override
//    public entities.Video get(String videoId) throws GeneralSecurityException, IOException {
//        return null;
//    }

    public boolean isInvalid(String videoId) throws GeneralSecurityException, IOException {
        try {
            get(videoId);
            return false;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }

    }

//    public static void main(String[] args) throws GeneralSecurityException, IOException {
////        System.out.println(getYuh("123"));
//        System.out.println(isInvalid("123"));
//    }


}
