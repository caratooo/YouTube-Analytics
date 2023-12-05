package interface_adapter.history;

import java.util.ArrayList;
import java.util.List;

public class HistoryState {
    private String username = "";
    private List<String> userHistory = null;

    public HistoryState() {
    }

    public String getUsername() {
        return username;
    }

    public List<String> getUserHistory() {
        return userHistory;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserHistory(List<String> userHistory) {
        this.userHistory = userHistory;
    }
}
