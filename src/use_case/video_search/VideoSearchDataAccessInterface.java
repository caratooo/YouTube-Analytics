package use_case.video_search;

import entities.Video;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface VideoSearchDataAccessInterface {

    Video get(String videoId) throws GeneralSecurityException, IOException;

//    boolean idInvalid(String identifier);

//    void save(Video video);  // TODO see VideoSearchInteractor 32

}
