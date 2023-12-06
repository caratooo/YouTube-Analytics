package use_case.login;

//import data_access.TestingUserDAO;
import data_access.TestingUserDataAccessObject;
import entities.CommonUserFactory;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {

    @Test
    void successTest() {

        LoginInputData input = new LoginInputData("good", "pass");

        LoginDataAccessInterface userRepository = new TestingUserDataAccessObject();
//        LoginDataAccessInterface userRepository = new TestingUserDAO();

        UserFactory factory = new CommonUserFactory();
        User user = factory.create("good", "pass");
        userRepository.save(user);

        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals("good", user.getUsername());
                assertTrue(userRepository.existsByName("good"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("This use case should not fail.");
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, presenter);
        interactor.execute(input);

    }

    @Test
    void failureAccDne() {

        LoginInputData input = new LoginInputData("bad", "pass");

        LoginDataAccessInterface userRepository = new TestingUserDataAccessObject();
//        LoginDataAccessInterface userRepository = new TestingUserDAO();

        UserFactory factory = new CommonUserFactory();
        User user = factory.create("good", "pass");
        userRepository.save(user);

        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail("This use case should not pass.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("bad: Account does not exist.", error);
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, presenter);
        interactor.execute(input);

    }

    @Test
    void failureIncorrectPass() {

        LoginInputData input = new LoginInputData("good", "bad");

        LoginDataAccessInterface userRepository = new TestingUserDataAccessObject();
//        LoginDataAccessInterface userRepository = new TestingUserDAO();

        UserFactory factory = new CommonUserFactory();
        User user = factory.create("good", "pass");
        userRepository.save(user);

        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail("This use case should not pass.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Incorrect password for good.", error);
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, presenter);
        interactor.execute(input);

    }

}