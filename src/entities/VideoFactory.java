package entities;

import com.google.api.client.util.DateTime;

public class VideoFactory {

    public Video create(String videoId, String channelName, String title,
                 String description, DateTime videoPublishDate,
                 int viewCount, int likeCount, int commentCount) {
        return new Video(videoId, channelName, title,
                description, videoPublishDate,
                viewCount, likeCount, commentCount);
    }

}
