package data_access;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatistics;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import use_case.trending.TrendingDataAccessInterface;
import use_case.video_search.VideoSearchDataAccessInterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;
import java.util.*;

public class YouTubeDataAccess implements VideoSearchDataAccessInterface, TrendingDataAccessInterface {

    private static final String CLIENT_SECRETS= "client_secret.json";
    private static final Collection<String> SCOPES =
            Arrays.asList("https://www.googleapis.com/auth/youtube.readonly");

    private static final String APPLICATION_NAME = "API code samples";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    /**
     * Create an authorized Credential object.
     *
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize(final NetHttpTransport httpTransport) throws IOException {
        // Load client secrets.
        InputStream in = YouTubeDataAccess.class.getResourceAsStream(CLIENT_SECRETS);
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
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

    public static VideoListResponse get_video_response(String videoId) throws GeneralSecurityException, IOException {
        YouTube youtubeService = getService();
        YouTube.Videos.List request = youtubeService.videos().list("snippet, statistics");
        return request.setId(videoId).execute();
    }

    public static entities.Video get_video(String videoId) throws GeneralSecurityException, IOException {
        VideoListResponse response = get_video_response(videoId);
        Video video = response.getItems().get(0);
        VideoSnippet snippet = video.getSnippet();
        VideoStatistics statistics = video.getStatistics();

        entities.Video myVideo = new entities.Video(videoId, snippet.getChannelTitle(), snippet.getTitle(),
                snippet.getDescription(), snippet.getPublishedAt(), statistics.getViewCount(),
                statistics.getLikeCount(), statistics.getCommentCount());

        return myVideo;
    }
    public static ArrayList<entities.Video> get_trending_default(ArrayList<String> videoIds) throws GeneralSecurityException, IOException {
        YouTube youtubeService = getService();
        YouTube.Videos.List request = youtubeService.videos().list("snippet, statistics");
        VideoListResponse response = request.setChart("mostPopular").execute();
        ArrayList<entities.Video> videos = new ArrayList<>();
        for (int i = 0; i < 5; i ++){
            Video video = response.getItems().get(i);
            VideoSnippet snippet = video.getSnippet();
            String videoId = video.getId();
            VideoStatistics statistics = video.getStatistics();
            entities.Video thisVideo = new entities.Video(videoId, snippet.getChannelTitle(), snippet.getTitle(),
                    snippet.getDescription(), snippet.getPublishedAt(), statistics.getViewCount(),
                    statistics.getLikeCount(), statistics.getCommentCount());
            videos.add(thisVideo);

        }
        return videos;
    }

}
