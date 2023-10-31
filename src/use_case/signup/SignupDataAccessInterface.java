package use_case.signup;
import entities.User;

import entities.User;

public interface SignupDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
