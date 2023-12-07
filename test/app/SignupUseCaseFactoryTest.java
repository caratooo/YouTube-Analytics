package app;

import data_access.FileUserDataAccessObject;
import entities.CommonUserFactory;
import entities.User;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.Test;
import use_case.signup.SignupDataAccessInterface;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SignupUseCaseFactoryTest {

    ViewManagerModel viewManagerModel = new ViewManagerModel();

    LoginViewModel loginViewModel = new LoginViewModel();

    SignupViewModel signupViewModel = new SignupViewModel();

    UserFactory userFactory = new CommonUserFactory();

    private FileUserDataAccessObject userDataAccessObject;


    SignupUseCaseFactoryTest() {
    }


    @Test
    void testCreate() {

        try {
            userDataAccessObject = new FileUserDataAccessObject("./usersTest.csv", userFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertNotNull(SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject));
    }

}