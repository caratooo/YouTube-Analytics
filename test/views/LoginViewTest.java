package views;

//import data_access.TestingUserDAO;
import data_access.TestingUserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.Test;
import use_case.login.LoginDataAccessInterface;
import use_case.login.LoginInteractor;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {

    @Test
    void initialize() {
        LoginDataAccessInterface userRepository = new TestingUserDataAccessObject();
//        LoginDataAccessInterface userRepository = new TestingUserDAO();

        LoginViewModel loginViewModel = new LoginViewModel();
        HomeViewModel homeViewModel = new HomeViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginPresenter presenter = new LoginPresenter(viewManagerModel, homeViewModel, loginViewModel);

        LoginInteractor interactor = new LoginInteractor(userRepository, presenter);
        LoginController controller = new LoginController(interactor);

        LoginView loginView = new LoginView(loginViewModel, controller);
    }

}