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

    public VideoListResponse get_video_response(String videoId) throws GeneralSecurityException, IOException {
        YouTube youtubeService = getService();
        YouTube.Videos.List request = youtubeService.videos().list("snippet, statistics");
        return request.setId(videoId).execute();
    }

    public entities.Video get_video(String videoId) throws GeneralSecurityException, IOException {
        VideoListResponse response = get_video_response(videoId);
        Video video = response.getItems().get(0);
        VideoSnippet snippet = video.getSnippet();
        VideoStatistics statistics = video.getStatistics();

        int commentCount;
        int likeCount;
        int viewCount;
        if (statistics.getCommentCount() == null){
            commentCount =  statistics.getCommentCount().intValue();
        }
        else{
            commentCount = Integer.parseInt(null);
        }

        if (statistics.getLikeCount() == null){
            likeCount =  statistics.getLikeCount().intValue();
        }
        else{
            likeCount = Integer.parseInt(null);
        }

        if (statistics.getViewCount() == null){
            viewCount =  statistics.getViewCount().intValue();
        }
        else{
            viewCount = Integer.parseInt(null);
        }


        entities.Video myVideo = new entities.Video(videoId, snippet.getChannelTitle(), snippet.getTitle(),
                snippet.getDescription(), snippet.getPublishedAt(), viewCount, likeCount, commentCount);

        return myVideo;
    }
    public ArrayList<entities.Video> get_trending_default() throws GeneralSecurityException, IOException {
        YouTube youtubeService = getService();
        YouTube.Videos.List request = youtubeService.videos().list("snippet, statistics");
        VideoListResponse response = request.setChart("mostPopular").execute();
        return getVideos(response);
    }
    public ArrayList<entities.Video> get_trending_category(String category) throws GeneralSecurityException, IOException {
        YouTube youtubeService = getService();
        YouTube.Videos.List request = youtubeService.videos().list("snippet, statistics");
        VideoListResponse response = request.setChart("mostPopular").setVideoCategoryId(category).execute();
        return getVideos(response);
    }

    private static ArrayList<entities.Video> getVideos(VideoListResponse response) {
        ArrayList<entities.Video> videos = new ArrayList<>();
        for (int i = 0; i < 5; i ++){
            Video video = response.getItems().get(i);
            VideoSnippet snippet = video.getSnippet();
            String videoId = video.getId();
            VideoStatistics statistics = video.getStatistics();

            int commentCount;
            int likeCount;
            int viewCount;

            // if the count is null, count is set to be 0
            if (statistics.getCommentCount() != null){
                commentCount =  statistics.getCommentCount().intValue();
            }
            else{
                commentCount = 0;
            }

            if (statistics.getLikeCount() != null){
                likeCount =  statistics.getLikeCount().intValue();
            }
            else{
                likeCount = 0;
            }

            if (statistics.getViewCount() != null){
                viewCount =  statistics.getViewCount().intValue();
            }
            else{
                viewCount = 0;
            }

            entities.Video thisVideo = new entities.Video(videoId, snippet.getChannelTitle(), snippet.getTitle(),
                    snippet.getDescription(), snippet.getPublishedAt(), viewCount, likeCount, commentCount);
            videos.add(thisVideo);

        }
        return videos;
    }

}
