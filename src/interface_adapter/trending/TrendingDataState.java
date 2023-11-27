package interface_adapter.trending;

public class TrendingDataState {
    private Integer category = null;

    public TrendingDataState(TrendingDataState copy) {
        category = copy.category;
//        videoIdError = copy.videoIdError;
    }

    public TrendingDataState() {

    }

    public Integer getCategoryId() { return category; }

//    public String getVideoIdError() { return videoIdError; }

    public void setCategoryId(Integer category) { this.category = category; }
}
