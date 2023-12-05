package data_access;

import use_case.history.HistoryDataAccessInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryHistoryDataAccessObject implements HistoryDataAccessInterface {
    private final Map<String, List<String>> usersHistories = new HashMap<>(Map.ofEntries(
            Map.entry("alex", Arrays.asList(
                    "videoSearch,videoId1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                    "videoSearch,videoId2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
            ))
    ));
    @Override
    public List<String> getUserHistory(String identifier) {
        return usersHistories.get(identifier);
    }
}
