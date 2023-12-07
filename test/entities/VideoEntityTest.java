package entities;

import com.google.api.client.util.DateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class VideoEntityTest {

    private Video video;

    private Video longVideo;

    @BeforeEach
    void setup() {
        DateTime dateTime1 = new DateTime("2020-02-19T18:48:38.000Z");
        video = new Video("H-v6DfxnjF8",
                "FIE Fencing Channel",
                "Grand Prix Turin 2020 Women's Foil Final THIBUS FRA vs KIEFER USA",
                "",
                dateTime1,
                12996,
                169,
                9);

        DateTime dateTime2 = new DateTime("2020-02-19T18:48:38.000Z");
        longVideo = new Video("QbwgQSwMSGM",
                "Code Bullet",
                "AI Learns to Play SUIKA GAME",
                "At least two appropriate design patterns are discussed and evidence of which classes are involved are presented using appropriate visuals.",
                dateTime2,
                1, 1, 1
                );
    }

    @Test
    void getId() {
        assertEquals("H-v6DfxnjF8", video.getId());
    }

    @Test
    void getChannelName() {
        assertEquals("FIE Fencing Channel", video.getChannelName());
    }

    @Test
    void getTitle() {
        assertEquals("Grand Prix Turin 2020 Women's Foil Final THIBUS FRA vs KIEFER USA", video.getTitle());
    }

    @Test
    void getDescription() {
        assertEquals("", video.getDescription());
    }

    @Test
    void getViewCount() {
        assertEquals(12996, video.getViewCount());
    }

    @Test
    void getLikeCount() {
        assertEquals(169, video.getLikeCount());
    }

    @Test
    void getCommentCount() {
        assertEquals(9, video.getCommentCount());
    }

    @Test
    void checkDescriptionLength() {
        assertTrue(longVideo.getDescription().length() <= 103);
    }

}
