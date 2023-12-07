package views.sort_algorithms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SortCompare implements SortPanelStrategy {
    private static final Color grey = new Color(227, 227, 227);
    private static final List<String> statLabels = Arrays.asList(
            "Video ID", "Channel Name", "Title", "Description", "Date Published", "View Count", "Like Count", "Comment Count",
            "Video ID", "Channel Name", "Title", "Description", "Date Published", "View Count", "Like Count", "Comment Count"
    );

    /**
     * Returns a panel for a compare search query
     * @param data the string that contains the stats from a compare search query
     * @param number the panel number (1 < number < 5)
     * @param button the button to used to call CompareSearchController
     * @return a panel for a compare search query
     */
    @Override
    public JPanel sort(String data, Integer number, JButton button) {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.LINE_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel mainStats = new JPanel();
        mainStats.setLayout(new BoxLayout(mainStats, BoxLayout.Y_AXIS));

        List<String> stats = List.of(data.split(","));
        List<String> video1Stats = stats.subList(0, stats.size() / 2);
        List<String> video2Stats = stats.subList(stats.size() / 2, stats.size());

        JPanel panelLabel = new JPanel();
        JLabel label = new JLabel("Compare");
        panelLabel.add(label);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 40));
        buttonPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel videos = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
        JPanel video1 = sort_video(video1Stats, 1, number);
        JPanel video2 = sort_video(video2Stats, 2, number);
        videos.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (number % 2 != 0) {
            panelLabel.setBackground(grey);
            videos.setBackground(grey);
            mainStats.setBackground(grey);
            buttonPanel.setBackground(grey);
            main.setBackground(grey);
        }

        videos.add(video1);
        videos.add(video2);
        mainStats.add(panelLabel);
        mainStats.add(videos);
        main.add(mainStats);
        main.add(buttonPanel);

        return main;
    }

    private JPanel sort_video(List<String> data, Integer num_video, Integer number) {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JLabel mainLabel = new JLabel(String.format("Video %s (%s)", num_video, data.get(0)));
        mainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(mainLabel);

        JPanel video = new JPanel();
        video.setMaximumSize(new Dimension(600, 200));
        video.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        video.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

        for (int i = 1; i < data.size(); i++) {
            String stat = data.get(i);
            JLabel newStat;

            if (stat.length() > 50) {
                newStat = new JLabel(String.format("%s: %s...", statLabels.get(i), stat.substring(0, 47)));
            } else {
                newStat = new JLabel(String.format("%s: %s", statLabels.get(i), stat));
            }

            newStat.setMaximumSize(new Dimension(400, 100));
            newStat.setBorder(new EmptyBorder(1,0,1,0));
            if (i == 3) {
                continue;
            } else {
                right.add(newStat);
            }
        }
        right.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (number % 2 != 0) {
            main.setBackground(grey);
            video.setBackground(grey);
            right.setBackground(grey);
        }

        video.add(right);
        main.add(video);

        return main;
    }
}
