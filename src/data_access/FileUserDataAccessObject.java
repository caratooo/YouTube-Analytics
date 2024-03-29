package data_access;

import entities.User;
import entities.UserFactory;
import use_case.login.LoginDataAccessInterface;
import use_case.signup.SignupDataAccessInterface;

import java.io.*;
import java.util.*;

public class FileUserDataAccessObject implements SignupDataAccessInterface, LoginDataAccessInterface {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    /**
     *
     * @param csvPath the CSV path to keep user usernames and passwords
     * @param userFactory a user factory to make new User classes
     * @throws IOException
     */
    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,password");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    User user = userFactory.create(username, password);
                    accounts.put(username, user);
                }
            }
        }
    }

    /**
     *
     * @param user to save into the system
     */
    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }

    /**
     * Requires: user to exist in the system
     * @param username to retrieve from the system
     * @return the User class related to the username
     */
    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s",
                        user.getName(), user.getPassword());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    /**
     * Returns whether there are any accounts made in the system
     * @return whether there are any accounts made in the system
     */
    public boolean isEmpty() {
        return accounts.isEmpty();
    }

    /**
     * Returns all users in the system (it is an array of Strings)
     * @return all the user usernames in an array
     */
    public Object[] getUsers() {
        return accounts.keySet().toArray();
    }
}