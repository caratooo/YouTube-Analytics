package interface_adapter.history;

import org.apache.http.impl.io.ChunkedInputStream;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class HistoryStateTest {

    private HistoryState historyState;

    @Before
    public void init() {
        historyState = new HistoryState();
    }

    @Test
    public void setAndGetUsernameTest() {
        assertEquals("", historyState.getUsername());

        historyState.setUsername("alex");
        assertEquals("alex", historyState.getUsername());
    }

    @Test
    public void setAndGetUserHistoryTest() {
        assertNull(historyState.getUserHistory());

        List<String> alexHistory = Arrays.asList(
                "videoSearch,videoId1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                "videoSearch,videoId2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
        );

        historyState.setUserHistory(alexHistory);
        assertEquals(
                Arrays.asList(
                        "videoSearch,videoId1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                        "videoSearch,videoId2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
                ),
                historyState.getUserHistory()
        );
    }
}
