package interface_adapter.trending;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import use_case.trending.TrendingOutputBoundary;
import use_case.trending.TrendingOutputData;

public class TrendingPresenter implements TrendingOutputBoundary {
    private final TrendingViewModel trendingViewModel;
    private final HomeViewModel homeViewModel;
    private ViewManagerModel viewManagerModel;

    public TrendingPresenter(TrendingViewModel trendingViewModel, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {
        this.trendingViewModel = trendingViewModel;
        this.homeViewModel = homeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareDataView(TrendingOutputData data) {
        this.viewManagerModel.setActiveView(trendingViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareSelectView() {

    }
}
