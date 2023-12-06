package use_case.trending;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public interface TrendingDataAccessInterface {
    ArrayList<entities.Video> getTrendingDefault() throws GeneralSecurityException, IOException;

    ArrayList<entities.Video> getTrendingCategory(String category) throws GeneralSecurityException, IOException;

}
