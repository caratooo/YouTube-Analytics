package use_case.trending;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface TrendingInputBoundary {
    void execute(TrendingInputData trendingInputData) throws GeneralSecurityException, IOException;
}
