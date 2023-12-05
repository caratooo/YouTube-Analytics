package data_access;

import use_case.history.HistoryDataAccessInterface;

import java.io.*;
import java.util.*;

public class FileHistoryDataAccessObject implements HistoryDataAccessInterface {
    private final Map<String, File> csvFileHistories = new HashMap<>();
    private final Map<String, List<String>> usersHistories = new HashMap<>();
    private final Map<String, String[]> headersHistories = new HashMap<>();
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    public FileHistoryDataAccessObject(FileUserDataAccessObject userDataAccessObject) throws FileNotFoundException { // add to FileUserDataAccessObject
        headers.put("type", 0);
        headers.put("output", 1);

        headersHistories.put("videoSearch",
                new String[]{"videoId", "channelName", "title", "description", "videoPublishDate", "viewCount", "likeCount", "commentCount"});
        headersHistories.put("compare",
                new String[]{
                        "videoId1", "channelName1", "title1", "description1", "videoPublishDate1", "viewCount1", "likeCount1", "commentCount1",
                        "videoId2", "channelName2", "title2", "description2", "videoPublishDate2", "viewCount2", "likeCount2", "commentCount2"
                });

        if (!userDataAccessObject.isEmpty()) {
            Object[] users = userDataAccessObject.getUsers();

            for (Object user : users) {
                String csvPath = String.format("%sHistory.csv", user);
                File userFile = new File(csvPath);
                csvFileHistories.put((String) user, userFile);

                BufferedReader reader = new BufferedReader(new FileReader(userFile));
                try {
                    String row = reader.readLine();
                    usersHistories.put((String) user, new ArrayList<>());
                    List<String> userHistory = usersHistories.get(user);

                    while ((row = reader.readLine()) != null) {
                        userHistory.add(row);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void saveUserHistory(String identifier, String listOfData) {
        usersHistories.get(identifier).add(listOfData);

        if (!doesUserFileExist(identifier)) {
            String csvPath = String.format("./%sHistory.csv", identifier);
            File userFile = new File(csvPath);
            csvFileHistories.put(identifier, userFile);
            save(userFile);
        } else {
            File userFile = csvFileHistories.get(identifier);
            save(userFile);
        }
    }

    public void save(File userFile) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(userFile));
            writer.write(String.join(",", headersHistories.keySet()));
            writer.newLine();

            for (String user : usersHistories.keySet()) {
                List<String> userHistory = usersHistories.get(user);

                for (String query : userHistory) {
                    writer.write(query);
                    writer.newLine();
                }
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doesUserFileExist(String identifier) {
        return csvFileHistories.containsKey(identifier);
    }
    @Override
    public List<String> getUserHistory(String identifier) {
        return usersHistories.get(identifier);
    }
}