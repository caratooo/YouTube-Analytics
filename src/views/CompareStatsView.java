package views;

import interface_adapter.ViewManagerModel;
import interface_adapter.compare_stats.CompareStatsState;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.home.HomeViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.List;

public class CompareStatsView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "compare stats";

    private final CompareStatsViewModel compareStatsViewModel;
    JLabel videoIdOne = new JLabel();
    JLabel channelNameOne = new JLabel();
    JLabel videoTitleOne = new JLabel();
    JLabel descriptionOne = new JLabel();
    JLabel videoPublishDateOne = new JLabel();
    JLabel viewCountOne = new JLabel();
    JLabel likeCountOne = new JLabel();
    JLabel commentCountOne = new JLabel();
    JLabel videoIdTwo = new JLabel();
    JLabel channelNameTwo = new JLabel();
    JLabel videoTitleTwo = new JLabel();
    JLabel descriptionTwo = new JLabel();
    JLabel videoPublishDateTwo = new JLabel();
    JLabel viewCountTwo = new JLabel();
    JLabel likeCountTwo = new JLabel();
    JLabel commentCountTwo = new JLabel();
    JPanel buttons = new JPanel();

    private final List<JLabel> labelsOne = Arrays.asList(
            videoIdOne, channelNameOne, videoTitleOne, descriptionOne, videoPublishDateOne, viewCountOne, likeCountOne, commentCountOne
    );
    private final List<JLabel> labelsTwo = Arrays.asList(
            videoIdTwo, channelNameTwo, videoTitleTwo, descriptionTwo, videoPublishDateTwo, viewCountTwo, likeCountTwo, commentCountTwo
    );

    private final List<List<JLabel>> labels = Arrays.asList(labelsOne, labelsTwo);

    private final JButton back;
    public CompareStatsView(CompareStatsViewModel compareStatsViewModel, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.compareStatsViewModel = compareStatsViewModel;
        this.compareStatsViewModel.addPropertyChangeListener(this);
        back = new JButton(CompareStatsViewModel.BACK_BUTTON_LABEL);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Video Stats Comparison Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel videos = new JPanel();
        videos.setLayout(new BoxLayout(videos, BoxLayout.Y_AXIS));
        JPanel video1 = new JPanel();
        video1.setLayout(new BoxLayout(video1, BoxLayout.Y_AXIS));
        JPanel video2 = new JPanel();
        video2.setLayout(new BoxLayout(video2, BoxLayout.Y_AXIS));

        sortPanels(Arrays.asList(video1, video2));

        videos.add(video1);
        videos.add(video2);

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            viewManagerModel.setActiveView(homeViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        buttons.setLayout(new FlowLayout()); // This layout manager respects component's preferred sizes.
        back.setPreferredSize(new Dimension(200, 100));
        buttons.add(back);

        this.add(title);
        this.add(videos);
        this.add(buttons);
    }

    private void sortPanels(List<JPanel> videoPanelList) {
        for (int i = 0; i < 2; i++) {
            JLabel title = new JLabel(String.format("Video %s", (i+1)));
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
            title.setBorder(new EmptyBorder(10, 10, 10, 10));
            videoPanelList.get(i).add(title);

            JPanel stats = new JPanel();
            stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));

            List<JLabel> labelList = labels.get(i);
            for (int i2 = 0; i2 < labelList.size(); i2++) {
                labelList.get(i2).setBorder(new EmptyBorder(4, 0, 4, 0));
                stats.add(labelList.get(i2));
            }
            stats.setAlignmentX(Component.CENTER_ALIGNMENT);
            videoPanelList.get(i).add(stats);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CompareStatsState state = compareStatsViewModel.getState();
        videoIdOne.setText("Video ID: " + state.getVideoIdOne());
        channelNameOne.setText("Channel name: " + state.getChannelNameOne());
        videoTitleOne.setText("Video name: " + state.getTitleOne());
        descriptionOne.setText("Description: " + state.getDescriptionOne());
        videoPublishDateOne.setText("Video publish date: " + state.getVideoPublishDateOne().toString());
        viewCountOne.setText("View count: " + state.getViewCountOne());
        likeCountOne.setText("Like count: " + state.getLikeCountOne());
        commentCountOne.setText("Comment count: " + state.getCommentCountOne());

        videoIdTwo.setText("Video ID: " + state.getVideoIdTwo());
        channelNameTwo.setText("Channel name: " + state.getChannelNameTwo());
        videoTitleTwo.setText("Video name: " + state.getTitleTwo());
        descriptionTwo.setText("Description: " + state.getDescriptionTwo());
        videoPublishDateTwo.setText("Video publish date: " + state.getVideoPublishDateTwo().toString());
        viewCountTwo.setText("View count: " + state.getViewCountTwo());
        likeCountTwo.setText("Like count: " + state.getLikeCountTwo());
        commentCountTwo.setText("Comment count: " + state.getCommentCountTwo());
    }
}
