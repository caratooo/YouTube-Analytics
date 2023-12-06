package views;

//import data_access.TestingUserDAO;
import data_access.TestingUserDataAccessObject;
import entities.CommonUserFactory;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.Test;
import use_case.signup.SignupDataAccessInterface;
import use_case.signup.SignupInteractor;

import static org.junit.jupiter.api.Assertions.*;

class SignupViewTest {

    @Test
    void initialize() {
        SignupDataAccessInterface userRepository = new TestingUserDataAccessObject();
//        SignupDataAccessInterface userRepository = new TestingUserDAO();

        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupPresenter presenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        UserFactory factory = new CommonUserFactory();

        SignupInteractor interactor = new SignupInteractor(userRepository, presenter, factory);
        SignupController controller = new SignupController(interactor);

        SignupView signupView = new SignupView(controller, signupViewModel);
    }

}