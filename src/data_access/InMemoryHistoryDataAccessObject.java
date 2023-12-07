package data_access;

import use_case.compare_videos.CompareSearchUserDataAccessInterface;
import use_case.history.HistoryDataAccessInterface;
import use_case.video_search.VideoSearchUserDataAccessInterface;

import java.util.*;

public class InMemoryHistoryDataAccessObject implements HistoryDataAccessInterface, CompareSearchUserDataAccessInterface, VideoSearchUserDataAccessInterface {
    private final Map<String, String> csvFileHistories = new HashMap<>(Map.ofEntries(
            Map.entry("alex", "csvFile")
    ));
    private final Map<String, List<String>> usersHistories = new HashMap<>(Map.ofEntries(
            Map.entry("alex", Arrays.asList(
                    "videoSearch,videoId1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                    "videoSearch,videoId2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
            ))
    ));

    /**
     * Returns a list of search queries, one string is one search query
     * @param identifier the username to check
     * @return a list of search queries
     */
    @Override
    public List<String> getUserHistory(String identifier) {
        return usersHistories.get(identifier);
    }

    /**
     * Returns whether a user history file exists for a user
     * @param identifier the username to check
     * @return  whether a user history file exists for a user
     */
    @Override
    public boolean doesUserFileExist(String identifier) {
        return csvFileHistories.containsKey(identifier);
    }

    /**
     * Returns whether a user has history (searched before)
     * @param identifier the username to check
     * @return whether a user has history
     */
    @Override
    public boolean doesUserHistoryExist(String identifier) {
        return usersHistories.containsKey(identifier);
    }

    /**
     * Saves a search query to the user
     * @param identifier the username to check
     * @param listOfData the statistics of a search query all in one line, separated by commas with no whitespaces after
     */
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
