package views;

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

        videoId = new JLabel();

        channelName = new JLabel();

        videoTitle = new JLabel();

        description = new JLabel();

        videoPublishDate = new JLabel();

        viewCount = new JLabel();

        likeCount = new JLabel();

        commentCount = new JLabel();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(videoId);
        this.add(channelName);
        this.add(videoTitle);
        this.add(description);
        this.add(videoPublishDate);
        this.add(viewCount);
        this.add(likeCount);
        this.add(commentCount);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        VideoStatsState state = (VideoStatsState) evt.getNewValue();
        videoId.setText("Video ID: " + state.getVideoId());
        channelName.setText("Channel name: " + state.getChannelName());
        videoTitle.setText("Video name: " + state.getTitle());
        description.setText("Description: " + state.getDescription());
        videoPublishDate.setText("Video publish date: " + state.getVideoPublishDate().toString());
        viewCount.setText("View count: " + state.getViewCount());
        likeCount.setText("Like count: " + state.getLikeCount());
        commentCount.setText("Comment count: " + state.getCommentCount());
    }
}
