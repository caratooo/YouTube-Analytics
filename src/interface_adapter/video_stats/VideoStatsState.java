package interface_adapter.video_stats;

import com.google.api.client.util.DateTime;

public class VideoStatsState {

    private String videoId = "";

    private String channelName = "";

    private String title = "";

    private String description = "";

    private DateTime videoPublishDate = new DateTime("2013-02-14T13:15:03-08:00");

    private int viewCount = 0;

    private int likeCount = 0;

    private int commentCount = 0;

    public VideoStatsState(VideoStatsState copy) {
        videoId = copy.videoId;
        channelName = copy.channelName;
        title = copy.title;
        description = copy.description;
        videoPublishDate = copy.videoPublishDate;
        viewCount = copy.viewCount;
        likeCount = copy.likeCount;
        commentCount = copy.commentCount;
    }

    public VideoStatsState() {}

    public String getVideoId() { return videoId; }

    public String getChannelName() { return channelName; }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public DateTime getVideoPublishDate() { return videoPublishDate; }

    public int getViewCount() { return viewCount; }

    public int getLikeCount() { return likeCount; }

    public int getCommentCount() {return commentCount; }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVideoPublishDate(DateTime videoPublishDate) {
        this.videoPublishDate = videoPublishDate;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public void setCommentCount(int commentCount) { this.commentCount = commentCount; }

}
