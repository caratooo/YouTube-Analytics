package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Video {
    private final String videoId;
    private final String channelName;
    private final String title;
    private final String description;
    private final LocalDate videoPublishDate;
    private final int viewCount;
    private final int likeCount;
    private final int commentCount;


    public Video(String videoId, String channelName, String title,
                 String description, LocalDate videoPublishDate,
                 int viewCount, int likeCount, int commentCount) {
        this.videoId = videoId;
        this.channelName = channelName;
        this.title = title;
        this.description = description;
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

    public LocalDate getVideoPublishDate() {
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
