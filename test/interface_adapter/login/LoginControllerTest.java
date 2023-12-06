package interface_adapter.login;

import org.junit.jupiter.api.Test;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    @Test
    void successTest() {

        String username = "user";
        String password = "pass";

        LoginInputBoundary interactor = new LoginInputBoundary() {
            @Override
            public void execute(LoginInputData loginInputData) {
                assertEquals("user", loginInputData.getUsername());
                assertEquals("pass", loginInputData.getPassword());
            }
        };

        LoginController controller= new LoginController(interactor);
        controller.execute(username, password);

    }

}