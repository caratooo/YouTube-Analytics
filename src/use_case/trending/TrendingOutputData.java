package use_case.trending;

import com.google.api.client.util.DateTime;
import entities.Video;

public class TrendingOutputData {
    private final String category;
    private final String topOneVideoId;
    private final String topOneChannelName;
    private final String topOneTitle;
    private final String topOneDescription;
    private final DateTime topOnePublishDate;
    private final int topOneViewCount;
    private final int topOneLikeCount;
    private final int topOneCommentCount;

    private final String topTwoVideoId;
    private final String topTwoChannelName;
    private final String topTwoTitle;
    private final String topTwoDescription;
    private final DateTime topTwoPublishDate;
    private final int topTwoViewCount;
    private final int topTwoLikeCount;
    private final int topTwoCommentCount;
    private final String topThreeVideoId;
    private final String topThreeChannelName;
    private final String topThreeTitle;
    private final String topThreeDescription;
    private final DateTime topThreePublishDate;
    private final int topThreeViewCount;
    private final int topThreeLikeCount;
    private final int topThreeCommentCount;

    public TrendingOutputData(String category, String topOneVideoId, String topOneChannelName, String topOneTitle, String topOneDescription, DateTime topOnePublishDate, int topOneViewCount, int topOneLikeCount, int topOneCommentCount, String topTwoVideoId, String topTwoChannelName, String topTwoTitle, String topTwoDescription, DateTime topTwoPublishDate, int topTwoViewCount, int topTwoLikeCount, int topTwoCommentCount, String topThreeVideoId, String topThreeChannelName, String topThreeTitle, String topThreeDescription, DateTime topThreePublishDate, int topThreeViewCount, int topThreeLikeCount, int topThreeCommentCount) {
        this.category = category;

        this.topOneVideoId = topOneVideoId;
        this.topOneChannelName = topOneChannelName;
        this.topOneTitle = topOneTitle;
        this.topOneDescription = topOneDescription;
        this.topOnePublishDate = topOnePublishDate;
        this.topOneViewCount = topOneViewCount;
        this.topOneLikeCount = topOneLikeCount;
        this.topOneCommentCount = topOneCommentCount;

        this.topTwoVideoId = topTwoVideoId;
        this.topTwoChannelName = topTwoChannelName;
        this.topTwoTitle = topTwoTitle;
        this.topTwoDescription = topTwoDescription;
        this.topTwoPublishDate = topTwoPublishDate;
        this.topTwoViewCount = topTwoViewCount;
        this.topTwoLikeCount = topTwoLikeCount;
        this.topTwoCommentCount = topTwoCommentCount;

        this.topThreeVideoId = topThreeVideoId;
        this.topThreeChannelName = topThreeChannelName;
        this.topThreeTitle = topThreeTitle;
        this.topThreeDescription = topThreeDescription;
        this.topThreePublishDate = topThreePublishDate;
        this.topThreeViewCount = topThreeViewCount;
        this.topThreeLikeCount = topThreeLikeCount;
        this.topThreeCommentCount = topThreeCommentCount;
    }

    public String getCategory() {
        return category;
    }

    public String getTopOneVideoId() {
        return topOneVideoId;
    }

    public String getTopOneChannelName() {
        return topOneChannelName;
    }

    public String getTopOneTitle() {
        return topOneTitle;
    }
    public String getTopOneDescription() {
        return topOneDescription;
    }

    public DateTime getTopOnePublishDate() {
        return topOnePublishDate;
    }

    public int getTopOneViewCount() {
        return topOneViewCount;
    }

    public int getTopOneLikeCount() {
        return topOneLikeCount;
    }

    public int getTopOneCommentCount() {
        return topOneCommentCount;
    }

    public String getTopTwoVideoId() {
        return topTwoVideoId;
    }

    public String getTopTwoChannelName() {
        return topTwoChannelName;
    }

    public String getTopTwoTitle() {
        return topTwoTitle;
    }
    public String getTopTwoDescription() {
        return topTwoDescription;
    }

    public DateTime getTopTwoPublishDate() {
        return topTwoPublishDate;
    }

    public int getTopTwoViewCount() {
        return topTwoViewCount;
    }

    public int getTopTwoLikeCount() {
        return topTwoLikeCount;
    }

    public int getTopTwoCommentCount() {
        return topTwoCommentCount;
    }

    public String getTopThreeVideoId() {
        return topThreeVideoId;
    }

    public String getTopThreeChannelName() {
        return topThreeChannelName;
    }

    public String getTopThreeTitle() {
        return topThreeTitle;
    }
    public String getTopThreeDescription() {
        return topThreeDescription;
    }

    public DateTime getTopThreePublishDate() {
        return topThreePublishDate;
    }

    public int getTopThreeViewCount() {
        return topThreeViewCount;
    }

    public int getTopThreeLikeCount() {
        return topThreeLikeCount;
    }

    public int getTopThreeCommentCount() {
        return topThreeCommentCount;
    }

}
