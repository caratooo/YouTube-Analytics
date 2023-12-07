package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommonUserTest {

    private CommonUser user;
    UserFactory userFactory = new CommonUserFactory();

    @BeforeEach
    void init() {
        user = (CommonUser) userFactory.create("Paul", "password");
    }

    @Test
    void getNameTest() {
        assertEquals("Paul", user.getName());
    }

    @Test
    void getPasswordTest() {
        assertEquals("password", user.getPassword());
    }

}