package interface_adapter.video_search;

import data_access.VideoSearchDataAccessObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.video_search.VideoSearchDataAccessInterface;
import use_case.video_search.VideoSearchInputBoundary;
import use_case.video_search.VideoSearchInputData;
import use_case.video_search.VideoSearchInteractor;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.*;

class VideoSearchControllerTest {

    @Test
    void successTest() throws GeneralSecurityException, IOException {

        String videoId = "H-v6DfxnjF8";
        String username = "user";

        VideoSearchInputBoundary interactor = new VideoSearchInputBoundary() {
            @Override
            public void execute(VideoSearchInputData videoSearchInputData) {
                assertEquals("H-v6DfxnjF8", videoSearchInputData.getVideoId());
                assertEquals("user", videoSearchInputData.getUsername());
            }
        };

        VideoSearchController controller = new VideoSearchController(interactor);
        controller.execute(videoId, username);

    }



}