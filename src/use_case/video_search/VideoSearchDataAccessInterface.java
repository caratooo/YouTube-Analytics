package use_case.video_search;

import entities.Video;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public interface VideoSearchDataAccessInterface {

    Video getVideo(String videoId) throws GeneralSecurityException, IOException;

    ArrayList<Object> getChannel(String videoId) throws GeneralSecurityException, IOException;

    boolean isInvalid(String identifier) throws GeneralSecurityException, IOException;

}
