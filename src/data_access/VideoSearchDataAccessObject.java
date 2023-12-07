package data_access;

import com.google.api.client.util.DateTime;
import entities.Video;
import entities.VideoFactory;
import use_case.video_search.VideoSearchDataAccessInterface;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

public class VideoSearchDataAccessObject implements VideoSearchDataAccessInterface {

    private final Map<String, Video> videos = new HashMap<>();

    public VideoSearchDataAccessObject() {
        VideoFactory factory = new VideoFactory();
        DateTime dateTime1 = new DateTime("2020-02-19T18:48:38.000Z");
        Video video = factory.create("H-v6DfxnjF8",
                "FIE Fencing Channel",
                "Grand Prix Turin 2020 Women's Foil Final THIBUS FRA vs KIEFER USA",
                "",
                dateTime1,
                12996,
                169,
                9);

        this.videos.put(video.getId(), video);
    }

    @Override
    public Video getVideo(String videoId) {
        return videos.get(videoId);
    }

    @Override
    public boolean isInvalid(String identifier) {
        return !(videos.containsKey(identifier));
    }

}
