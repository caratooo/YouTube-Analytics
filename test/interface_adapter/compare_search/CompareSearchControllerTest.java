package interface_adapter.compare_search;

import org.junit.jupiter.api.Test;
import use_case.compare_videos.CompareSearchInputBoundary;
import use_case.compare_videos.CompareSearchInputData;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.*;

class CompareSearchControllerTest {

    @Test
    void successTest() throws GeneralSecurityException, IOException {

        String videoIdOne = "H-v6DfxnjF8";
        String videoIdTwo = "H-v6DfxnjF8";

        CompareSearchInputBoundary interactor = new CompareSearchInputBoundary() {
            @Override
            public void execute(CompareSearchInputData compareSearchInputData) {
                assertEquals("H-v6DfxnjF8", compareSearchInputData.getVideoOneId());
            }
        };

        CompareSearchController controller = new CompareSearchController(interactor);
        controller.execute(videoIdOne, videoIdTwo, "a");

    }
}