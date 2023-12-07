package interface_adapter.video_search;

import interface_adapter.ViewManagerModel;
import interface_adapter.video_stats.VideoStatsState;
import interface_adapter.video_stats.VideoStatsViewModel;
import use_case.video_search.VideoSearchOutputBoundary;
import use_case.video_search.VideoSearchOutputData;

public class VideoSearchPresenter implements VideoSearchOutputBoundary {

    private final VideoSearchViewModel videoSearchViewModel;

    private final VideoStatsViewModel videoStatsViewModel;

    private final ViewManagerModel viewManagerModel;

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
        videoStatsState.setChannelName(video.getChannelName());
        videoStatsState.setTitle(video.getTitle());
        videoStatsState.setDescription(video.getDescription());
        videoStatsState.setVideoPublishDate(video.getVideoPublishDate());
        videoStatsState.setViewCount(video.getViewCount());
        videoStatsState.setLikeCount(video.getLikeCount());
        videoStatsState.setCommentCount(video.getCommentCount());
        videoStatsState.setChannelInfo(video.getChannelInfo());
        this.videoStatsViewModel.setState(videoStatsState);
        videoStatsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(videoStatsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        VideoSearchState videoSearchState = videoSearchViewModel.getState();
        videoSearchState.setVideoIdError(error);
        videoSearchViewModel.firePropertyChanged();
    }
}
