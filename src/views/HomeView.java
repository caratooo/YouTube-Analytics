package views;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginViewModel;


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
    private final LoginViewModel loginViewModel;

    private final ViewManagerModel viewManagerModel;

    final JButton searchVideo;
    final JButton searchChannel;
    final JButton trending;
    final JButton compare;
    final JButton history;
    final JButton instruction;

    final JButton logout;



    public HomeView(HomeViewModel homeViewModel, LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) {
        this.homeViewModel = homeViewModel;
        this.loginViewModel = loginViewModel;
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
        compare = new JButton(HomeViewModel.COMPARE_BUTTON_LABEL);
        compare.setPreferredSize(new Dimension(200, 100));
        buttonsTop.add(compare);

        JPanel buttonsBottom = new JPanel();
        history = new JButton(HomeViewModel.HISTORY_BUTTON_LABEL);
        history.setPreferredSize(new Dimension(200, 100));
        buttonsBottom.add(history);
        instruction = new JButton(HomeViewModel.INSTRUCTION_BUTTON_LABEL);
        instruction.setPreferredSize(new Dimension(200, 100));
        buttonsBottom.add(instruction);
        logout = new JButton(HomeViewModel.LOGOUT_BUTTON_LABEL);
        logout.setPreferredSize(new Dimension(200, 100));
        buttonsBottom.add(logout);

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
        logout.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logout)) {
                            viewManagerModel.setActiveView(loginViewModel.getViewName());
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
