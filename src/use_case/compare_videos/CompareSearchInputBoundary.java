package use_case.compare_videos;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface CompareSearchInputBoundary {
    void execute(CompareSearchInputData compareSearchInputData) throws GeneralSecurityException, IOException;
}
