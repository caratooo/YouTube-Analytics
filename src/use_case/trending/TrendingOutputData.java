package use_case.trending;

import entities.Video;

public class TrendingOutputData {
    private final String topOneVideoId;
    private final String topOneTitle;

    private final String topOneDescription;
    private final int topOneViewCount;

    private final int topOneLikeCount;

    private final int topOneCommentCount;

    private final String topTwoVideoId;
    private final String topTwoTitle;

    private final String topTwoDescription;
    private final int topTwoViewCount;

    private final int topTwoLikeCount;

    private final int topTwoCommentCount;

    private final String topThreeVideoId;
    private final String topThreeTitle;

    private final String topThreeDescription;
    private final int topThreeViewCount;

    private final int topThreeLikeCount;

    private final int topThreeCommentCount;

    public TrendingOutputData(String topOneVideoId, String topOneTitle, String topOneDescription, int topOneViewCount, int topOneLikeCount, int topOneCommentCount, String topTwoVideoId, String topTwoTitle, String topTwoDescription, int topTwoViewCount, int topTwoLikeCount, int topTwoCommentCount, String topThreeVideoId, String topThreeTitle, String topThreeDescription, int topThreeViewCount, int topThreeLikeCount, int topThreeCommentCount) {
        this.topOneVideoId = topOneVideoId;
        this.topOneTitle = topOneTitle;
        this.topOneDescription = topOneDescription;
        this.topOneViewCount = topOneViewCount;
        this.topOneLikeCount = topOneLikeCount;
        this.topOneCommentCount = topOneCommentCount;
        this.topTwoVideoId = topTwoVideoId;
        this.topTwoTitle = topTwoTitle;
        this.topTwoDescription = topTwoDescription;
        this.topTwoViewCount = topTwoViewCount;
        this.topTwoLikeCount = topTwoLikeCount;
        this.topTwoCommentCount = topTwoCommentCount;
        this.topThreeVideoId = topThreeVideoId;
        this.topThreeTitle = topThreeTitle;
        this.topThreeDescription = topThreeDescription;
        this.topThreeViewCount = topThreeViewCount;
        this.topThreeLikeCount = topThreeLikeCount;
        this.topThreeCommentCount = topThreeCommentCount;
    }

    public String getTopOneVideoId() {
        return topOneVideoId;
    }
    public String getTopOneTitle() {
        return topOneTitle;
    }
    public String getTopOneDescription() {
        return topOneDescription;
    }

    public int getTopOneViewCount() {
        return topOneViewCount;
    }

    public int getTopOnelikeCount() {
        return topOneLikeCount;
    }

    public int getTopOneCommentCount() {
        return topOneCommentCount;
    }

    public String getTopTwoVideoId() {
        return topTwoVideoId;
    }
    public String getTopTwoTitle() {
        return topTwoTitle;
    }
    public String getTopTwoDescription() {
        return topTwoDescription;
    }

    public int getToptwoViewCount() {
        return topTwoViewCount;
    }

    public int getTopTwolikeCount() {
        return topTwoLikeCount;
    }

    public int getTopTwoCommentCount() {
        return topTwoCommentCount;
    }

    public String getTopThreeVideoId() {
        return topThreeVideoId;
    }
    public String getTopThreeTitle() {
        return topThreeTitle;
    }
    public String getTopThreeDescription() {
        return topThreeDescription;
    }

    public int getTopThreeViewCount() {
        return topThreeViewCount;
    }

    public int getTopThreelikeCount() {
        return topThreeLikeCount;
    }

    public int getTopThreeCommentCount() {
        return topThreeCommentCount;
    }

}
