package views;

import com.google.api.client.util.DateTime;
import interface_adapter.video_stats.VideoStatsState;
import interface_adapter.video_stats.VideoStatsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VideoStatsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "video stats";

    private final VideoStatsViewModel videoStatsViewModel;

    JLabel videoId;

    JLabel channelName;

    JLabel videoTitle;

    JLabel description;

    JLabel videoPublishDate;

    JLabel viewCount;

    JLabel likeCount;

    JLabel commentCount;


    public VideoStatsView(VideoStatsViewModel videoStatsViewModel) {
        this.videoStatsViewModel = videoStatsViewModel;
        this.videoStatsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Video Stats Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel videoIdInfo = new JLabel("Video ID: ");
        videoId = new JLabel();

        // TODO for below, see issue #32

        JLabel videoChannelInfo = new JLabel("Channel: ");
        channelName = new JLabel();

        JLabel videoTitleInfo = new JLabel("Title: ");
        videoTitle = new JLabel();

        JLabel videoDescriptionInfo = new JLabel("Title: ");
        description = new JLabel();

        JLabel videoPublishDateInfo = new JLabel("Title: ");
        videoPublishDate = new JLabel();

        JLabel viewCountInfo = new JLabel("Title: ");
        viewCount = new JLabel();

        JLabel likeCountInfo = new JLabel("Title: ");
        likeCount = new JLabel();

        JLabel commentCountInfo = new JLabel("Title: ");
        commentCount = new JLabel();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(videoIdInfo);
        this.add(videoId);
        this.add(videoChannelInfo);
        this.add(channelName);
        this.add(videoTitleInfo);
        this.add(videoTitle);
        this.add(videoDescriptionInfo);
        this.add(description);
        this.add(videoPublishDateInfo);
        this.add(videoPublishDate);
        this.add(viewCountInfo);
        this.add(viewCount);
        this.add(likeCountInfo);
        this.add(likeCount);
        this.add(commentCountInfo);
        this.add(commentCount);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        VideoStatsState state = (VideoStatsState) evt.getNewValue();
        videoId.setText(state.getVideoId());
        channelName.setText(state.getChannelName());
        videoTitle.setText(state.getTitle());
        description.setText(state.getDescription());
        videoPublishDate.setText(state.getVideoPublishDate().toString());
        viewCount.setText(String.valueOf(state.getViewCount()));
        likeCount.setText(String.valueOf(state.getTitle()));
        commentCount.setText(String.valueOf(state.getTitle()));
    }
}
