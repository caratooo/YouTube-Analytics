package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import org.junit.jupiter.api.Test;
import use_case.login.LoginOutputData;

import static org.junit.jupiter.api.Assertions.*;

class LoginPresenterTest {

    @Test
    void successTest() {

        LoginOutputData output = new LoginOutputData("good", false);

        LoginViewModel loginViewModel = new LoginViewModel();

        HomeViewModel homeViewModel = new HomeViewModel();

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        LoginPresenter presenter = new LoginPresenter(viewManagerModel, homeViewModel, loginViewModel);
        presenter.prepareSuccessView(output);

    }

    @Test
    void failTest() {

        String error = "Incorrect password for Username.";

        LoginViewModel loginViewModel = new LoginViewModel();

        HomeViewModel homeViewModel = new HomeViewModel();

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        LoginPresenter presenter = new LoginPresenter(viewManagerModel, homeViewModel, loginViewModel);
        presenter.prepareFailView(error);

    }

}