package views;

import app.HistoryUseCaseFactory;
import data_access.FileUserDataAccessObject;
import data_access.InMemoryHistoryDataAccessObject;
import data_access.YouTubeDataAccess;
import entities.CommonUserFactory;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.history.HistoryState;
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
import java.util.List;

import java.io.IOException;


public class HistoryViewTest {
    private FileUserDataAccessObject userDataAccessObject;

    @Before
    public void initializeDAO() {
        UserFactory userFactory = new CommonUserFactory();

        try {
            userDataAccessObject = new FileUserDataAccessObject("usersTest.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userDataAccessObject.save(userFactory.create("user1Test", "password"));
    }

    @Test
    public void init() {
        HistoryDataAccessInterface historyDataAccessObject = new InMemoryHistoryDataAccessObject();

        YouTubeDataAccess youTubeDataAccess;
        try {
            youTubeDataAccess = new YouTubeDataAccess();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ((InMemoryHistoryDataAccessObject) historyDataAccessObject).saveUserHistory("user1Test", "videoSearch,videoid,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount");

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HistoryViewModel historyViewModel = new HistoryViewModel();
        HomeViewModel homeViewModel = new HomeViewModel();
        VideoSearchViewModel videoSearchViewModel = new VideoSearchViewModel();
        VideoStatsViewModel videoStatsViewModel = new VideoStatsViewModel();
        CompareSearchViewModel compareSearchViewModel = new CompareSearchViewModel();
        CompareStatsViewModel compareStatsViewModel = new CompareStatsViewModel();


        HistoryView historyView = HistoryUseCaseFactory.create(viewManagerModel, historyViewModel, historyDataAccessObject, homeViewModel, videoSearchViewModel, videoStatsViewModel, youTubeDataAccess, (VideoSearchUserDataAccessInterface) historyDataAccessObject, compareSearchViewModel, compareStatsViewModel, youTubeDataAccess, (CompareSearchUserDataAccessInterface) historyDataAccessObject);

        HistoryState state = historyViewModel.getState();
        state.setUsername("user1Test");
        state.setUserHistory(List.of("videoSearch,videoid,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"));
        historyViewModel.setState(state);
        historyViewModel.firePropertyChanged();
    }

    @After
    public void deleteFiles() {
        File usersTestFile = new File("./usersTest.csv");
        usersTestFile.delete();
    }
}
