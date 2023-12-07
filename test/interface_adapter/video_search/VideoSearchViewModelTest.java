package interface_adapter.video_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoSearchViewModelTest {

    VideoSearchState videoSearchState = new VideoSearchState();

    VideoSearchViewModel videoSearchViewModel = new VideoSearchViewModel();

    @Test
    void setGetState() {
        assertNotEquals(videoSearchViewModel.getState(), videoSearchState);
        videoSearchState.setVideoId("id");
        videoSearchViewModel.setState(videoSearchState);
        assertEquals(videoSearchViewModel.getState(), videoSearchState);
    }

}