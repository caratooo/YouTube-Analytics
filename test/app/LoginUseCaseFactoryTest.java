package app;

import data_access.FileUserDataAccessObject;
import entities.CommonUserFactory;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoginUseCaseFactoryTest {

    ViewManagerModel viewManagerModel = new ViewManagerModel();

    LoginViewModel loginViewModel = new LoginViewModel();

    SignupViewModel signupViewModel = new SignupViewModel();

    HomeViewModel homeViewModel = new HomeViewModel();

    UserFactory userFactory = new CommonUserFactory();

    private FileUserDataAccessObject userDataAccessObject;


    LoginUseCaseFactoryTest() {
    }


    @Test
    void testCreate() {

        try {
            userDataAccessObject = new FileUserDataAccessObject("./usersTest.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertNotNull(LoginUseCaseFactory.create(viewManagerModel, loginViewModel, homeViewModel, signupViewModel, userDataAccessObject));
    }

}