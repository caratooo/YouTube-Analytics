package interface_adapter.video_search;

import interface_adapter.ViewManagerModel;
import use_case.video_search.VideoSearchOutputBoundary;
import use_case.video_search.VideoSearchOutputData;

public class VideoSearchPresenter implements VideoSearchOutputBoundary {

    private final VideoSearchViewModel videoSearchViewModel;

    private final VideoStatsViewModel videoStatsViewModel;

    private ViewManagerModel viewManagerModel;

    public VideoSearchPresenter(VideoSearchViewModel videoSearchViewModel,
                                VideoStatsViewModel videoStatsViewModel,
                                ViewManagerModel viewManagerModel) {
        this.videoSearchViewModel = videoSearchViewModel;
        this.videoStatsViewModel = videoStatsViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(VideoSearchOutputData video) {

        VideoStatsState videoStatsState = videoStatsViewModel.getState();
        videoStatsState.setVideoId(video.getVideoId());
        videoStatsState.setVideoStats(video.getVideoStats());
        videoStatsState.setVideoAbout(video.getVideoAbout());
        this.videoStatsViewModel.setState(videoStatsState);
        this.videoStatsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(videoStatsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        VideoSearchState videoSearchState = videoSearchViewModel.getState();
        videoSearchState.setVideoIdError(error);  // TODO see comments of VideoSearchState
        videoSearchViewModel.firePropertyChanged();
    }
}
