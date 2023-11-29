package interface_adapter.trending;

import entities.Video;

public class TrendingDataState {
    private String topOneVideoId;
    private String topOneTitle;

    private String topOneDescription;
    private int topOneViewCount;

    private int topOneLikeCount;

    private int topOneCommentCount;

    private String topTwoVideoId;
    private String topTwoTitle;

    private String topTwoDescription;
    private int topTwoViewCount;

    private int topTwoLikeCount;

    private int topTwoCommentCount;

    private String topThreeVideoId;
    private String topThreeTitle;

    private String topThreeDescription;
    private int topThreeViewCount;

    private int topThreeLikeCount;

    private int topThreeCommentCount;

    public TrendingDataState(TrendingDataState copy) {
        topOneVideoId = copy.topOneVideoId;
        topOneTitle = copy.topOneTitle;
        topOneDescription = copy.topOneDescription;
        topOneViewCount = copy.topOneViewCount;
        topOneLikeCount = copy.topOneLikeCount;
        topOneCommentCount = copy.topOneCommentCount;
        topTwoVideoId = copy.topTwoVideoId;
        topTwoTitle = copy.topTwoTitle;
        topTwoDescription = copy.topTwoDescription;
        topTwoViewCount = copy.topTwoViewCount;
        topTwoLikeCount = copy.topTwoLikeCount;
        topTwoCommentCount = copy.topTwoCommentCount;
        topThreeVideoId = copy.topThreeVideoId;
        topThreeTitle = copy.topThreeTitle;
        topThreeDescription = copy.topThreeDescription;
        topThreeViewCount = copy.topThreeViewCount;
        topThreeLikeCount = copy.topThreeLikeCount;
        topThreeCommentCount = copy.topThreeCommentCount;

    }

    public TrendingDataState() {

    }

    public String getTopOneVideoId() {
        return topOneVideoId;
    }

    public void setTopOneVideoId(String videoId) {
        this.topOneVideoId = videoId;
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

    public int getTopOneLikeCount() {
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
    public String getTopThreeTitle() {
        return topThreeTitle;
    }
    public String getTopThreeDescription() {
        return topThreeDescription;
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
