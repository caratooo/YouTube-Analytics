package use_case.video_search;

import data_access.InMemoryHistoryDataAccessObject;
import data_access.VideoSearchDataAccessObject;
import data_access.YouTubeDataAccess;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.*;

class VideoSearchInteractorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void successTest() throws IOException, GeneralSecurityException {

        // input data + data access interface
        VideoSearchInputData inputData = new VideoSearchInputData("H-v6DfxnjF8", "user");
        VideoSearchDataAccessInterface youtubeRepository = new VideoSearchDataAccessObject();

        // TODO testing that output has been sent to history - also might need to be seperate DAO from writing to files, since you're checking in files
        VideoSearchUserDataAccessInterface historyRepository = new InMemoryHistoryDataAccessObject();

        // presenter + success and fail view
        VideoSearchOutputBoundary presenter = new VideoSearchOutputBoundary() {
            @Override
            public void prepareSuccessView(VideoSearchOutputData video) {
                assertEquals("H-v6DfxnjF8", video.getVideoId());
                assertEquals("FIE Fencing Channel", video.getChannelName());
                assertEquals("Grand Prix Turin 2020 Women's Foil Final THIBUS FRA vs KIEFER USA", video.getTitle());
                assertEquals("", video.getDescription());
//                assertEquals("", video.getVideoPublishDate());
                assertEquals(12996, video.getViewCount());
                assertEquals(169, video.getLikeCount());
                assertEquals(9, video.getCommentCount());

            }

            @Override
            public void prepareFailView(String error) {
                fail("This use case should not fail.");
            }

        };

        // interactor + execute
        VideoSearchInputBoundary interactor = new VideoSearchInteractor(youtubeRepository, historyRepository, presenter);
        interactor.execute(inputData);
    }

    @Test
    void failureTest() throws IOException, GeneralSecurityException {
        VideoSearchInputData inputData = new VideoSearchInputData("123", "user");
        VideoSearchDataAccessInterface youtubeRepository = new YouTubeDataAccess();
        VideoSearchUserDataAccessInterface historyRepository = new InMemoryHistoryDataAccessObject();

        VideoSearchOutputBoundary presenter = new VideoSearchOutputBoundary() {
            @Override
            public void prepareSuccessView(VideoSearchOutputData video) {
                fail("This use case should not pass.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Video ID does not exist.", error);
            }
        };

        VideoSearchInputBoundary interactor = new VideoSearchInteractor(youtubeRepository, historyRepository, presenter);
        interactor.execute(inputData);

    }

}