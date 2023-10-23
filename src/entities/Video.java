package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Video {
    private final String videoId;
    private final Channel channel;
    private final String title;
    private final String description;
    private final LocalDate videoPublishDate;
    private final ArrayList<String> categories;
    private final int viewCount;
    private final int likeCount;
    private final int faouvriteCount;
    private final int commentCount;


    public Video(String videoId, Channel channel, String title, String description, LocalDate videoPublishDate, ArrayList<String> categories, int viewCount, int likeCount, int faouvriteCount, int commentCount) {
        this.videoId = videoId;
        this.channel = channel;
        this.title = title;
        this.description = description;
        this.videoPublishDate = videoPublishDate;
        this.categories = categories;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.faouvriteCount = faouvriteCount;
        this.commentCount = commentCount;
    }
}
