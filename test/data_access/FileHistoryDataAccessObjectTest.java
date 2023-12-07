package data_access;

import entities.CommonUserFactory;
import entities.UserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileHistoryDataAccessObjectTest {

    FileHistoryDataAccessObject historyDataAccessObject;
    FileUserDataAccessObject userDataAccessObject;

    @Before
    public void init() {
        UserFactory userFactory = new CommonUserFactory();
        try {
            userDataAccessObject = new FileUserDataAccessObject("usersTest.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userDataAccessObject.save(userFactory.create("user1Test", "password"));
        userDataAccessObject.save(userFactory.create("user2Test", "password"));

        File user1File = new File("user1TestHistory.csv");
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(user1File));
            writer.write("type,output");
            writer.newLine();

            List<String> listOfData = Arrays.asList(
                    "videoSearch,videoid,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                    "compare,videoid1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount,videoid2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
            );

            for (String data : listOfData) {
                writer.write(data);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            historyDataAccessObject = new FileHistoryDataAccessObject(userDataAccessObject);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void doesUserFileExistTest() {
        // user1Test history file does exist at this moment
        assertTrue(historyDataAccessObject.doesUserFileExist("user1Test"));

        // user2Test history file does not exist at this moment
        assertFalse(historyDataAccessObject.doesUserFileExist("user2Test"));
    }

    @Test
    public void doesUserHistoryExist() {
        // user1Test history does exist at this moment
        assertTrue(historyDataAccessObject.doesUserHistoryExist("user1Test"));

        // user2Test history does not exist at this moment
        assertFalse(historyDataAccessObject.doesUserHistoryExist("user2Test"));
    }

    @Test
    public void getUserHistoryTest() {
        List<String> user1TestHistory = Arrays.asList(
                "videoSearch,videoid,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                "compare,videoid1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount,videoid2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
        );
        assertEquals(user1TestHistory, historyDataAccessObject.getUserHistory("user1Test"));
    }

    @Test
    public void saveHistoryTest() {
        String data = "videoSearch,videoid3,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount";
        historyDataAccessObject.saveUserHistory("user2Test", data);

        assertEquals(
                List.of("videoSearch,videoid3,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"),
                historyDataAccessObject.getUserHistory("user2Test")
        );
    }

    @Test
    public void saveNewToExistingTest() {
        List<String> user1TestHistory = Arrays.asList(
                "videoSearch,videoid,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                "compare,videoid1,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount,videoid2,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount",
                "videoSearch,videoid5,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount"
        );

        String data = "videoSearch,videoid5,channelName,title,description,videoPublishDate,viewCount,likeCount,commentCount";
        historyDataAccessObject.saveUserHistory("user1Test", data);

        assertEquals(user1TestHistory, historyDataAccessObject.getUserHistory("user1Test"));
    }

    @After
    public void deleteFiles() {
        File usersTestFile = new File("usersTest.csv");
        usersTestFile.delete();

        File user2File = new File("user2TestHistory.csv");
        user2File.delete();

        File user1File = new File("user1TestHistory.csv");
        user1File.delete();
    }
}
