package use_case.video_search;

import com.google.api.client.util.DateTime;

public class VideoSearchOutputData {

    private final String videoId;

    private final String channelName;

    private final String title;

    private final String description;

    private final DateTime videoPublishDate;

    private final int viewCount;

    private final int likeCount;

    private final int commentCount;

    private boolean useCaseFailed;

    public VideoSearchOutputData (String videoId, String channelName, String title,
                                  String description, DateTime videoPublishDate,
                                  int viewCount, int likeCount, int commentCount, boolean useCaseFailed) {
        this.videoId = videoId;
        this.channelName = channelName;
        this.title = title;
        this.description = description;
        this.videoPublishDate = videoPublishDate;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.useCaseFailed = useCaseFailed;
    }

    public String getVideoId() { return videoId; }

    public String getChannelName() { return channelName; }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public DateTime getVideoPublishDate() { return videoPublishDate; }

    public int getViewCount() { return viewCount; }

    public int getLikeCount() { return likeCount; }

    public int getCommentCount() {return commentCount; }

    public String toString() {
        return videoId + "," +
                channelName + "," +
                title + "," +
                description + "," +
                videoPublishDate.toString() + "," +
                viewCount + "," +
                likeCount + "," +
                commentCount;
    }

    }
