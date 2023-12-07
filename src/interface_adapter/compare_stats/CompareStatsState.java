package interface_adapter.compare_stats;

import com.google.api.client.util.DateTime;

public class CompareStatsState {
    private String videoIdOne = "";

    private String channelNameOne = "";

    private String titleOne = "";

    private String descriptionOne = "";

    private DateTime videoPublishDateOne = new DateTime("2013-02-14T13:15:03-08:00");

    private int viewCountOne = 0;

    private int likeCountOne = 0;

    private int commentCountOne = 0;
    private String videoIdTwo = "";

    private String channelNameTwo = "";

    private String titleTwo = "";

    private String descriptionTwo = "";

    private DateTime videoPublishDateTwo = new DateTime("2013-02-14T13:15:03-08:00");

    private int viewCountTwo = 0;

    private int likeCountTwo = 0;

    private int commentCountTwo = 0;

    public CompareStatsState(){}
    public CompareStatsState(CompareStatsState copy) {
        videoIdOne = copy.videoIdOne;
        channelNameOne = copy.channelNameOne;
        titleOne = copy.titleOne;
        descriptionOne = copy.descriptionOne;
        videoPublishDateOne = copy.videoPublishDateOne;
        viewCountOne = copy.viewCountOne;
        likeCountOne = copy.likeCountOne;
        commentCountOne = copy.commentCountOne;
        videoIdTwo = copy.videoIdTwo;
        channelNameTwo = copy.channelNameTwo;
        titleTwo = copy.titleTwo;
        descriptionTwo = copy.descriptionTwo;
        videoPublishDateTwo = copy.videoPublishDateTwo;
        viewCountTwo = copy.viewCountTwo;
        likeCountTwo = copy.likeCountTwo;
        commentCountTwo = copy.commentCountTwo;
    }
    public String getVideoIdOne() {
        return videoIdOne;
    }

    public void setVideoIdOne(String videoIdOne) {
        this.videoIdOne = videoIdOne;
    }

    public String getChannelNameOne() {
        return channelNameOne;
    }

    public void setChannelNameOne(String channelNameOne) {
        this.channelNameOne = channelNameOne;
    }

    public String getTitleOne() {
        return titleOne;
    }

    public void setTitleOne(String titleOne) {
        this.titleOne = titleOne;
    }

    public String getDescriptionOne() {
        return descriptionOne;
    }

    public void setDescriptionOne(String descriptionOne) {
        this.descriptionOne = descriptionOne;
    }

    public DateTime getVideoPublishDateOne() {
        return videoPublishDateOne;
    }

    public void setVideoPublishDateOne(DateTime videoPublishDateOne) {
        this.videoPublishDateOne = videoPublishDateOne;
    }

    public int getViewCountOne() {
        return viewCountOne;
    }

    public void setViewCountOne(int viewCountOne) {
        this.viewCountOne = viewCountOne;
    }

    public int getLikeCountOne() {
        return likeCountOne;
    }

    public void setLikeCountOne(int likeCountOne) {
        this.likeCountOne = likeCountOne;
    }

    public int getCommentCountOne() {
        return commentCountOne;
    }

    public void setCommentCountOne(int commentCountOne) {
        this.commentCountOne = commentCountOne;
    }

    public String getVideoIdTwo() {
        return videoIdTwo;
    }

    public void setVideoIdTwo(String videoIdTwo) {
        this.videoIdTwo = videoIdTwo;
    }

    public String getChannelNameTwo() {
        return channelNameTwo;
    }

    public void setChannelNameTwo(String channelNameTwo) {
        this.channelNameTwo = channelNameTwo;
    }

    public String getTitleTwo() {
        return titleTwo;
    }

    public void setTitleTwo(String titleTwo) {
        this.titleTwo = titleTwo;
    }

    public String getDescriptionTwo() {
        return descriptionTwo;
    }

    public void setDescriptionTwo(String descriptionTwo) {
        this.descriptionTwo = descriptionTwo;
    }

    public DateTime getVideoPublishDateTwo() {
        return videoPublishDateTwo;
    }

    public void setVideoPublishDateTwo(DateTime videoPublishDateTwo) {
        this.videoPublishDateTwo = videoPublishDateTwo;
    }

    public int getViewCountTwo() {
        return viewCountTwo;
    }

    public void setViewCountTwo(int viewCountTwo) {
        this.viewCountTwo = viewCountTwo;
    }

    public int getLikeCountTwo() {
        return likeCountTwo;
    }

    public void setLikeCountTwo(int likeCountTwo) {
        this.likeCountTwo = likeCountTwo;
    }

    public int getCommentCountTwo() {
        return commentCountTwo;
    }

    public void setCommentCountTwo(int commentCountTwo) {
        this.commentCountTwo = commentCountTwo;
    }


}
