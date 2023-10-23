package entities;

import java.time.LocalDate;

public class Channel {
    private final String channelId;
    private final String channelDescription;
    private final int viewCount;
    private final int subscriberCount;
    private final boolean hiddenSubscriberCount;
    private final int videoCount;
    private final LocalDate channelCreationDate;


    public Channel(String channelId, String channelDescription, int viewCount, int subscriberCount, boolean hiddenSubscriberCount, int videoCount, LocalDate channelCreationDate) {
        this.channelId = channelId;
        this.channelDescription = channelDescription;
        this.viewCount = viewCount;
        this.subscriberCount = subscriberCount;
        this.hiddenSubscriberCount = hiddenSubscriberCount;
        this.videoCount = videoCount;
        this.channelCreationDate = channelCreationDate;
    }
}
