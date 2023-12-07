package data_access;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import use_case.trending.TrendingDataAccessInterface;
import use_case.compare_videos.CompareSearchDataAccessInterface;
import use_case.trending.TrendingDataAccessInterface;
import use_case.video_search.VideoSearchDataAccessInterface;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class YouTubeDataAccess implements VideoSearchDataAccessInterface, TrendingDataAccessInterface, CompareSearchDataAccessInterface {

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
        FileInputStream fis = new FileInputStream(("./client_secret.json"));
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
        final NetHttpTransport httpTransport = new com.google.api.client.http.javanet.NetHttpTransport();
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

    public entities.Video getVideo(String videoId) throws GeneralSecurityException, IOException {
        VideoListResponse response = getVideoResponse(videoId);
        Video video = response.getItems().get(0);
        VideoSnippet snippet = video.getSnippet();
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


        entities.Video myVideo = new entities.Video(videoId, snippet.getChannelTitle(), snippet.getTitle(),
                snippet.getDescription(), snippet.getPublishedAt(), viewCount, likeCount, commentCount);

        return myVideo;
    }
    public ArrayList<entities.Video> getTrendingDefault() throws GeneralSecurityException, IOException {
        YouTube youtubeService = getService();
        YouTube.Videos.List request = youtubeService.videos().list("snippet, statistics");
        VideoListResponse response = request.setChart("mostPopular").execute();
        return getVideos(response);
    }
    public ArrayList<entities.Video> getTrendingCategory(String category) throws GeneralSecurityException, IOException {
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

    private ArrayList<Object> getChannel(String channelName)throws GeneralSecurityException, IOException, GoogleJsonResponseException {
        YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.Channels.List request = youtubeService.channels()
                .list("snippet,statistics");
        ChannelListResponse response = request.setForUsername(channelName).execute();

        ArrayList<Object> lst = new ArrayList<>();
        int subscriberCount = 0;
        int viewCount = 0;
        if (response.getItems().get(0).getStatistics().getSubscriberCount() != null) {
            subscriberCount = response.getItems().get(0).getStatistics().getSubscriberCount().intValue();
        }
        if (response.getItems().get(0).getStatistics().getViewCount() != null){
            viewCount = response.getItems().get(0).getStatistics().getViewCount().intValue();
        }
        lst.add(channelName);
        lst.add(subscriberCount);
        lst.add(viewCount);
        return lst;
    }

    public boolean isInvalid(String videoId) throws GeneralSecurityException, IOException {
        try {
            getVideo(videoId);
            return false;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }

    public boolean isInvalidTwo(String videoIdOne, String videoIdTwo) {
        try {
            getVideo(videoIdOne);
            getVideo(videoIdTwo);
            return false;
        } catch (IndexOutOfBoundsException e) {
            return true;
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
