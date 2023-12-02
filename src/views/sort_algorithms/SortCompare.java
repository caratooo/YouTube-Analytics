package views.sort_algorithms;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SortCompare implements SortSearchQuery {
    private static final Color grey = new Color(227, 227, 227);
    private static final FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
    private static final List<String> statLabels = Arrays.asList(
            "0", "1", "2", "3", "4", "5", "6", "7", "8",
            "0", "1", "2", "3", "4", "5", "6", "7", "8"
    );

    @Override
    public JPanel sort(String data, Integer number) {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        List<String> stats = List.of(data.split(","));
        List<String> video1Stats = stats.subList(0, stats.size() / 2);
        List<String> video2Stats = stats.subList(stats.size() / 2, stats.size());

        JPanel panelLabel = new JPanel();
        JLabel label = new JLabel(String.format("Search %s: Compare (%s, %s)", number, "Video 1", "Video 2"));
        panelLabel.add(label);

        JPanel videos = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JPanel video1 = sort_video(video1Stats, 1, number);
        JPanel video2 = sort_video(video2Stats, 2, number);

        if (number % 2 != 0) {
            panelLabel.setBackground(grey);
            videos.setBackground(grey);
            main.setBackground(grey);
        }

        videos.add(video1);
        videos.add(video2);
        main.add(panelLabel);
        main.add(videos);

        return main;
    }

    public JPanel sort_video(List<String> data, Integer num_video, Integer number) {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        JLabel mainLabel = new JLabel(String.format("Video %s", num_video));
        mainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(mainLabel);

        JPanel video = new JPanel();
        video.setLayout(flowlayout);

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

        for (int i = 0; i < data.size(); i++) {
            JLabel newStat = new JLabel(String.format("%s: %s", statLabels.get(i), data.get(i)));
            if (i < 4) {
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
