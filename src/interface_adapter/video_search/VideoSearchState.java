package interface_adapter.video_search;

public class VideoSearchState {

    private String videoId = "";

    private String videoIdError = null;

    public VideoSearchState(VideoSearchState copy) {
        videoId = copy.videoId;
        videoIdError = copy.videoIdError;
    }

    public VideoSearchState() {
    }

    public String getVideoId() { return videoId; }

    public String getVideoIdError() { return videoIdError; }

    public void setVideoId(String videoId) { this.videoId = videoId; }

    public void setVideoIdError(String videoIdError) { this.videoIdError = videoIdError; }


}
