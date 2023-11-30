package views;

import interface_adapter.trending.TrendingDataState;
import interface_adapter.trending.TrendingDataViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TrendingDataView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "trending data";
    private final TrendingDataViewModel trendingDataViewModel;

    JLabel topOne;
    JLabel topOneVideoId;
    JLabel topOneTitle;
    JLabel topOneDescription;
    JLabel topOneViewCount;
    JLabel topOneLikeCount;
    JLabel topOneCommentCount;

    JLabel topTwo;
    JLabel topTwoVideoId;
    JLabel topTwoTitle;
    JLabel topTwoDescription;
    JLabel topTwoViewCount;
    JLabel topTwoLikeCount;
    JLabel topTwoCommentCount;

    JLabel topThree;
    JLabel topThreeVideoId;
    JLabel topThreeTitle;
    JLabel topThreeDescription;
    JLabel topThreeViewCount;
    JLabel topThreeLikeCount;
    JLabel topThreeCommentCount;


    public TrendingDataView(TrendingDataViewModel trendingDataViewModel) {
        this.trendingDataViewModel = trendingDataViewModel;
        this.trendingDataViewModel.addPropertyChangeListener(this);

        topOne = new JLabel(" Top One");
        topOneVideoId = new JLabel();
        topOneTitle = new JLabel();
        topOneDescription = new JLabel();
        topOneViewCount = new JLabel();
        topOneLikeCount = new JLabel();
        topOneCommentCount = new JLabel();

        topTwo = new JLabel("Top Two");
        topTwoVideoId = new JLabel();
        topTwoTitle = new JLabel();
        topTwoDescription = new JLabel();
        topTwoViewCount = new JLabel();
        topTwoLikeCount = new JLabel();
        topTwoCommentCount = new JLabel();

        topThree = new JLabel("Top Three");
        topThreeVideoId = new JLabel();
        topThreeTitle = new JLabel();
        topThreeDescription = new JLabel();
        topThreeViewCount = new JLabel();
        topThreeLikeCount = new JLabel();
        topThreeCommentCount = new JLabel();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelOne = new JPanel();
        panelOne.add(topOne);
        panelOne.add(topOneVideoId);
        panelOne.add(topOneTitle);
        panelOne.add(topOneDescription);
        panelOne.add(topOneViewCount);
        panelOne.add(topOneLikeCount);
        panelOne.add(topOneCommentCount);
        this.add(panelOne);

        JPanel panelTwo = new JPanel();
        panelTwo.add(topTwo);
        panelTwo.add(topTwoVideoId);
        panelTwo.add(topTwoTitle);
        panelTwo.add(topTwoDescription);
        panelTwo.add(topTwoViewCount);
        panelTwo.add(topTwoLikeCount);
        panelTwo.add(topTwoCommentCount);
        this.add(panelTwo);

        JPanel panelThree = new JPanel();
        panelThree.add(topThree);
        panelThree.add(topThreeVideoId);
        panelThree.add(topThreeTitle);
        panelThree.add(topThreeDescription);
        panelThree.add(topThreeViewCount);
        panelThree.add(topThreeLikeCount);
        panelThree.add(topThreeCommentCount);
        this.add(panelThree);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TrendingDataState state = (TrendingDataState) evt.getNewValue();
        // Top One
        topOneVideoId.setText("Video ID:" + state.getTopOneVideoId());
        topOneTitle.setText("Title:" + state.getTopOneTitle());
        topOneDescription.setText("Description:" + state.getTopOneDescription());
        topOneViewCount.setText("View Count:" + state.getTopOneViewCount());
        topOneLikeCount.setText("Like Count:" + state.getTopOneLikeCount());
        topOneCommentCount.setText("Comment Count:" + state.getTopOneCommentCount());

        // Top Two
        topTwoVideoId.setText("Video ID:" + state.getTopTwoVideoId());
        topTwoTitle.setText("Title:" + state.getTopTwoTitle());
        topTwoDescription.setText("Description:" + state.getTopTwoDescription());
        topTwoViewCount.setText("View Count:" + state.getTopTwoViewCount());
        topTwoLikeCount.setText("Like Count:" + state.getTopTwoLikeCount());
        topTwoCommentCount.setText("Comment Count:" + state.getTopTwoCommentCount());

        // Top Three
        topThreeVideoId.setText("Video ID:" + state.getTopThreeVideoId());
        topThreeTitle.setText("Title:" + state.getTopThreeTitle());
        topThreeDescription.setText("Description:" + state.getTopThreeDescription());
        topThreeViewCount.setText("View Count:" + state.getTopThreeViewCount());
        topThreeLikeCount.setText("Like Count:" + state.getTopThreeLikeCount());
        topThreeCommentCount.setText("Comment Count:" + state.getTopThreeCommentCount());
    }
}
