package interface_adapter.video_stats;

import com.google.api.client.util.DateTime;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VideoStatsStateTest {

    VideoStatsState videoStatsState1 = new VideoStatsState();

    @Test
    void getters() {
        DateTime videoPublishDate = new DateTime("2013-02-14T13:15:03-08:00");
        ArrayList<Object> channelInfo = new ArrayList<>();

        assertEquals(videoStatsState1.getVideoId(), "");
        assertEquals(videoStatsState1.getTitle(), "");
        assertEquals(videoStatsState1.getChannelName(), "");
        assertEquals(videoStatsState1.getDescription(), "");
        assertEquals(videoStatsState1.getLikeCount(), 0);
        assertEquals(videoStatsState1.getViewCount(), 0);
        assertEquals(videoStatsState1.getCommentCount(), 0);
        assertEquals(videoStatsState1.getVideoPublishDate(), videoPublishDate);
        assertEquals(videoStatsState1.getChannelInfo(), channelInfo);
    }

    @Test
    void copyTest() {
        videoStatsState1.setVideoId("id");
        VideoStatsState videoStatsState2 = new VideoStatsState(videoStatsState1);
        assertEquals(videoStatsState1.getVideoId(), videoStatsState2.getVideoId());
    }

}