package interface_adapter.video_search;

public class VideoSearchState {

    private String videoId = "";

    private String username = "";

    private String videoIdError = null;

    public VideoSearchState(VideoSearchState copy) {
        videoId = copy.videoId;
        username = copy.username;
        videoIdError = copy.videoIdError;
    }

    public VideoSearchState() {
    }

    public String getVideoId() { return videoId; }

    public String getUsername() { return username; }

    public String getVideoIdError() { return videoIdError; }

    public void setVideoId(String videoId) { this.videoId = videoId; }

    public void setUsername(String username) { this.username = username; }

    public void setVideoIdError(String videoIdError) { this.videoIdError = videoIdError; }


}
