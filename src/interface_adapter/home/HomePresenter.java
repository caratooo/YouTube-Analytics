package interface_adapter.home;

import interface_adapter.ViewManagerModel;
import interface_adapter.channel_search.ChannelSearchViewModel;
import interface_adapter.compare.CompareViewModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.trending.TrendingViewModel;
import interface_adapter.video_search.VideoSearchViewModel;
import use_case.home.HomeOutputBoundary;

public class HomePresenter implements HomeOutputBoundary {
    private final HomeViewModel homeViewModel;
    private final ChannelSearchViewModel channelSearchViewModel;
    private final CompareViewModel compareViewModel;
    private final HistoryViewModel historyViewModel;

    private final VideoSearchViewModel videoSearchViewModel;
    private final TrendingViewModel trendingViewModel;

    private ViewManagerModel viewManagerModel;

    public HomePresenter(HomeViewModel homeViewModel, ChannelSearchViewModel channelSearchViewModel, CompareViewModel compareViewModel, HistoryViewModel historyViewModel, VideoSearchViewModel videoSearchViewModel, TrendingViewModel trendingViewModel, ViewManagerModel viewManagerModel) {
        this.homeViewModel = homeViewModel;
        this.channelSearchViewModel = channelSearchViewModel;
        this.compareViewModel = compareViewModel;
        this.historyViewModel = historyViewModel;
        this.videoSearchViewModel = videoSearchViewModel;
        this.trendingViewModel = trendingViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(){

    }
}
