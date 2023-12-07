package use_case.compare_videos;

import data_access.FileHistoryDataAccessObject;
import data_access.FileUserDataAccessObject;
import data_access.InMemoryHistoryDataAccessObject;
import data_access.YouTubeDataAccess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.*;

class CompareSearchInteractorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void successTest() throws IOException, GeneralSecurityException {

        // input data + data access interface
        CompareSearchInputData inputData = new CompareSearchInputData("H-v6DfxnjF8","H-v6DfxnjF8", "a");
        CompareSearchDataAccessInterface youtubeRepository = new YouTubeDataAccess();
        CompareSearchUserDataAccessInterface userDataAccessInterface = new InMemoryHistoryDataAccessObject();

        // TODO testing that output has been sent to history - also might need to be seperate DAO from writing to files, since you're checking in files
//        VideoSearchDataAccessInterface historyRepository = new HistoryDAO();

        // presenter + success and fail view
        CompareSearchOutputBoundary presenter = new CompareSearchOutputBoundary() {
            @Override
            public void prepareSuccessView(CompareSearchOutputData video) {
                assertEquals("H-v6DfxnjF8", video.getVideoIdOne());
                assertEquals("H-v6DfxnjF8", video.getVideoIdTwo());
                assertEquals("FIE Fencing Channel", video.getChannelNameOne());
                assertEquals("FIE Fencing Channel", video.getChannelNameTwo());
                assertEquals("Grand Prix Turin 2020 Women's Foil Final THIBUS FRA vs KIEFER USA", video.getTitleOne());
                assertEquals("Grand Prix Turin 2020 Women's Foil Final THIBUS FRA vs KIEFER USA", video.getTitleTwo());
                assertEquals("", video.getDescriptionOne());
                assertNotNull(video.getViewCountOne());
                assertNotNull(video.getLikeCountOne());
                assertNotNull(video.getCommentCountOne());
                // assertTrue(historyRepository.existsByName);
            }

            @Override
            public void prepareFailView(String error) {
                fail("This use case should not fail.");
            }

        };

        // interactor + execute
        CompareSearchInputBoundary interactor = new CompareSearchInteractor(youtubeRepository, userDataAccessInterface, presenter);
        interactor.execute(inputData);
    }

    @Test
    void failureTest() throws IOException, GeneralSecurityException {
        CompareSearchInputData inputData = new CompareSearchInputData("123", "456", "a");
        CompareSearchDataAccessInterface youtubeRepository = new YouTubeDataAccess();

        CompareSearchOutputBoundary presenter = new CompareSearchOutputBoundary() {
            @Override
            public void prepareSuccessView(CompareSearchOutputData video) {
                fail("This use case should not pass.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Video ID does not exist", error);
            }
        };
        CompareSearchUserDataAccessInterface userDataAccessInterface = new InMemoryHistoryDataAccessObject();
        CompareSearchInputBoundary interactor = new CompareSearchInteractor(youtubeRepository, userDataAccessInterface, presenter);
        interactor.execute(inputData);

    }

}