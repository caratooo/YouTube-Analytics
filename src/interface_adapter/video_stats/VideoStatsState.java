package interface_adapter.video_stats;

public class VideoStatsState {

    private String videoId = "";

    private String stats = "";

    private String about = "";

    public VideoStatsState(VideoStatsState copy) {
        videoId = copy.videoId;
        stats = copy.stats;
        about = copy.about;
    }

    public VideoStatsState() {}

    public String getVideoId() {
        return this.videoId;
    }

    public String getVideoStats() {
        return this.stats;
    }

    public String getVideoAbout() {
        return this.about;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public void setVideoStats(String videoStats) {
        this.stats = videoStats;
    }

    public void setVideoAbout(String videoAbout) {
        this.about = videoAbout;
    }
}
