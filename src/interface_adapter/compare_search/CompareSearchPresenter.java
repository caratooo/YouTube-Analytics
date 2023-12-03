package interface_adapter.compare_search;

import interface_adapter.ViewManagerModel;
import interface_adapter.compare_stats.CompareStatsState;
import interface_adapter.compare_stats.CompareStatsViewModel;
import use_case.compare_videos.CompareSearchOutputBoundary;
import use_case.compare_videos.CompareSearchOutputData;

public class CompareSearchPresenter implements CompareSearchOutputBoundary {

    private final CompareSearchViewModel compareSearchViewModel;

    private final CompareStatsViewModel compareStatsViewModel;

    private final ViewManagerModel viewManagerModel;

    public CompareSearchPresenter(CompareSearchViewModel compareSearchViewModel, CompareStatsViewModel compareStatsViewModel, ViewManagerModel viewManagerModel) {
        this.compareSearchViewModel = compareSearchViewModel;
        this.compareStatsViewModel = compareStatsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CompareSearchOutputData video) {
        CompareStatsState compareStatsState = compareStatsViewModel.getState();
        compareStatsState.setVideoIdOne(video.getVideoIdOne());
        compareStatsState.setChannelNameOne(video.getChannelNameOne());
        compareStatsState.setTitleOne(video.getTitleOne());
        compareStatsState.setDescriptionOne(video.getDescriptionOne());
        compareStatsState.setVideoPublishDateOne(video.getVideoPublishDateOne());
        compareStatsState.setViewCountOne(video.getViewCountOne());
        compareStatsState.setLikeCountOne(video.getLikeCountOne());
        compareStatsState.setCommentCountOne(video.getCommentCountOne());

        compareStatsState.setVideoIdTwo(video.getVideoIdTwo());
        compareStatsState.setChannelNameTwo(video.getChannelNameTwo());
        compareStatsState.setTitleTwo(video.getTitleTwo());
        compareStatsState.setDescriptionTwo(video.getDescriptionTwo());
        compareStatsState.setVideoPublishDateTwo(video.getVideoPublishDateTwo());
        compareStatsState.setViewCountTwo(video.getViewCountTwo());
        compareStatsState.setLikeCountTwo(video.getLikeCountTwo());
        compareStatsState.setCommentCountTwo(video.getCommentCountTwo());

        this.compareStatsViewModel.setState(compareStatsState);
        compareStatsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(compareStatsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        CompareSearchState compareSearchState = compareSearchViewModel.getState();
        compareSearchState.setVideoIdError(error);
        compareSearchViewModel.firePropertyChanged();
    }
}
