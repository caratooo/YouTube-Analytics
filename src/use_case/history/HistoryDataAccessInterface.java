package use_case.history;

import java.util.List;

public interface HistoryDataAccessInterface {
    List<String> getUserHistory(String identifier);
    boolean doesUserFileExist(String identifier);
}
