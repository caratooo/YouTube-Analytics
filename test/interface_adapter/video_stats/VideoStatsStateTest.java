package interface_adapter.video_stats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoStatsStateTest {

    VideoStatsState videoStatsState1 = new VideoStatsState();

    @Test
    void getters() {
        assertEquals(videoStatsState1.getVideoId(), "");
        assertEquals(videoStatsState1.getTitle(), "");
        assertEquals(videoStatsState1.getChannelName(), "");
        assertEquals(videoStatsState1.getDescription(), "");
        assertEquals(videoStatsState1.getLikeCount(), 0);
        assertEquals(videoStatsState1.getViewCount(), 0);
        assertEquals(videoStatsState1.getCommentCount(), 0);
    }

    @Test
    void copyTest() {
        videoStatsState1.setVideoId("id");
        VideoStatsState videoStatsState2 = new VideoStatsState(videoStatsState1);
        assertEquals(videoStatsState1.getVideoId(), videoStatsState2.getVideoId());
    }

}