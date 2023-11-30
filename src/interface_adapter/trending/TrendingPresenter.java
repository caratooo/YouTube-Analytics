package interface_adapter.trending;

import interface_adapter.ViewManagerModel;
import use_case.trending.TrendingOutputBoundary;
import use_case.trending.TrendingOutputData;

public class TrendingPresenter implements TrendingOutputBoundary {
    private final TrendingCategorySelectViewModel trendingCategorySelectViewModel;
    private final TrendingDataViewModel trendingDataViewModel;
    private ViewManagerModel viewManagerModel;

    public TrendingPresenter(TrendingCategorySelectViewModel trendingCategorySelectViewModel, TrendingDataViewModel trendingDataViewModel, ViewManagerModel viewManagerModel) {
        this.trendingCategorySelectViewModel = trendingCategorySelectViewModel;
        this.trendingDataViewModel = trendingDataViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareDataView(TrendingOutputData data) {
        TrendingDataState trendingDataState = trendingDataViewModel.getState();
        trendingDataState.setTopOneVideoId(data.getTopOneVideoId());
        trendingDataState.setTopOneTitle(data.getTopOneTitle());
        trendingDataState.setTopOneDescription(data.getTopOneDescription());
        trendingDataState.setTopOneViewCount(data.getTopOneViewCount());
        trendingDataState.setTopOneLikeCount(data.getTopOneLikeCount());
        trendingDataState.setTopOneCommentCount(data.getTopOneCommentCount());

        trendingDataState.setTopTwoVideoId(data.getTopTwoVideoId());
        trendingDataState.setTopTwoTitle(data.getTopTwoTitle());
        trendingDataState.setTopTwoDescription(data.getTopTwoDescription());
        trendingDataState.setTopTwoViewCount(data.getTopTwoViewCount());
        trendingDataState.setTopTwoLikeCount(data.getTopTwoLikeCount());
        trendingDataState.setTopTwoCommentCount(data.getTopTwoCommentCount());

        trendingDataState.setTopThreeVideoId(data.getTopThreeVideoId());
        trendingDataState.setTopThreeTitle(data.getTopThreeTitle());
        trendingDataState.setTopThreeDescription(data.getTopThreeDescription());
        trendingDataState.setTopThreeViewCount(data.getTopThreeViewCount());
        trendingDataState.setTopThreeLikeCount(data.getTopThreeLikeCount());
        trendingDataState.setTopThreeCommentCount(data.getTopThreeCommentCount());

        this.trendingDataViewModel.setState(trendingDataState);
        trendingDataViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(trendingDataViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

}
