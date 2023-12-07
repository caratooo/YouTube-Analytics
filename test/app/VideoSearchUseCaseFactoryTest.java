package app;

import static org.junit.jupiter.api.Assertions.*;

import data_access.FileUserDataAccessObject;
import data_access.InMemoryHistoryDataAccessObject;
import data_access.VideoSearchDataAccessObject;
import data_access.YouTubeDataAccess;
import entities.CommonUserFactory;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.video_search.VideoSearchController;
import interface_adapter.video_search.VideoSearchPresenter;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import org.junit.jupiter.api.Test;
import use_case.video_search.*;

import java.io.IOException;

class VideoSearchUseCaseFactoryTest {

    ViewManagerModel viewManagerModel = new ViewManagerModel();
    VideoSearchViewModel videoSearchViewModel = new VideoSearchViewModel();
    VideoStatsViewModel videoStatsViewModel = new VideoStatsViewModel();
    HomeViewModel homeViewModel = new HomeViewModel();

    VideoSearchUserDataAccessInterface userDataAccessInterface = new InMemoryHistoryDataAccessObject();
    VideoSearchDataAccessInterface youtubeDataAccessObject = new VideoSearchDataAccessObject();

    VideoSearchUseCaseFactoryTest() {
    }

    @Test
    void testCreate() {
        assertNotNull(VideoSearchUseCaseFactory.create(viewManagerModel, videoSearchViewModel, videoStatsViewModel, homeViewModel, youtubeDataAccessObject, userDataAccessInterface));
    }

}