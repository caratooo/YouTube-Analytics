package views;

import interface_adapter.channel_search.ChannelSearchState;
import interface_adapter.home.HomeController;
import interface_adapter.home.HomeViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.video_search.VideoSearchState;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_search.VideoSearchController;
import interface_adapter.channel_search.ChannelSearchState;
import interface_adapter.channel_search.ChannelSearchViewModel;
import interface_adapter.channel_search.ChannelSearchController;
import interface_adapter.trending.TrendingState;
import interface_adapter.trending.TrendingViewModel;
import interface_adapter.trending.TrendingController;
import interface_adapter.compare.CompareState;
import interface_adapter.compare.CompareViewModel;
import interface_adapter.compare.CompareController;
import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.history.HistoryController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HomeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "home";
    private final HomeViewModel homeViewModel;

    final JButton searchVideo;
    final JButton searchChannel;
    final JButton trending;
    final JButton compare;
    final JButton history;
    final JButton instruction;

    private final HomeController homeController;

    public HomeView(HomeController controller, HomeViewModel homeViewModel) {
        this.homeController = controller;
        this.homeViewModel = homeViewModel;
        homeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(HomeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        searchVideo = new JButton(HomeViewModel.SEARCHVIDEO_BUTTON_LABEL);
        buttons.add(searchVideo);
        searchChannel = new JButton(HomeViewModel.SEARCHCHANNEL_BUTTON_LABEL);
        buttons.add(searchChannel);
        trending = new JButton(HomeViewModel.TRENDING_BUTTON_LABEL);
        buttons.add(trending);
        compare = new JButton(HomeViewModel.COMPARE_BUTTON_LABEL);
        buttons.add(compare);
        history = new JButton(HomeViewModel.HISTORY_BUTTON_LABEL);
        buttons.add(history);
        instruction = new JButton(HomeViewModel.INSTRUCTION_BUTTON_LABEL);
        buttons.add(instruction);

//        searchVideo.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(searchVideo)) {
//                            VideoSearchState currentState = VideoSearchViewModel.getState();
//                            VideoSearchController.execute();
//                            // TODO
//                        }
//                    }
//                }
//        );
//
//        searchChannel.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(searchChannel)) {
//                            ChannelSearchState currentState = ChannelSearchViewModel.getState();
//                            ChannelSearchController.execute();
//                            // TODO
//                        }
//                    }
//                }
//        );
//
//        trending.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(trending)) {
//                            TrendingState currentState = TrendingViewModel.getState();
//                            TrendingController.execute();
//                            // TODO
//                        }
//                    }
//                }
//        );
//
//        compare.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(compare)) {
//                            CompareState currentState = CompareViewModel.getState();
//                            CompareController.execute();
//                            // TODO
//                        }
//                    }
//                }
//        );
//
//        history.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(history)) {
//                            HistoryState currentState = HistoryViewModel.getState();
//                            HistoryController.execute();
//                            // TODO
//                        }
//                    }
//                }
//        );
//
//        instruction.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(instruction)) {
//                            // TODO
//                        }
//                    }
//                }
//        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
