package interface_adapter.signup;

import org.junit.jupiter.api.Test;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

import static org.junit.jupiter.api.Assertions.*;

class SignupControllerTest {

    @Test
    void successTest() {

        String username = "user";
        String password1 = "pass";
        String password2 = "pass";

        SignupInputBoundary interactor = new SignupInputBoundary() {
            @Override
            public void execute(SignupInputData signupInputData) {
                assertEquals("user", signupInputData.getUsername());
                assertEquals("pass", signupInputData.getPassword());
                assertEquals("pass", signupInputData.getRepeatPassword());
            }
        };

        SignupController controller= new SignupController(interactor);
        controller.execute(username, password1, password2);

    }

}