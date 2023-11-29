package views;

import interface_adapter.trending.TrendingDataState;
import interface_adapter.trending.TrendingDataViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TrendingDataView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "trending data";
    private final TrendingDataViewModel trendingDataViewModel;

    JLabel topOneVideoId;
    JLabel topOneTitle;
    JLabel topOneDescription;
    JLabel topOneViewCount;
    JLabel topOneLikeCount;
    JLabel topOneCommentCount;
    JLabel topTwoVideoId;
    JLabel topTwoTitle;
    JLabel topTwoDescription;
    JLabel topTwoViewCount;
    JLabel topTwoLikeCount;
    JLabel topTwoCommentCount;
    JLabel topThreeVideoId;
    JLabel topThreeTitle;
    JLabel topThreeDescription;
    JLabel topThreeViewCount;
    JLabel topThreeLikeCount;
    JLabel topThreeCommentCount;



    public TrendingDataView(TrendingDataViewModel trendingDataViewModel) {
        this.trendingDataViewModel = trendingDataViewModel;
        this.trendingDataViewModel.addPropertyChangeListener(this);

        topOneVideoId = new JLabel();
        topOneTitle = new JLabel();
        topOneDescription = new JLabel();
        topOneViewCount = new JLabel();
        topOneLikeCount = new JLabel();
        topOneCommentCount = new JLabel();
        topTwoVideoId = new JLabel();
        topTwoTitle = new JLabel();
        topTwoDescription = new JLabel();
        topTwoViewCount = new JLabel();
        topTwoLikeCount = new JLabel();
        topTwoCommentCount = new JLabel();
        topThreeVideoId = new JLabel();
        topThreeTitle = new JLabel();
        topThreeDescription = new JLabel();
        topThreeViewCount = new JLabel();
        topThreeLikeCount = new JLabel();
        topThreeCommentCount = new JLabel();

        this.add(topOneVideoId);
        this.add(topOneTitle);
        this.add(topOneDescription);
        this.add(topOneViewCount);
        this.add(topOneLikeCount);
        this.add(topOneCommentCount);
        this.add(topTwoVideoId);
        this.add(topTwoTitle);
        this.add(topTwoDescription);
        this.add(topTwoViewCount);
        this.add(topTwoLikeCount);
        this.add(topTwoCommentCount);
        this.add(topThreeVideoId);
        this.add(topThreeTitle);
        this.add(topThreeDescription);
        this.add(topThreeViewCount);
        this.add(topThreeLikeCount);
        this.add(topThreeCommentCount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TrendingDataState state = (TrendingDataState) evt.getNewValue();
        topOneVideoId.setText("Top One Video ID:" + state.getTopOneVideoId());
        topOneTitle.setText("Top One Title:" + state.getTopOneTitle());
        topOneDescription.setText("Top One Description:" + state.getTopOneDescription());
        topOneViewCount.setText("Top One View Count:" + state.getTopOneViewCount());
        topOneLikeCount.setText("Top One Like Count:" + state.getTopOneLikeCount());
        topOneCommentCount.setText("Top One Comment Count:" + state.getTopOneCommentCount());
        topTwoVideoId.setText("Top Two Video ID:" + state.getTopTwoVideoId());
        topTwoTitle.setText("Top Two Title:" + state.getTopTwoTitle());
        topTwoDescription.setText("Top Two Description:" + state.getTopTwoDescription());
        topTwoViewCount.setText("Top Two View Count:" + state.getTopTwoViewCount());
        topTwoLikeCount.setText("Top Two Like Count:" + state.getTopTwoLikeCount());
        topTwoCommentCount.setText("Top Two Comment Count:" + state.getTopTwoCommentCount());
        topThreeVideoId.setText("Top Three Video ID:" + state.getTopThreeVideoId());
        topThreeTitle.setText("Top Three Title:" + state.getTopThreeTitle());
        topThreeDescription.setText("Top Three Description:" + state.getTopThreeDescription());
        topThreeViewCount.setText("Top Three View Count:" + state.getTopThreeViewCount());
        topThreeLikeCount.setText("Top Three Like Count:" + state.getTopThreeLikeCount());
        topThreeCommentCount.setText("Top Three Comment Count:" + state.getTopThreeCommentCount());


    }
}
