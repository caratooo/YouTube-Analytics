package entities;

import com.google.api.client.util.DateTime;

public class Video {
    private final String videoId;
    private final String channelName;
    private final String title;
    private final String description;
    private final DateTime videoPublishDate;
    private final int viewCount;
    private final int likeCount;
    private final int commentCount;


    public Video(String videoId, String channelName, String title,
                 String description, DateTime videoPublishDate,
                 int viewCount, int likeCount, int commentCount) {
        this.videoId = videoId;
        this.channelName = channelName;
        this.title = title;

        if (description.length() > 100) {
            this.description = description.substring(0, 100) + "...";
        } else {
            this.description = description;
        }

        this.videoPublishDate = videoPublishDate;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public String getId() {
        return this.videoId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public DateTime getVideoPublishDate() {
        return this.videoPublishDate;
    }

    public int getViewCount() {
        return this.viewCount;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public int getCommentCount() {
        return this.commentCount;
    }


}
