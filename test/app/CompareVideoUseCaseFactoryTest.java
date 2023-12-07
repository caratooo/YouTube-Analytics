package app;

import data_access.InMemoryHistoryDataAccessObject;
import data_access.VideoSearchDataAccessObject;
import data_access.YouTubeDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import org.junit.jupiter.api.Test;
import use_case.compare_videos.CompareSearchDataAccessInterface;
import use_case.compare_videos.CompareSearchUserDataAccessInterface;
import use_case.video_search.VideoSearchDataAccessInterface;
import use_case.video_search.VideoSearchUserDataAccessInterface;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CompareVideoUseCaseFactoryTest {

    ViewManagerModel viewManagerModel = new ViewManagerModel();
    CompareSearchViewModel compareSearchViewModel = new CompareSearchViewModel();
    CompareStatsViewModel compareStatsViewModel = new CompareStatsViewModel();
    HomeViewModel homeViewModel = new HomeViewModel();

    CompareSearchUserDataAccessInterface userDataAccessInterface = new InMemoryHistoryDataAccessObject();
    CompareSearchDataAccessInterface youtubeDataAccessObject = new YouTubeDataAccess();

    CompareVideoUseCaseFactoryTest() throws IOException {
    }

    @Test
    void testCreate() {
        assertNotNull(CompareVideoUseCaseFactory.create(viewManagerModel, compareSearchViewModel, compareStatsViewModel, homeViewModel, userDataAccessInterface, youtubeDataAccessObject));
    }

}