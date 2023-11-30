package entities;

import com.google.api.client.util.DateTime;

import java.math.BigInteger;
import java.time.LocalDate;

public class VideoFactory {

    Video create(String videoId, String channelName, String title,
                 String description, DateTime videoPublishDate,
                 int viewCount, int likeCount, int commentCount) {
        return new Video(videoId, channelName, title,
                description, videoPublishDate,
                viewCount, likeCount, commentCount);
    }

}
