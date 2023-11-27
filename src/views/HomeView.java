package views;

import interface_adapter.home.HomeViewModel;
import interface_adapter.trending.TrendingSelectViewModel;

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


    public HomeView(HomeViewModel homeViewModel) {
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
                            TrendingSelectViewModel trendingSelectViewModel = new TrendingSelectViewModel(/* dependencies */);
                            TrendingSelectView trendingSelectView = new TrendingSelectView(trendingSelectViewModel);

                            // Depending on your UI management, add trendingSelectView to your layout
                            // For a simple approach, you might open it in a new frame
                            JFrame frame = new JFrame("Trending");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.getContentPane().add(trendingSelectView);
                            frame.pack();
                            frame.setVisible(true);
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
        this.add(buttons);
    }


    private static void openInstructionPanel() {
        // Create a new JFrame for the search video view
        JFrame instructionFrame = new JFrame("Instructions");
        instructionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        instructionFrame.setSize(400, 300);

        // Create a panel for the search video view
        JPanel instructionPanel = new JPanel(new GridLayout(0, 1));

        // Sample instructions
        String[] instructions = {
                "Search Video: Type in Youtube Video ID in the search bar to see its stats.",
                "Search Channel: Type in Youtube Channel ID in the search bar to see its stats.",
                "Trending: Search most popular videos in general or by categories.",
                "Compare: Compare statistics between two videos.",
                "History: Show 5 most recent search history."
        };

        // Add instructions to the panel
        for (String instruction : instructions) {
            JLabel instructionLabel = new JLabel(instruction);
            instructionPanel.add(instructionLabel);
        }
        // Set the search panel as the content pane of the search frame
        instructionFrame.setContentPane(instructionPanel);

        // Display the search frame
        instructionFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
