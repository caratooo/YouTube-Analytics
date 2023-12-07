package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.Test;
import use_case.signup.SignupOutputData;

import static org.junit.jupiter.api.Assertions.*;

class SignupPresenterTest {

    @Test
    void successTest() {

        SignupOutputData output = new SignupOutputData("good", false);

        LoginViewModel loginViewModel = new LoginViewModel();

        SignupViewModel signupViewModel = new SignupViewModel();

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        SignupPresenter presenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        presenter.prepareSuccessView(output);

    }

    @Test
    void failTest() {

        String error = "User already exists.";

        LoginViewModel loginViewModel = new LoginViewModel();

        SignupViewModel signupViewModel = new SignupViewModel();

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        SignupPresenter presenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        presenter.prepareFailView(error);

    }

}