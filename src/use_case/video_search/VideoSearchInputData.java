package use_case.video_search;

public class VideoSearchInputData {

    final private String videoId;

    final private String username;

    public VideoSearchInputData(String videoId, String username) {
        this.videoId = videoId;
        this.username = username;
    }

    public String getVideoId() { return videoId; }

    public String getUsername() { return username; }

}
