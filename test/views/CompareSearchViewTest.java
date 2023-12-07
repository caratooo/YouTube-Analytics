package views;

import com.google.api.services.youtube.YouTube;
import data_access.InMemoryHistoryDataAccessObject;
import data_access.YouTubeDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.compare_search.CompareSearchController;
import interface_adapter.compare_search.CompareSearchPresenter;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.home.HomeViewModel;
import org.junit.jupiter.api.Test;
import use_case.compare_videos.CompareSearchDataAccessInterface;
import use_case.compare_videos.CompareSearchInputBoundary;
import use_case.compare_videos.CompareSearchInteractor;
import use_case.compare_videos.CompareSearchUserDataAccessInterface;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CompareSearchViewTest {
    @Test
    void initialize() throws IOException {
        CompareSearchDataAccessInterface youtubeRepository = new YouTubeDataAccess();
        CompareSearchUserDataAccessInterface compareSearchUserDataAccessInterface = new InMemoryHistoryDataAccessObject();

        CompareSearchViewModel compareSearchViewModel = new CompareSearchViewModel();
        CompareStatsViewModel compareStatsViewModel = new CompareStatsViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        CompareSearchPresenter compareSearchPresenter = new CompareSearchPresenter(compareSearchViewModel, compareStatsViewModel, viewManagerModel);

        CompareSearchInputBoundary compareSearchInteractor = new CompareSearchInteractor(youtubeRepository, compareSearchUserDataAccessInterface, compareSearchPresenter);
        CompareSearchController compareSearchController = new CompareSearchController(compareSearchInteractor);

        HomeViewModel homeViewModel = new HomeViewModel();

        CompareSearchView compareSearchView = new CompareSearchView(compareSearchViewModel, compareSearchController, homeViewModel, viewManagerModel);

        viewManagerModel.setActiveView(compareSearchView.viewName);

    }

}