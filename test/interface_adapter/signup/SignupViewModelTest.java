package interface_adapter.signup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupViewModelTest {

    SignupState signupState = new SignupState();

    SignupViewModel signupViewModel = new SignupViewModel();

    @Test
    void setGetState() {
        assertNotEquals(signupViewModel.getState(), signupState);
        signupState.setUsername("user");
        signupViewModel.setState(signupState);
        assertEquals(signupViewModel.getState(), signupState);
    }

}