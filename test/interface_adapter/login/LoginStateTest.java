package interface_adapter.login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginStateTest {

    LoginState loginState1 = new LoginState();

    @Test
    void setGetUser() {
        assertEquals(loginState1.getUsername(), "");
        loginState1.setUsername("user");
        assertEquals(loginState1.getUsername(), "user");
    }

    @Test
    void setGetUserError() {
        assertNull(loginState1.getUsernameError());
        loginState1.setUsernameError("error");
        assertEquals(loginState1.getUsernameError(), "error");
    }

    @Test
    void setGetPass() {
        assertEquals(loginState1.getPassword(), "");
        loginState1.setPassword("user");
        assertEquals(loginState1.getPassword(), "user");
    }

    @Test
    void setGetPassError() {
        assertNull(loginState1.getPasswordError());
        loginState1.setPasswordError("error");
        assertEquals(loginState1.getPasswordError(), "error");
    }

    @Test
    void copyTest() {
        loginState1.setUsername("user");
        LoginState loginState2 = new LoginState(loginState1);
        assertEquals(loginState2.getUsername(), loginState1.getUsername());
    }

}