package views;

import app.HistoryUseCaseFactory;
import data_access.FileHistoryDataAccessObject;
import data_access.FileUserDataAccessObject;
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
import org.junit.jupiter.api.Test;

import java.util.List;

import java.io.FileNotFoundException;
import java.io.IOException;


public class HistoryViewTest {

    @Test
    public void init() {
        UserFactory userFactory = new CommonUserFactory();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("usersTest.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userDataAccessObject.save(userFactory.create("user1Test", "password"));

        FileHistoryDataAccessObject historyDataAccessObject;
        try {
            historyDataAccessObject = new FileHistoryDataAccessObject(userDataAccessObject);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        YouTubeDataAccess youTubeDataAccess;
        try {
            youTubeDataAccess = new YouTubeDataAccess();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        historyDataAccessObject.saveUserHistory("user1Test", "videoSearch,videoid,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount");

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HistoryViewModel historyViewModel = new HistoryViewModel();
        HomeViewModel homeViewModel = new HomeViewModel();
        VideoSearchViewModel videoSearchViewModel = new VideoSearchViewModel();
        VideoStatsViewModel videoStatsViewModel = new VideoStatsViewModel();
        CompareSearchViewModel compareSearchViewModel = new CompareSearchViewModel();
        CompareStatsViewModel compareStatsViewModel = new CompareStatsViewModel();


        HistoryView historyView = HistoryUseCaseFactory.create(viewManagerModel, historyViewModel, historyDataAccessObject, homeViewModel, videoSearchViewModel, videoStatsViewModel, youTubeDataAccess, historyDataAccessObject, compareSearchViewModel, compareStatsViewModel, youTubeDataAccess, historyDataAccessObject);

        HistoryState state = historyViewModel.getState();
        state.setUsername("user1Test");
        state.setUserHistory(List.of("videoSearch,videoid,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"));
        historyViewModel.setState(state);
        historyViewModel.firePropertyChanged();
    }
}
