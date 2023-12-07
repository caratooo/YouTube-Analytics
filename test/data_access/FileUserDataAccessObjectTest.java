package data_access;

import entities.CommonUserFactory;
import entities.UserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileUserDataAccessObjectTest {
    UserFactory userFactory = new CommonUserFactory();
    FileUserDataAccessObject userDataAccessObject;

    @Before
    public void init() {
        try {
            userDataAccessObject = new FileUserDataAccessObject("usersTest.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void isEmptyTest() {
        assertTrue(userDataAccessObject.isEmpty());
    }

    @Test
    public void getUsersTest() {
        assertEquals(0, userDataAccessObject.getUsers().length);
    }

    @Test
    public void saveTest() {
        userDataAccessObject.save(userFactory.create("user1Test", "password"));

        assertEquals(1, userDataAccessObject.getUsers().length);
    }

    @Test
    public void existsByNameTest() {
        // user1Test now exists in the system
        userDataAccessObject.save(userFactory.create("user1Test", "password"));
        assertTrue(userDataAccessObject.existsByName("user1Test"));

        // user2Test does not exist in the system
        assertFalse(userDataAccessObject.existsByName("user2Test"));
    }

    @Test
    public void getUserTest() {
        userDataAccessObject.save(userFactory.create("user1Test", "password"));

        assertEquals("user1Test", userDataAccessObject.get("user1Test").getName());
    }


    @After
    public void deleteFiles() {
        File usersTestFile = new File("usersTest.csv");
        usersTestFile.delete();
    }
}
