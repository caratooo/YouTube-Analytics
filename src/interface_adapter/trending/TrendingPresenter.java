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
        this.viewManagerModel.setActiveView(trendingDataViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

}
