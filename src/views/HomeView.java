package views;

import interface_adapter.ViewManagerModel;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.history.HistoryController;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.video_search.VideoSearchState;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.trending_category_select.TrendingCategorySelectViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static views.InstructionsView.openInstructionsPanel;

public class HomeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "home";
    private final HomeViewModel homeViewModel;
    private final SignupViewModel signupViewModel;
    private final ViewManagerModel viewManagerModel;

    final JButton searchVideo;
    final JButton trending;
    final JButton compare;
    final JButton history;
    final JButton instructions;

    final JButton logout;



    public HomeView(HomeViewModel homeViewModel, SignupViewModel signupViewModel,
                    TrendingCategorySelectViewModel trendingCategorySelectViewModel,
                    VideoSearchViewModel videoSearchViewModel, VideoStatsViewModel videoStatsViewModel,
                    ViewManagerModel viewManagerModel, HistoryController historyController,
                    LoginViewModel loginViewModel, CompareSearchViewModel compareSearchViewModel,
                    CompareStatsViewModel compareStatsViewModel) {
        this.homeViewModel = homeViewModel;
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
        homeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(HomeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsTop = new JPanel();
        searchVideo = new JButton(HomeViewModel.SEARCHVIDEO_BUTTON_LABEL);
        searchVideo.setPreferredSize(new Dimension(200, 100));
        buttonsTop.add(searchVideo);
        trending = new JButton(HomeViewModel.TRENDING_BUTTON_LABEL);
        trending.setPreferredSize(new Dimension(200, 100));
        buttonsTop.add(trending);
        compare = new JButton(HomeViewModel.COMPARE_BUTTON_LABEL);
        compare.setPreferredSize(new Dimension(200, 100));
        buttonsTop.add(compare);

        JPanel buttonsBottom = new JPanel();
        history = new JButton(HomeViewModel.HISTORY_BUTTON_LABEL);
        history.setPreferredSize(new Dimension(200, 100));
        buttonsBottom.add(history);
        instructions = new JButton(HomeViewModel.INSTRUCTIONS_BUTTON_LABEL);
        instructions.setPreferredSize(new Dimension(200, 100));
        buttonsBottom.add(instructions);
        logout = new JButton(HomeViewModel.LOGOUT_BUTTON_LABEL);
        logout.setPreferredSize(new Dimension(200, 100));
        buttonsBottom.add(logout);

        searchVideo.addActionListener(
//                 This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(searchVideo)) {
                            VideoSearchState state = videoSearchViewModel.getState();
                            state.setUsername(loginViewModel.getState().getUsername());
                            videoSearchViewModel.setState(state);

                            viewManagerModel.setActiveView(videoSearchViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        trending.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(trending)) {
                            viewManagerModel.setActiveView(trendingCategorySelectViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();

                        }
                    }
                }
        );

        compare.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(compare)) {
                            viewManagerModel.setActiveView(compareSearchViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        history.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(history)) {
                            historyController.execute(loginViewModel.getState().getUsername());
                        }
                    }
                }
        );

        instructions.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(instructions)) {
                            openInstructionsPanel();
                        }
                    }
                }
        );
        logout.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logout)) {
                            viewManagerModel.setActiveView(signupViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(1200, 100)));
        this.add(buttonsTop);
        this.add(Box.createRigidArea(new Dimension(1200, 100)));
        this.add(buttonsBottom);
        this.add(Box.createRigidArea(new Dimension(1200, 250)));
    }
    @Override
    public void actionPerformed(ActionEvent e)  {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
