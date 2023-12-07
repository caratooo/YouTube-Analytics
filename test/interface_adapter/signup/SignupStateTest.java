package interface_adapter.signup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupStateTest {

    SignupState SignupState1 = new SignupState();

    @Test
    void setGetUser() {
        assertEquals(SignupState1.getUsername(), "");
        SignupState1.setUsername("user");
        assertEquals(SignupState1.getUsername(), "user");
    }

    @Test
    void setGetUserError() {
        assertNull(SignupState1.getUsernameError());
        SignupState1.setUsernameError("error");
        assertEquals(SignupState1.getUsernameError(), "error");
    }

    @Test
    void setGetPass() {
        assertEquals(SignupState1.getPassword(), "");
        SignupState1.setPassword("pass");
        assertEquals(SignupState1.getPassword(), "pass");
    }

    @Test
    void setGetPassError() {
        assertNull(SignupState1.getPasswordError());
        SignupState1.setPasswordError("error");
        assertEquals(SignupState1.getPasswordError(), "error");
    }

    @Test
    void setGetRePass() {
        assertEquals(SignupState1.getRepeatPassword(), "");
        SignupState1.setRepeatPassword("pass");
        assertEquals(SignupState1.getRepeatPassword(), "pass");
    }

    @Test
    void setGetRePassError() {
        assertNull(SignupState1.getRepeatPasswordError());
        SignupState1.setRepeatPasswordError("error");
        assertEquals(SignupState1.getRepeatPasswordError(), "error");
    }

    @Test
    void copyTest() {
        SignupState1.setUsername("user");
        SignupState loginState2 = new SignupState(SignupState1);
        assertEquals(loginState2.getUsername(), SignupState1.getUsername());
    }

    @Test
    void toStringTest() {
        String username = "user";
        String password = "pass";
        String repeatPassword = "pass";
        String str = "SignupState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                '}';
        SignupState1.setUsername(username);
        SignupState1.setPassword(password);
        SignupState1.setRepeatPassword(repeatPassword);
        assertEquals(SignupState1.toString(), str);
    }

}