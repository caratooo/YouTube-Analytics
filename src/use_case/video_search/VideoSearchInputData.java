package use_case.video_search;

public class VideoSearchInputData {

    final private String videoId;

    public VideoSearchInputData(String videoId) {
        this.videoId = videoId;
    }

    String getVideoId() { return videoId; }

}
