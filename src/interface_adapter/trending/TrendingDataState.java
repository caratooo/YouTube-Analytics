package interface_adapter.trending;

import com.google.api.client.util.DateTime;
import entities.Video;

public class TrendingDataState {
    private String category = "0";
    private String topOneVideoId = "";
    private String topOneChannelName = "";
    private String topOneTitle = "";
    private String topOneDescription = "";
    private DateTime topOneVideoPublishDate = new DateTime("2013-02-14T13:15:03-08:00");
    private int topOneViewCount = 0;
    private int topOneLikeCount = 0;
    private int topOneCommentCount = 0;

    private String topTwoVideoId = "";
    private String topTwoChannelName = "";
    private String topTwoTitle = "";
    private String topTwoDescription = "";
    private DateTime topTwoVideoPublishDate = new DateTime("2013-02-14T13:15:03-08:00");
    private int topTwoViewCount = 0;
    private int topTwoLikeCount = 0;
    private int topTwoCommentCount = 0;

    private String topThreeVideoId = "";
    private String topThreeChannelName = "";
    private String topThreeTitle = "";
    private String topThreeDescription = "";
    private DateTime topThreeVideoPublishDate = new DateTime("2013-02-14T13:15:03-08:00");
    private int topThreeViewCount = 0;
    private int topThreeLikeCount = 0;
    private int topThreeCommentCount = 0;

    public TrendingDataState(TrendingDataState copy) {
        category = copy.category;
        topOneVideoId = copy.topOneVideoId;
        topOneChannelName = copy.topOneChannelName;
        topOneTitle = copy.topOneTitle;
        topOneDescription = copy.topOneDescription;
        topOneVideoPublishDate = copy.topOneVideoPublishDate;
        topOneViewCount = copy.topOneViewCount;
        topOneLikeCount = copy.topOneLikeCount;
        topOneCommentCount = copy.topOneCommentCount;

        topTwoVideoId = copy.topTwoVideoId;
        topTwoChannelName = copy.topTwoChannelName;
        topTwoTitle = copy.topTwoTitle;
        topTwoDescription = copy.topTwoDescription;
        topTwoVideoPublishDate = copy.topTwoVideoPublishDate;
        topTwoViewCount = copy.topTwoViewCount;
        topTwoLikeCount = copy.topTwoLikeCount;
        topTwoCommentCount = copy.topTwoCommentCount;

        topThreeVideoId = copy.topThreeVideoId;
        topThreeChannelName = copy.topThreeChannelName;
        topThreeTitle = copy.topThreeTitle;
        topThreeDescription = copy.topThreeDescription;
        topThreeVideoPublishDate = copy.topThreeVideoPublishDate;
        topThreeViewCount = copy.topThreeViewCount;
        topThreeLikeCount = copy.topThreeLikeCount;
        topThreeCommentCount = copy.topThreeCommentCount;

    }

    public TrendingDataState() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTopOneVideoId() {
        return topOneVideoId;
    }

    public void setTopOneVideoId(String videoId) {
        this.topOneVideoId = videoId;
    }


    public String getTopOneChannelName() {
        return topOneChannelName;
    }

    public void setTopOneChannelName(String name){
        this.topOneChannelName = name;
    }

    public String getTopOneTitle() {
        return topOneTitle;
    }

    public void setTopOneTitle(String title) {
        this.topOneTitle = title;
    }

    public String getTopOneDescription() {
        return topOneDescription;
    }

    public DateTime getTopOneVideoPublishDate(){return topOneVideoPublishDate;}
    public void setTopOneVideoPublishDate(DateTime time){this.topOneVideoPublishDate = time;}

    public void setTopOneDescription(String description) {
        this.topOneDescription = description;
    }

    public int getTopOneViewCount() {
        return topOneViewCount;
    }

    public void setTopOneViewCount(int count) {
        this.topOneViewCount = count;
    }

    public int getTopOneLikeCount() {
        return topOneLikeCount;
    }

    public void setTopOneLikeCount(int count) {
        this.topOneLikeCount = count;
    }

    public int getTopOneCommentCount() {
        return topOneCommentCount;
    }

    public void setTopOneCommentCount(int count) {
        this.topOneCommentCount = count;
    }


    public String getTopTwoVideoId() {
        return topTwoVideoId;
    }

    public void setTopTwoVideoId(String videoId) {
        this.topTwoVideoId = videoId;
    }
    public String getTopTwoChannelName() {return topTwoChannelName;}
    public void setTopTwoChannelName(String name){this.topTwoChannelName = name;}
    public String getTopTwoTitle() {
        return topTwoTitle;
    }
    public void setTopTwoTitle(String title) {
        this.topTwoTitle = title;
    }
    public String getTopTwoDescription() {
        return topTwoDescription;
    }
    public void setTopTwoDescription(String description) {this.topTwoDescription = description;}
    public DateTime getTopTwoVideoPublishDate(){return topTwoVideoPublishDate;}
    public void setTopTwoVideoPublishDate(DateTime time){this.topTwoVideoPublishDate = time;}
    public int getTopTwoViewCount() {
        return topTwoViewCount;
    }
    public void setTopTwoViewCount(int count) {
        this.topTwoViewCount = count;
    }
    public int getTopTwoLikeCount() {
        return topTwoLikeCount;
    }
    public void setTopTwoLikeCount(int count) {
        this.topTwoLikeCount = count;
    }
    public int getTopTwoCommentCount() {
        return topTwoCommentCount;
    }
    public void setTopTwoCommentCount(int count) {
        this.topTwoCommentCount = count;
    }


    public String getTopThreeVideoId() {
        return topThreeVideoId;
    }
    public void setTopThreeVideoId(String videoId) {
        this.topThreeVideoId = videoId;
    }
    public String getTopThreeChannelName() {return topThreeChannelName;}
    public void setTopThreeChannelName(String name){this.topThreeChannelName = name;}
    public String getTopThreeTitle() {
        return topThreeTitle;
    }
    public void setTopThreeTitle(String title) {
        this.topThreeTitle = title;
    }
    public String getTopThreeDescription() {
        return topThreeDescription;
    }
    public void setTopThreeDescription(String description) {
        this.topThreeDescription = description;
    }
    public DateTime getTopThreeVideoPublishDate(){return topThreeVideoPublishDate;}
    public void setTopThreeVideoPublishDate(DateTime time){this.topThreeVideoPublishDate = time;}
    public int getTopThreeViewCount() {
        return topThreeViewCount;
    }
    public void setTopThreeViewCount(int count) {
        this.topThreeViewCount = count;
    }


    public int getTopThreeLikeCount() {
        return topThreeLikeCount;
    }

    public void setTopThreeLikeCount(int count) {
        this.topThreeLikeCount = count;
    }

    public int getTopThreeCommentCount() {
        return topThreeCommentCount;
    }

    public void setTopThreeCommentCount(int count) {
        this.topThreeCommentCount = count;
    }


}
