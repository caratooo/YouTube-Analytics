package use_case.compare_videos;

import com.google.api.client.util.DateTime;

public class CompareSearchOutputData{
    private final String videoIdOne;

    private final String channelNameOne;

    private final String titleOne;

    private final String descriptionOne;

    private final DateTime videoPublishDateOne;

    private final int viewCountOne;

    private final int likeCountOne;

    private final int commentCountOne;
    private final String videoIdTwo;

    private final String channelNameTwo;

    private final String titleTwo;

    private final String descriptionTwo;

    private final DateTime videoPublishDateTwo;

    private final int viewCountTwo;

    private final int likeCountTwo;

    public CompareSearchOutputData(String videoIdOne, String channelNameOne, String titleOne, String descriptionOne, DateTime videoPublishDateOne, int viewCountOne, int likeCountOne, int commentCountOne, String videoIdTwo, String channelNameTwo, String titleTwo, String descriptionTwo, DateTime videoPublishDateTwo, int viewCountTwo, int likeCountTwo, int commentCountTwo, boolean useCaseFailed) {
        this.videoIdOne = videoIdOne;
        this.channelNameOne = channelNameOne;
        this.titleOne = titleOne;
        this.descriptionOne = descriptionOne;
        this.videoPublishDateOne = videoPublishDateOne;
        this.viewCountOne = viewCountOne;
        this.likeCountOne = likeCountOne;
        this.commentCountOne = commentCountOne;
        this.videoIdTwo = videoIdTwo;
        this.channelNameTwo = channelNameTwo;
        this.titleTwo = titleTwo;
        this.descriptionTwo = descriptionTwo;
        this.videoPublishDateTwo = videoPublishDateTwo;
        this.viewCountTwo = viewCountTwo;
        this.likeCountTwo = likeCountTwo;
        this.commentCountTwo = commentCountTwo;
        this.useCaseFailed = useCaseFailed;
    }
    public String getVideoIdOne() {
        return videoIdOne;
    }

    public String getChannelNameOne() {
        return channelNameOne;
    }

    public String getTitleOne() {
        return titleOne;
    }

    public String getDescriptionOne() {
        return descriptionOne;
    }

    public DateTime getVideoPublishDateOne() {
        return videoPublishDateOne;
    }

    public int getViewCountOne() {
        return viewCountOne;
    }

    public int getLikeCountOne() {
        return likeCountOne;
    }

    public int getCommentCountOne() {
        return commentCountOne;
    }

    public String getVideoIdTwo() {
        return videoIdTwo;
    }

    public String getChannelNameTwo() {
        return channelNameTwo;
    }

    public String getTitleTwo() {
        return titleTwo;
    }

    public String getDescriptionTwo() {
        return descriptionTwo;
    }

    public DateTime getVideoPublishDateTwo() {
        return videoPublishDateTwo;
    }

    public int getViewCountTwo() {
        return viewCountTwo;
    }

    public int getLikeCountTwo() {
        return likeCountTwo;
    }

    public int getCommentCountTwo() {
        return commentCountTwo;
    }

    private final int commentCountTwo;

    private boolean useCaseFailed;

    public String toString(){
        return videoIdOne + "," +
                channelNameOne + "," +
                titleOne + "," +
                descriptionOne + "," +
                videoPublishDateOne.toString() + "," +
                viewCountOne + "," +
                likeCountOne + "," +
                commentCountOne + "," +
                videoIdTwo + "," +
                channelNameTwo + "," +
                titleTwo + "," +
                descriptionTwo + "," +
                videoPublishDateTwo.toString() + "," +
                viewCountTwo + "," +
                likeCountTwo + "," +
                commentCountTwo;
    }


}
