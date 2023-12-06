package data_access;

import entities.User;
import use_case.login.LoginDataAccessInterface;
import use_case.signup.SignupDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class TestingUserDataAccessObject implements SignupDataAccessInterface, LoginDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();

    /**
     * @param identifier the user's username
     * @return whether the user exists
     */
    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    /**
     * @param user the data to save
     */
    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public User get(String username) {
        return users.get(username);
    }
}