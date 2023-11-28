package interface_adapter.video_search;

public class VideoSearchState {

    private String videoId = "";

    // TODO maybe add error if the DAO grabs nothing (would mean the ID is invalid)
    private String videoIdError = null;

    public VideoSearchState(VideoSearchState copy) {
        videoId = copy.videoId;
        videoIdError = copy.videoIdError;
    }

    public VideoSearchState() {

    }

    public String getVideoId() { return videoId; }

//    public String get

    public String getVideoIdError() { return videoIdError; }

    public void setVideoId(String videoId) { this.videoId = videoId; }

    public void setVideoIdError(String videoIdError) { this.videoIdError = videoIdError; }


}
