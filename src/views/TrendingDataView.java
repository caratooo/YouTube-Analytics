package views;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.trending_data.TrendingDataState;
import interface_adapter.trending_data.TrendingDataViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TrendingDataView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "trending data";
    private final TrendingDataViewModel trendingDataViewModel;
    private JButton homeButton;

    JLabel category;
    JLabel topOne;
    JLabel topOneVideoId;
    JLabel topOneChannelName;
    JLabel topOneTitle;
    JLabel topOneDescription;
    JLabel topOneVideoPublishDate;
    JLabel topOneViewCount;
    JLabel topOneLikeCount;
    JLabel topOneCommentCount;

    JLabel topTwo;
    JLabel topTwoVideoId;
    JLabel topTwoChannelName;
    JLabel topTwoTitle;
    JLabel topTwoDescription;
    JLabel topTwoVideoPublishDate;
    JLabel topTwoViewCount;
    JLabel topTwoLikeCount;
    JLabel topTwoCommentCount;

    JLabel topThree;
    JLabel topThreeVideoId;
    JLabel topThreeChannelName;
    JLabel topThreeTitle;
    JLabel topThreeDescription;
    JLabel topThreeVideoPublishDate;
    JLabel topThreeViewCount;
    JLabel topThreeLikeCount;
    JLabel topThreeCommentCount;


    public TrendingDataView(TrendingDataViewModel trendingDataViewModel, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {
        this.trendingDataViewModel = trendingDataViewModel;
        this.trendingDataViewModel.addPropertyChangeListener(this);

        //initialize components
        homeButton = new JButton("Home");

        category = new JLabel();

        topOne = new JLabel("Top One");
        topOneVideoId = new JLabel();
        topOneChannelName = new JLabel();
        topOneTitle = new JLabel();
        topOneDescription = new JLabel();
        topOneVideoPublishDate = new JLabel();
        topOneViewCount = new JLabel();
        topOneLikeCount = new JLabel();
        topOneCommentCount = new JLabel();

        topTwo = new JLabel("Top Two");
        topTwoVideoId = new JLabel();
        topTwoChannelName = new JLabel();
        topTwoTitle = new JLabel();
        topTwoDescription = new JLabel();
        topTwoVideoPublishDate = new JLabel();
        topTwoViewCount = new JLabel();
        topTwoLikeCount = new JLabel();
        topTwoCommentCount = new JLabel();

        topThree = new JLabel("Top Three");
        topThreeVideoId = new JLabel();
        topThreeChannelName = new JLabel();
        topThreeTitle = new JLabel();
        topThreeDescription = new JLabel();
        topThreeVideoPublishDate = new JLabel();
        topThreeViewCount = new JLabel();
        topThreeLikeCount = new JLabel();
        topThreeCommentCount = new JLabel();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel panelTitle = new JPanel();
        panelTitle.add(category);
        this.add(panelTitle);

        // Top 1
        JPanel panelOneWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel panelOneFlow = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel panelOne = new JPanel();
        panelOne.setLayout(new BoxLayout(panelOne, BoxLayout.Y_AXIS));

        JPanel panelOneTitle = new JPanel();

        panelOneTitle.add(topOne);
        panelOne.add(topOneVideoId);
        panelOne.add(topOneChannelName);
        panelOne.add(topOneTitle);
        panelOne.add(topOneDescription);
        panelOne.add(topOneVideoPublishDate);
        panelOne.add(topOneViewCount);
        panelOne.add(topOneLikeCount);
        panelOne.add(topOneCommentCount);

        panelOneFlow.add(panelOne);
        panelOneWrapper.add(panelOneFlow);

        panelOneTitle.setBackground(new Color(217, 218, 219));
        panelOne.setBackground(new Color(217, 218, 219));
        panelOneFlow.setBackground(new Color(217, 218, 219));
        panelOneWrapper.setBackground(new Color(217, 218, 219));
        this.add(panelOneTitle);
        this.add(panelOneWrapper);

        // Top 2
        JPanel panelTwoWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel panelTwoFlow = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel panelTwo = new JPanel();
        panelTwo.setLayout(new BoxLayout(panelTwo, BoxLayout.Y_AXIS));

        JPanel panelTwoTitle = new JPanel();

        panelTwoTitle.add(topTwo);
        panelTwo.add(topTwoVideoId);
        panelTwo.add(topTwoChannelName);
        panelTwo.add(topTwoTitle);
        panelTwo.add(topTwoDescription);
        panelTwo.add(topTwoVideoPublishDate);
        panelTwo.add(topTwoViewCount);
        panelTwo.add(topTwoLikeCount);
        panelTwo.add(topTwoCommentCount);

        panelTwoFlow.add(panelTwo);
        panelTwoWrapper.add(panelTwoFlow);

        this.add(panelTwoTitle);
        this.add(panelTwoWrapper);

        // Top 3
        JPanel panelThreeWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel panelThreeFlow = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel panelThree = new JPanel();
        panelThree.setLayout(new BoxLayout(panelThree, BoxLayout.Y_AXIS));

        JPanel panelThreeTitle = new JPanel();

        panelThreeTitle.add(topThree);
        panelThree.add(topThreeVideoId);
        panelThree.add(topThreeChannelName);
        panelThree.add(topThreeTitle);
        panelThree.add(topThreeDescription);
        panelThree.add(topThreeVideoPublishDate);
        panelThree.add(topThreeViewCount);
        panelThree.add(topThreeLikeCount);
        panelThree.add(topThreeCommentCount);

        panelThreeFlow.add(panelThree);
        panelThreeWrapper.add(panelThreeFlow);

        panelThreeTitle.setBackground(new Color(217, 218, 219));
        panelThree.setBackground(new Color(217, 218, 219));
        panelThreeFlow.setBackground(new Color(217, 218, 219));
        panelThreeWrapper.setBackground(new Color(217, 218, 219));

        this.add(panelThreeTitle);
        this.add(panelThreeWrapper);

        JPanel panelHome = new JPanel();
        panelHome.add(homeButton);
        homeButton.setPreferredSize(new Dimension(200, 100));
        this.add(panelHome);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManagerModel.setActiveView(homeViewModel.getViewName());
                viewManagerModel.firePropertyChanged();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TrendingDataState state = (TrendingDataState) evt.getNewValue();

        category.setText("Trending in " + state.getCategory());
        // Top One
        topOneVideoId.setText("Video ID: " + state.getTopOneVideoId());
        topOneChannelName.setText("Channel Name: " + state.getTopOneChannelName());
        topOneTitle.setText("Title: " + state.getTopOneTitle());
        topOneDescription.setText("Description: " + state.getTopOneDescription());
        topOneVideoPublishDate.setText("Publish date: " + state.getTopOneVideoPublishDate());
        topOneViewCount.setText("View Count: " + state.getTopOneViewCount());
        topOneLikeCount.setText("Like Count: " + state.getTopOneLikeCount());
        topOneCommentCount.setText("Comment Count: " + state.getTopOneCommentCount());

        // Top Two
        topTwoVideoId.setText("Video ID: " + state.getTopTwoVideoId());
        topTwoChannelName.setText("Channel Name: " + state.getTopTwoChannelName());
        topTwoTitle.setText("Title: " + state.getTopTwoTitle());
        topTwoDescription.setText("Description: " + state.getTopTwoDescription());
        topTwoVideoPublishDate.setText("Publish date: " + state.getTopTwoVideoPublishDate());
        topTwoViewCount.setText("View Count: " + state.getTopTwoViewCount());
        topTwoLikeCount.setText("Like Count: " + state.getTopTwoLikeCount());
        topTwoCommentCount.setText("Comment Count: " + state.getTopTwoCommentCount());

        // Top Three
        topThreeVideoId.setText("Video ID: " + state.getTopThreeVideoId());
        topThreeChannelName.setText("Channel Name: " + state.getTopThreeChannelName());
        topThreeTitle.setText("Title: " + state.getTopThreeTitle());
        topThreeDescription.setText("Description: " + state.getTopThreeDescription());
        topThreeVideoPublishDate.setText("Publish date: " + state.getTopThreeVideoPublishDate());
        topThreeViewCount.setText("View Count: " + state.getTopThreeViewCount());
        topThreeLikeCount.setText("Like Count: " + state.getTopThreeLikeCount());
        topThreeCommentCount.setText("Comment Count: " + state.getTopThreeCommentCount());
    }
}
