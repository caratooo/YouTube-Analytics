package views;

import data_access.VideoSearchDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.video_search.VideoSearchController;
import interface_adapter.video_search.VideoSearchPresenter;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.video_search.VideoSearchDataAccessInterface;
import use_case.video_search.VideoSearchInputData;
import use_case.video_search.VideoSearchInteractor;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class VideoSearchViewTest {

    @Test
    void initialize() {
        VideoSearchDataAccessInterface youtubeRepository = new VideoSearchDataAccessObject();

        VideoSearchViewModel videoSearchViewModel = new VideoSearchViewModel();
        VideoStatsViewModel videoStatsViewModel = new VideoStatsViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        VideoSearchPresenter presenter = new VideoSearchPresenter(videoSearchViewModel, videoStatsViewModel, viewManagerModel);

        VideoSearchInteractor interactor = new VideoSearchInteractor(youtubeRepository, presenter);
        VideoSearchController controller = new VideoSearchController(interactor);

        HomeViewModel homeViewModel = new HomeViewModel();

        VideoSearchView videoSearchView = new VideoSearchView(controller, videoSearchViewModel, homeViewModel, viewManagerModel);
    }

}