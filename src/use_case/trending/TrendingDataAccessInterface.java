package use_case.trending;

import entities.Video;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public interface TrendingDataAccessInterface {
    ArrayList<entities.Video> get_trending_default() throws GeneralSecurityException, IOException;

    ArrayList<entities.Video> get_trending_category(String category) throws GeneralSecurityException, IOException;

}
