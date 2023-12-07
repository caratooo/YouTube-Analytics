package interface_adapter.video_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoSearchStateTest {

    VideoSearchState videoSearchState1 = new VideoSearchState();

    @Test
    void setGetVideoId() {
        assertEquals(videoSearchState1.getVideoId(), "");
        videoSearchState1.setVideoId("id");
        assertEquals(videoSearchState1.getVideoId(), "id");
    }

    @Test
    void setGetVideoIdError() {
        assertNull(videoSearchState1.getVideoIdError());
        videoSearchState1.setVideoIdError("error");
        assertEquals(videoSearchState1.getVideoIdError(), "error");
    }

    @Test
    void setGetUser() {
        assertEquals(videoSearchState1.getUsername(), "");
        videoSearchState1.setUsername("user");
        assertEquals(videoSearchState1.getUsername(), "user");
    }

    @Test
    void copyTest() {
        videoSearchState1.setVideoId("id");
        VideoSearchState videoSearchState2 = new VideoSearchState(videoSearchState1);
        assertEquals(videoSearchState2.getVideoId(), videoSearchState1.getVideoId());
    }

}