package interface_adapter.trending;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import use_case.trending.TrendingOutputBoundary;
import use_case.trending.TrendingOutputData;

public class TrendingPresenter implements TrendingOutputBoundary {
    private final TrendingSelectViewModel trendingSelectViewModel;
    private final HomeViewModel homeViewModel;
    private ViewManagerModel viewManagerModel;

    public TrendingPresenter(TrendingSelectViewModel trendingSelectViewModel, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {
        this.trendingSelectViewModel = trendingSelectViewModel;
        this.homeViewModel = homeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareDataView(TrendingOutputData data) {
        this.viewManagerModel.setActiveView(trendingSelectViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareSelectView() {

    }
}
