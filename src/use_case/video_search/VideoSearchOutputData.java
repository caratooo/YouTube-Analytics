package use_case.video_search;

public class VideoSearchOutputData {

    private final String videoId;

    private final String videoAbout;  // TODO see below

    private final String videoStats;  // TODO not sure if it's a string (might be a dictionary/hashmap)

    private boolean useCaseFailed;

    public VideoSearchOutputData (String videoId, String videoAbout, String videoStats, boolean useCaseFailed) {
        this.videoId = videoId;
        this.videoAbout = videoAbout;
        this.videoStats = videoStats;
        this.useCaseFailed = useCaseFailed;
    }

    public String getVideoId() { return videoId; }

    public String getVideoAbout() { return videoAbout; }

    public String getVideoStats() { return videoStats; }


}
