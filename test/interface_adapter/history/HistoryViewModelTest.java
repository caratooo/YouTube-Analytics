package interface_adapter.history;

import org.junit.Test;
import use_case.history.HistoryOutputBoundary;
import use_case.history.HistoryOutputData;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HistoryViewModelTest{
    HistoryViewModel historyViewModel;

    @Test
    public void setAndGetStateTest() {
        historyViewModel = new HistoryViewModel();

        String user = "alex";
        List<String> alexHistory = Arrays.asList(
                "videoSearch,videoId1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                "videoSearch,videoId2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
        );


        HistoryOutputBoundary presenter = new HistoryOutputBoundary() {
            @Override
            public void prepareSuccessView(HistoryOutputData historyOutputData) {
                HistoryState historyState = historyViewModel.getState();
                historyState.setUsername(historyOutputData.getUsername());
                historyState.setUserHistory(historyOutputData.getUserHistory());
                historyViewModel.setState(historyState);
            }
        };

        assertEquals("", historyViewModel.getState().getUsername());
        assertNull(historyViewModel.getState().getUserHistory());

        presenter.prepareSuccessView(new HistoryOutputData(user, alexHistory));

        assertEquals("alex", historyViewModel.getState().getUsername());
        assertEquals(
                Arrays.asList(
                        "videoSearch,videoId1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                        "videoSearch,videoId2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
                ),
                historyViewModel.getState().getUserHistory()
        );

    }
}