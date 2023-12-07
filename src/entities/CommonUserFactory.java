package entities;

public class CommonUserFactory implements UserFactory {
    /**
     * Requires: password is valid.
     * @param name the username
     * @param password the password
     * @return a User class with the respective username and password
     */
    @Override
    public User create(String name, String password) {
        return new CommonUser(name, password);
    }
}
