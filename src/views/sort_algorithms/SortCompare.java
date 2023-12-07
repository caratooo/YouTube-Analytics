package views.sort_algorithms;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SortCompare implements SortSearchQuery {
    private static final Color grey = new Color(227, 227, 227);
    private static final FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER, 25, 5);
    private static final List<String> statLabels = Arrays.asList(
            "Video ID", "Channel Name", "Title", "Description", "Date Published", "View Count", "Like Count", "Comment Count",
            "Video ID", "Channel Name", "Title", "Description", "Date Published", "View Count", "Like Count", "Comment Count"
    );

    @Override
    public JPanel sort(String data, Integer number, JButton button) {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.LINE_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(0, 113, 0, 0));

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
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 40));
        buttonPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel videos = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 3));
        JPanel video1 = sort_video(video1Stats, 1, number);
        JPanel video2 = sort_video(video2Stats, 2, number);

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

    public JPanel sort_video(List<String> data, Integer num_video, Integer number) {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        JLabel mainLabel = new JLabel(String.format("Video %s (%s)", num_video, data.get(0)));
        mainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(mainLabel);

        JPanel video = new JPanel();
        video.setLayout(flowlayout);

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

        for (int i = 1; i < data.size(); i++) {
            JLabel newStat = new JLabel(String.format("%s: %s", statLabels.get(i), data.get(i)));
            newStat.setMaximumSize(new Dimension(200, 100));
            if (i == 3) {
                continue;
            } else if (i < 5) {
                left.add(newStat);
            } else {
                right.add(newStat);
            }
        }

        if (number % 2 != 0) {
            main.setBackground(grey);
            video.setBackground(grey);
            left.setBackground(grey);
            right.setBackground(grey);
        }

        video.add(left);
        video.add(right);
        main.add(video);

        return main;
    }
}
