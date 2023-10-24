package use_case.login;

import entities.User;

public interface LoginDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}