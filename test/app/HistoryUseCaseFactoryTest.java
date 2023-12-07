package app;

import data_access.FileUserDataAccessObject;
import data_access.InMemoryHistoryDataAccessObject;
import data_access.YouTubeDataAccess;
import entities.CommonUserFactory;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import use_case.compare_videos.CompareSearchUserDataAccessInterface;
import use_case.history.HistoryDataAccessInterface;
import use_case.video_search.VideoSearchUserDataAccessInterface;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HistoryUseCaseFactoryTest {
    private FileUserDataAccessObject userDataAccessObject;
    private HistoryDataAccessInterface historyDataAccessObject;
    private YouTubeDataAccess youTubeDataAccess;

    @Before
    public void initializeDAO() {
        UserFactory userFactory = new CommonUserFactory();
        try {
            userDataAccessObject = new FileUserDataAccessObject("./usersTest.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userDataAccessObject.save(userFactory.create("user1Test", "password"));

        historyDataAccessObject = new InMemoryHistoryDataAccessObject();

        try {
            youTubeDataAccess = new YouTubeDataAccess();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ((InMemoryHistoryDataAccessObject) historyDataAccessObject).saveUserHistory("user1Test", "videoSearch,videoid,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount");
    }

    @Test
    public void assertHistoryViewNotNullTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HistoryViewModel historyViewModel = new HistoryViewModel();
        HomeViewModel homeViewModel = new HomeViewModel();
        VideoSearchViewModel videoSearchViewModel = new VideoSearchViewModel();
        VideoStatsViewModel videoStatsViewModel = new VideoStatsViewModel();
        CompareSearchViewModel compareSearchViewModel = new CompareSearchViewModel();
        CompareStatsViewModel compareStatsViewModel = new CompareStatsViewModel();


        assertNotNull(HistoryUseCaseFactory.create(viewManagerModel, historyViewModel, historyDataAccessObject, homeViewModel, videoSearchViewModel, videoStatsViewModel, youTubeDataAccess, (VideoSearchUserDataAccessInterface) historyDataAccessObject, compareSearchViewModel, compareStatsViewModel, youTubeDataAccess, (CompareSearchUserDataAccessInterface) historyDataAccessObject));
    }

    @After
    public void deleteFiles() {
        File usersTestFile = new File("./usersTest.csv");
        usersTestFile.delete();

        File user1File = new File("user1TestHistory.csv");
        user1File.delete();
    }
}
