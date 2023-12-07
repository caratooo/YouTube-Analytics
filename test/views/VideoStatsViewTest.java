package views;

import data_access.VideoSearchDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.video_search.VideoSearchController;
import interface_adapter.video_search.VideoSearchPresenter;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import org.junit.jupiter.api.Test;
import use_case.video_search.VideoSearchDataAccessInterface;
import use_case.video_search.VideoSearchInteractor;

import static org.junit.jupiter.api.Assertions.*;

class VideoStatsViewTest {

    @Test
    void initialize() {
        VideoSearchDataAccessInterface youtubeRepository = new VideoSearchDataAccessObject();

        VideoStatsViewModel videoStatsViewModel = new VideoStatsViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        HomeViewModel homeViewModel = new HomeViewModel();

        VideoStatsView videoStatsView = new VideoStatsView(videoStatsViewModel, homeViewModel, viewManagerModel);

    }

}