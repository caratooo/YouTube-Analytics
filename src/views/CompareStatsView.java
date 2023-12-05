package views;

import interface_adapter.ViewManagerModel;
import interface_adapter.compare_stats.CompareStatsState;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.home.HomeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class CompareStatsView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "compare video stats";

    private final CompareStatsViewModel compareStatsViewModel;
    JLabel videoIdOne;
    JLabel channelNameOne;
    JLabel videoTitleOne;
    JLabel descriptionOne;
    JLabel videoPublishDateOne;
    JLabel viewCountOne;
    JLabel likeCountOne;
    JLabel commentCountOne;
    JLabel videoIdTwo;
    JLabel channelNameTwo;
    JLabel videoTitleTwo;
    JLabel descriptionTwo;
    JLabel videoPublishDateTwo;
    JLabel viewCountTwo;
    JLabel likeCountTwo;
    JLabel commentCountTwo;
    private final JButton back;
    public CompareStatsView(CompareStatsViewModel compareStatsViewModel, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {
        this.compareStatsViewModel = compareStatsViewModel;
        this.compareStatsViewModel.addPropertyChangeListener(this);
        back = new JButton(CompareStatsViewModel.BACK_BUTTON_LABEL);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Video Stats Comparison Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        JPanel panel5 = new JPanel();
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
        JPanel panel7 = new JPanel();
        panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));
        JPanel panel9 = new JPanel();
        panel9.setLayout(new BoxLayout(panel9, BoxLayout.Y_AXIS));

        ArrayList<JLabel> labelsOne = new ArrayList<>();
        ArrayList<JLabel> labelsTwo = new ArrayList<>();
        JLabel videoIdOne = new JLabel();
        JLabel channelNameOne = new JLabel();
        JLabel videoTitleOne = new JLabel();
        JLabel descriptionOne = new JLabel();
        JLabel videoPublishDateOne = new JLabel();
        JLabel viewCountOne = new JLabel();
        JLabel likeCountOne = new JLabel();
        JLabel commentCountOne = new JLabel();
        labelsOne.add(videoIdOne);
        labelsOne.add(channelNameOne);
        labelsOne.add(videoTitleOne);
        labelsOne.add(descriptionOne);
        labelsOne.add(videoPublishDateOne);
        labelsOne.add(viewCountOne);
        labelsOne.add(likeCountOne);
        labelsOne.add(commentCountOne);
        JLabel videoIdTwo = new JLabel();
        JLabel channelNameTwo = new JLabel();
        JLabel videoTitleTwo = new JLabel();
        JLabel descriptionTwo = new JLabel();
        JLabel videoPublishDateTwo = new JLabel();
        JLabel viewCountTwo = new JLabel();
        JLabel likeCountTwo = new JLabel();
        JLabel commentCountTwo = new JLabel();
        labelsTwo.add(videoIdTwo);
        labelsTwo.add(channelNameTwo);
        labelsTwo.add(videoTitleTwo);
        labelsTwo.add(descriptionTwo);
        labelsTwo.add(videoPublishDateTwo);
        labelsTwo.add(viewCountTwo);
        labelsTwo.add(likeCountTwo);
        labelsTwo.add(commentCountTwo);
        panel3.add(title);
        add_labels(labelsOne, panel5);
        add_labels(labelsTwo, panel7);
        panel9.add(back);
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
        panel1.add(panel3);
        panel1.add(panel5);
        panel1.add(panel7);
        panel1.add(panel9);
        this.add(panel1);


    }
    public void add_labels(ArrayList<JLabel> labels, JPanel panel){
        for (int i = 0; i < labels.size(); i++){
            labels.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(labels.get(i));
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CompareStatsState state = (CompareStatsState) evt.getNewValue();
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
