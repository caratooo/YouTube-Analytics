package use_case.compare_videos;

import java.io.File;

public interface CompareSearchUserDataAccessInterface {
    public void saveUserHistory(String identifier, String listOfData);
    public void save(File userFile);
}
