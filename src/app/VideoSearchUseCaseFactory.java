package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.video_search.VideoSearchController;
import interface_adapter.video_search.VideoSearchPresenter;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import use_case.video_search.VideoSearchDataAccessInterface;
import use_case.video_search.VideoSearchInputBoundary;
import use_case.video_search.VideoSearchInteractor;
import use_case.video_search.VideoSearchOutputBoundary;
import views.VideoSearchView;

import javax.swing.*;
import java.io.IOException;

public class VideoSearchUseCaseFactory {

    private VideoSearchUseCaseFactory() {}

    public static VideoSearchView create(
            ViewManagerModel viewManagerModel,
            VideoSearchViewModel videoSearchViewModel,
            VideoStatsViewModel videoStatsViewModel,
            HomeViewModel homeViewModel,
            VideoSearchDataAccessInterface youtubeDataAccessObject) {

        try {
            VideoSearchController videoSearchController = createVideoSearchUseCase(viewManagerModel, videoSearchViewModel, videoStatsViewModel, youtubeDataAccessObject);
            return new VideoSearchView(videoSearchController, videoSearchViewModel, homeViewModel, viewManagerModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static VideoSearchController createVideoSearchUseCase(
            ViewManagerModel viewManagerModel,
            VideoSearchViewModel videoSearchViewModel,
            VideoStatsViewModel videoStatsViewModel,
            VideoSearchDataAccessInterface youtubeDataAccessObject) throws IOException {

        VideoSearchOutputBoundary videoSearchOutputBoundary = new VideoSearchPresenter(videoSearchViewModel, videoStatsViewModel, viewManagerModel);

        VideoSearchInputBoundary videoSearchInteractor = new VideoSearchInteractor(youtubeDataAccessObject, videoSearchOutputBoundary);

        return new VideoSearchController(videoSearchInteractor);

    }




}
