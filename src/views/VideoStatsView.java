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
    JLabel about;
    JLabel stats;


    public VideoStatsView(VideoStatsViewModel videoStatsViewModel) {
        this.videoStatsViewModel = videoStatsViewModel;
        this.videoStatsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Video Stats Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel videoIdInfo = new JLabel("Video ID: ");
        videoId = new JLabel();

        // TODO for below, see issue #32

        JLabel videoAboutInfo = new JLabel("About: ");
        about = new JLabel();

        JLabel videoStatsInfo = new JLabel("Stats: ");
        stats = new JLabel();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(videoIdInfo);
        this.add(videoId);
        this.add(videoAboutInfo);
        this.add(about);
        this.add(videoStatsInfo);
        this.add(stats);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        VideoStatsState state = (VideoStatsState) evt.getNewValue();
        videoId.setText(state.getVideoId());
        about.setText(state.getVideoAbout());
        stats.setText(state.getVideoStats());
    }
}
