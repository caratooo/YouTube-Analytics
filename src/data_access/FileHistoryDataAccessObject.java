package data_access;

import use_case.compare_videos.CompareSearchUserDataAccessInterface;
import use_case.history.HistoryDataAccessInterface;
import use_case.video_search.VideoSearchUserDataAccessInterface;

import java.io.*;
import java.util.*;

public class FileHistoryDataAccessObject implements HistoryDataAccessInterface, VideoSearchUserDataAccessInterface, CompareSearchUserDataAccessInterface {
    private Map<String, File> csvFileHistories = new HashMap<>();
    private Map<String, List<String>> usersHistories = new HashMap<>();
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    public FileHistoryDataAccessObject(FileUserDataAccessObject userDataAccessObject) throws FileNotFoundException { // add to FileUserDataAccessObject
        headers.put("type", 0);
        headers.put("output", 1);

        if (!userDataAccessObject.isEmpty()) {
            Object[] users = userDataAccessObject.getUsers();

            for (Object user : users) {
                try {
                    String csvPath = String.format("%sHistory.csv", user);
                    File userFile = new File(csvPath);

                    BufferedReader reader = new BufferedReader(new FileReader(userFile));
                    try {
                        csvFileHistories.put((String) user, userFile);

                        String row = reader.readLine();
                        usersHistories.put((String) user, new ArrayList<>());
                        List<String> userHistory = usersHistories.get(user);

                        while ((row = reader.readLine()) != null) {
                            userHistory.add(row);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } catch (FileNotFoundException ignored) {
                    continue;
                }
            }
        }
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
            String csvPath = String.format("./%sHistory.csv", identifier);
            File userFile = new File(csvPath);
            csvFileHistories.put(identifier, userFile);
            save(userFile, identifier);
        } else {
            File userFile = csvFileHistories.get(identifier);
            save(userFile, identifier);
        }
    }


    private void save(File userFile, String identifier) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(userFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (String data : usersHistories.get(identifier)) {
                writer.write(data);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns whether a user history file exists for a user
     * @param identifier the username to check
     * @return  whether a user history file exists for a user
     */
    public boolean doesUserFileExist(String identifier) {
        return csvFileHistories.containsKey(identifier);
    }

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
     * Returns whether a user has history (searched before)
     * @param identifier the username to check
     * @return whether a user has history
     */
    @Override
    public boolean doesUserHistoryExist(String identifier) {
        return usersHistories.containsKey(identifier);
    }

}