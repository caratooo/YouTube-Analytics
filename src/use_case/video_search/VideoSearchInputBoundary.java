package use_case.video_search;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface VideoSearchInputBoundary {

    void execute(VideoSearchInputData videoSearchInputData) throws GeneralSecurityException, IOException;

}
