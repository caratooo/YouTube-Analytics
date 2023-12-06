package data_access;

import entities.CommonUserFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileHistoryDataAccessObjectTest {

    FileHistoryDataAccessObject historyDataAccessObject;
    FileUserDataAccessObject userDataAccessObject;

    @Before
    public void init() {
        try {
            userDataAccessObject = new FileUserDataAccessObject("./usersTest.csv", new CommonUserFactory());
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
    public void test() {
    }
}
