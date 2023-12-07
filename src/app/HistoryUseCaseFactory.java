package app;

import interface_adapter.SearchController;
import interface_adapter.ViewManagerModel;
import interface_adapter.compare.CompareController;
import interface_adapter.compare_search.CompareSearchController;
import interface_adapter.compare_search.CompareSearchPresenter;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.history.HistoryController;
import interface_adapter.history.HistoryPresenter;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.video_search.VideoSearchController;
import interface_adapter.video_search.VideoSearchPresenter;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import use_case.compare_videos.*;
import use_case.history.HistoryDataAccessInterface;
import use_case.history.HistoryInputBoundary;
import use_case.history.HistoryInteractor;
import use_case.history.HistoryOutputBoundary;
import use_case.video_search.*;
import views.HistoryView;

import javax.swing.*;
import java.io.IOException;

public class HistoryUseCaseFactory {

    /** Prevent instantiation. */
    HistoryUseCaseFactory() {}

    /**
     *
     * @param viewManagerModel the view manager model to switch views
     * @param historyViewModel the history view model for view manager model to switch to
     * @param historyDataAccessInterface the DAO for history
     * @param homeViewModel the home view model
     * @param videoSearchViewModel the video search view model for view manager model to switch to
     * @param videoStatsViewModel the video stats view model for view manager model to switch to
     * @param youtubeDataAccessObject the DAO for YouTube API calling
     * @param userDataAccessInterface the DAO for history
     * @param compareSearchViewModel the compare search view model for view manager model to switch to
     * @param compareStatsViewModel the compare stats view model for view manager model to switch to
     * @param compareYoutubeDataAccessObject the DAO for YouTube API calling
     * @param compareUserDataAccessInterface the DAO for history
     * @return the history view
     */
    public static HistoryView create(
            ViewManagerModel viewManagerModel,
            HistoryViewModel historyViewModel,
            HistoryDataAccessInterface historyDataAccessInterface,
            HomeViewModel homeViewModel,
            VideoSearchViewModel videoSearchViewModel,
            VideoStatsViewModel videoStatsViewModel,
            VideoSearchDataAccessInterface youtubeDataAccessObject,
            VideoSearchUserDataAccessInterface userDataAccessInterface,
            CompareSearchViewModel compareSearchViewModel,
            CompareStatsViewModel compareStatsViewModel,
            CompareSearchDataAccessInterface compareYoutubeDataAccessObject,
            CompareSearchUserDataAccessInterface compareUserDataAccessInterface) {

        try {
            HistoryController historyController = createUserHistoryUseCase(
                    viewManagerModel, historyViewModel, historyDataAccessInterface
            );
            SearchController compareController = createCompareSearchUseCase(viewManagerModel, compareSearchViewModel, compareStatsViewModel, compareUserDataAccessInterface, compareYoutubeDataAccessObject);
            SearchController videoSearchController = createVideoSearchUseCase(viewManagerModel, videoSearchViewModel, videoStatsViewModel, userDataAccessInterface, youtubeDataAccessObject);

            return new HistoryView(historyController, historyViewModel, compareController, videoSearchController, homeViewModel, viewManagerModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     *
     * @param viewManagerModel the view manager model to switch views
     * @param historyViewModel the history view model for view manager model to switch to
     * @param historyDataAccessInterface the DAO for history
     * @return the history controller
     * @throws IOException
     */
    public static HistoryController createUserHistoryUseCase(
            ViewManagerModel viewManagerModel,
            HistoryViewModel historyViewModel,
            HistoryDataAccessInterface historyDataAccessInterface) throws IOException {

        HistoryOutputBoundary historyOutputBoundary = new HistoryPresenter(historyViewModel, viewManagerModel);

        HistoryInputBoundary historyInteractor = new HistoryInteractor(historyDataAccessInterface, historyOutputBoundary);

        return new HistoryController(historyInteractor);
    }

    private static VideoSearchController createVideoSearchUseCase(
            ViewManagerModel viewManagerModel,
            VideoSearchViewModel videoSearchViewModel,
            VideoStatsViewModel videoStatsViewModel,
            VideoSearchUserDataAccessInterface userDataAccessInterface,
            VideoSearchDataAccessInterface youtubeDataAccessObject) throws IOException {

        VideoSearchOutputBoundary videoSearchOutputBoundary = new VideoSearchPresenter(videoSearchViewModel, videoStatsViewModel, viewManagerModel);

        VideoSearchInputBoundary videoSearchInteractor = new VideoSearchInteractor(youtubeDataAccessObject, userDataAccessInterface, videoSearchOutputBoundary);

        return new VideoSearchController(videoSearchInteractor);

    }

    private static CompareSearchController createCompareSearchUseCase(
            ViewManagerModel viewManagerModel,
            CompareSearchViewModel compareSearchViewModel,
            CompareStatsViewModel compareStatsViewModel,
            CompareSearchUserDataAccessInterface userDataAccessInterface,
            CompareSearchDataAccessInterface youtubeDataAccessObject) throws IOException {

        CompareSearchOutputBoundary compareSearchOutputBoundary = new CompareSearchPresenter(compareSearchViewModel, compareStatsViewModel, viewManagerModel);

        CompareSearchInputBoundary compareSearchInteractor = new CompareSearchInteractor(youtubeDataAccessObject, userDataAccessInterface, compareSearchOutputBoundary);

        return new CompareSearchController(compareSearchInteractor);

    }

}
