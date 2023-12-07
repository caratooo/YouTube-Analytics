package use_case.compare_videos;

import java.io.File;

public interface CompareSearchUserDataAccessInterface {
    void saveUserHistory(String username, String listOfData);
}
