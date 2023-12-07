package use_case.history;

import java.util.List;

public class HistoryOutputData {
    private final String username;
    private final List<String> userHistory;

    public HistoryOutputData(String username, List<String> userHistory) {
        this.username = username;
        this.userHistory = userHistory;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getUserHistory() {
        return userHistory;
    }
}
