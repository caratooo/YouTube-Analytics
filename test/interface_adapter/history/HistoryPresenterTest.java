package interface_adapter.history;

import interface_adapter.ViewManagerModel;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import use_case.history.HistoryInputBoundary;
import use_case.history.HistoryInputData;
import use_case.history.HistoryOutputData;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HistoryPresenterTest {

    @Test
    void successTest() {
        String user = "alex";
        List<String> alexHistory = Arrays.asList(
                "videoSearch,videoId1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                "videoSearch,videoId2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
        );

        HistoryOutputData outputData = new HistoryOutputData(user, alexHistory);

        HistoryViewModel historyViewModel = new HistoryViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        HistoryPresenter presenter = new HistoryPresenter(historyViewModel, viewManagerModel);
        presenter.prepareSuccessView(outputData);
    }

    @Test
    void failTest() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        HistoryPresenter presenter = new HistoryPresenter(historyViewModel, viewManagerModel);
        presenter.prepareFailView("No history to view");

        assertEquals("No history to view", historyViewModel.getState().getUserHistoryError());
    }
}
