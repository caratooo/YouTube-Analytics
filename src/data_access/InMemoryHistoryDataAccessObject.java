package data_access;

import use_case.compare_videos.CompareSearchUserDataAccessInterface;
import use_case.history.HistoryDataAccessInterface;
import use_case.video_search.VideoSearchUserDataAccessInterface;

import java.io.File;
import java.util.*;

public class InMemoryHistoryDataAccessObject implements HistoryDataAccessInterface, CompareSearchUserDataAccessInterface, VideoSearchUserDataAccessInterface {
    private Map<String, String> csvFileHistories = new HashMap<>(Map.ofEntries(
            Map.entry("alex", "csvFile")
    ));
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

    @Override
    public boolean doesUserFileExist(String identifier) {
        return csvFileHistories.containsKey(identifier);
    }

    @Override
    public boolean doesUserHistoryExist(String identifier) {
        return false;
    }

    @Override
    public void saveUserHistory(String identifier, String listOfData) {
        if (usersHistories.containsKey(identifier)) {
            usersHistories.get(identifier).add(listOfData);
        } else {
            usersHistories.put(identifier, new ArrayList<>());
            usersHistories.get(identifier).add(listOfData);
        }

        if (!doesUserFileExist(identifier)) {
            csvFileHistories.put(identifier, "userFile");
        }
    }
}
