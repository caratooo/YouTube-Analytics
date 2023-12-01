package views;

import app.TrendingUseCaseFactory;
import data_access.FileUserDataAccessObject;
import data_access.YouTubeDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginPresenter;
import interface_adapter.trending.TrendingCategorySelectViewModel;
import interface_adapter.trending.TrendingController;
import interface_adapter.trending.TrendingDataViewModel;
import interface_adapter.trending.TrendingPresenter;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.trending.TrendingInputBoundary;
import use_case.trending.TrendingInteractor;
import use_case.trending.TrendingOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static views.InstructionView.openInstructionPanel;

public class HomeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "home";
    private final HomeViewModel homeViewModel;

    private final TrendingCategorySelectViewModel trendingCategorySelectViewModel;
    private final ViewManagerModel viewManagerModel;

    final JButton searchVideo;
    final JButton searchChannel;
    final JButton trending;
    final JButton compare;
    final JButton history;
    final JButton instruction;



    public HomeView(HomeViewModel homeViewModel, TrendingCategorySelectViewModel trendingCategorySelectViewModel, ViewManagerModel viewManagerModel) {
        this.homeViewModel = homeViewModel;
        this.trendingCategorySelectViewModel = trendingCategorySelectViewModel;
        this.viewManagerModel = viewManagerModel;
        homeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(HomeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsTop = new JPanel();
        searchVideo = new JButton(HomeViewModel.SEARCHVIDEO_BUTTON_LABEL);
        searchVideo.setPreferredSize(new Dimension(200, 100));
        buttonsTop.add(searchVideo);
        searchChannel = new JButton(HomeViewModel.SEARCHCHANNEL_BUTTON_LABEL);
        searchChannel.setPreferredSize(new Dimension(200, 100));
        buttonsTop.add(searchChannel);
        trending = new JButton(HomeViewModel.TRENDING_BUTTON_LABEL);
        trending.setPreferredSize(new Dimension(200, 100));
        buttonsTop.add(trending);

        JPanel buttonsBottom = new JPanel();
        compare = new JButton(HomeViewModel.COMPARE_BUTTON_LABEL);
        compare.setPreferredSize(new Dimension(200, 100));
        buttonsBottom.add(compare);
        history = new JButton(HomeViewModel.HISTORY_BUTTON_LABEL);
        history.setPreferredSize(new Dimension(200, 100));
        buttonsBottom.add(history);
        instruction = new JButton(HomeViewModel.INSTRUCTION_BUTTON_LABEL);
        instruction.setPreferredSize(new Dimension(200, 100));
        buttonsBottom.add(instruction);

        searchVideo.addActionListener(
//                 This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(searchVideo)) {
                            new VideoSearchView();
                        }
                    }
                }
        );

        searchChannel.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(searchChannel)) {
                            new ChannelSearchView();
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
//                            JFrame trendingFrame = new JFrame("Trending Category Select");
//
//                            TrendingDataViewModel trendingDataViewModel = new TrendingDataViewModel();
//                            YouTubeDataAccess trendingDataAccess = new YouTubeDataAccess();
//                            TrendingCategorySelectView trendingCategorySelectView = TrendingUseCaseFactory.create(viewManagerModel, trendingCategorySelectViewModel, trendingDataViewModel, trendingDataAccess);
//                            trendingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                            trendingFrame.getContentPane().add(trendingCategorySelectView);
//                            trendingFrame.pack();
//                            trendingFrame.setLocationRelativeTo(null); // Center the frame on the screen
//                            trendingFrame.setVisible(true);

                        }
                    }
                }
        );

        compare.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(compare)) {
                            new CompareView();
                        }
                    }
                }
        );

        history.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(history)) {
                            new HistoryView();
                        }
                    }
                }
        );

        instruction.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(instruction)) {
                            openInstructionPanel();
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
        this.add(Box.createRigidArea(new Dimension(1200, 200)));
    }
    @Override
    public void actionPerformed(ActionEvent e)  {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
