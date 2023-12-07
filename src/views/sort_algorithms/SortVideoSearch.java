package views.sort_algorithms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SortVideoSearch implements SortPanelStrategy {

    private static final Color grey = new Color(227, 227, 227);
    private static final List<String> statLabels = Arrays.asList(
            "VideoID", "Channel Name", "Title", "Description", "Date Published", "View Count", "Like Count", "Comment Count"
    );

    /**
     * Returns a panel for a video search query
     * @param data the string that contains the stats from a video search query
     * @param number the panel number (1 < number < 5)
     * @param button the button to used to call VideoSearchController
     * @return a panel for a video search query
     */
    @Override
    public JPanel sort(String data, Integer number, JButton button) {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.LINE_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel mainStats = new JPanel();
        mainStats.setLayout(new BoxLayout(mainStats, BoxLayout.Y_AXIS));

        List<String> stats = List.of(data.split(","));

        JPanel panelLabel = new JPanel();
        JLabel label = new JLabel(String.format("Video Search (%s)", stats.get(0)));
        panelLabel.add(label);

        JPanel statPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        JPanel centre = new JPanel();
        centre.setLayout(new BoxLayout(centre, BoxLayout.Y_AXIS));
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 40));
        buttonPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int i = 1; i < 8; i++) {
            String stat = stats.get(i);
            JLabel newStat;

            if (stat.length() > 50) {
                newStat = new JLabel(String.format("%s: %s...", statLabels.get(i), stat.substring(0, 47)));
            } else {
                newStat = new JLabel(String.format("%s: %s", statLabels.get(i), stat));
            }

            newStat.setMaximumSize(new Dimension(400, 100));
            newStat.setBorder(new EmptyBorder(1,0,1,0));
            if (i == 3) {
                right.add(newStat);
            } else if (i < 5) {
                left.add(newStat);
            } else {
                centre.add(newStat);
            }
        }
        statPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (number % 2 != 0) {
            panelLabel.setBackground(grey);
            statPanel.setBackground(grey);
            left.setBackground(grey);
            centre.setBackground(grey);
            right.setBackground(grey);
            mainStats.setBackground(grey);
            buttonPanel.setBackground(grey);
            main.setBackground(grey);
        }

        statPanel.add(left);
        statPanel.add(centre);
        statPanel.add(right);
        mainStats.add(panelLabel);
        mainStats.add(statPanel);
        main.add(mainStats);
        main.add(buttonPanel);

        return main;
    }
}
