package interface_adapter.login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewModelTest {

    LoginState loginState = new LoginState();

    LoginViewModel loginViewModel = new LoginViewModel();

    @Test
    void setGetState() {
        assertNotEquals(loginViewModel.getState(), loginState);
        loginState.setUsername("user");
        loginViewModel.setState(loginState);
        assertEquals(loginViewModel.getState(), loginState);
    }

}