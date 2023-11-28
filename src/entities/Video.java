package entities;

import com.google.api.client.util.DateTime;

import java.math.BigInteger;
import java.time.LocalDate;

public class Video {
    private final String videoId;
    private final String channelName;
    private final String title;
    private final String description;
    private final DateTime videoPublishDate;
    private final BigInteger viewCount;
    private final BigInteger likeCount;
    private final BigInteger commentCount;


    public Video(String videoId, String channelName, String title,
                 String description, DateTime videoPublishDate,
                 BigInteger viewCount, BigInteger likeCount, BigInteger commentCount) {
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

    public DateTime getVideoPublishDate() {
        return this.videoPublishDate;
    }

    public BigInteger getViewCount() {
        return this.viewCount;
    }

    public BigInteger getLikeCount() {
        return this.likeCount;
    }

    public BigInteger getCommentCount() {
        return this.commentCount;
    }


}
