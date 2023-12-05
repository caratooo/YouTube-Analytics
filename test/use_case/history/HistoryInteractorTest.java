package use_case.history;

import data_access.InMemoryHistoryDataAccessObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class HistoryInteractorTest {

    @Test
    void successTest() {
        HistoryInputData inputData = new HistoryInputData("alex");
        HistoryDataAccessInterface userRepository = new InMemoryHistoryDataAccessObject();

        List<String> alexHistory = Arrays.asList(
                "videoSearch,videoId1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                "videoSearch,videoId2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
        );

        HistoryOutputBoundary successPresenter = new HistoryOutputBoundary() {
            @Override
            public void prepareSuccessView(HistoryOutputData historyOutputData) {
                assertEquals("alex", historyOutputData.getUsername());
                assertEquals(alexHistory, historyOutputData.getUserHistory());
            }
        };

        HistoryInputBoundary interactor = new HistoryInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }
}