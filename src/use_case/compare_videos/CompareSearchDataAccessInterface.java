package use_case.compare_videos;

import entities.Video;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface CompareSearchDataAccessInterface {
    Video getVideo(String videoId) throws GeneralSecurityException, IOException;
    boolean isInvalidTwo(String identifierOne, String identifierTwo) throws GeneralSecurityException, IOException;
}
