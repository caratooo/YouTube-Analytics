package use_case.video_search;

import entities.Video;

public interface VideoSearchDataAccessInterface {

    boolean idInvalid(String identifier);

    void save(Video video);  // TODO see VideoSearchInteractor 32

}
