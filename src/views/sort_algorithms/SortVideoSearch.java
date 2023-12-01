package views.sort_algorithms;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SortVideoSearch implements SortSearchQuery {

    private static final Color grey = new Color(227, 227, 227);
    private static final FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
    private static final List<String> statLabels = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8");

    @Override
    public JPanel sort(String data, Integer number) {
        JPanel main = new JPanel(flowlayout);

        List<String> stats = List.of(data.split(","));

        JPanel pLabel = new JPanel();
        JLabel label = new JLabel(String.format("Search %s: Video (%s)", number, stats.get(0)));
        pLabel.add(label);

        JPanel left = new JPanel(flowlayout);
        JPanel centre = new JPanel(flowlayout);
        JPanel right = new JPanel(flowlayout);

        for (int i = 0; i < 7; i++) {
            JLabel newStat = new JLabel(String.format("%s: %s", statLabels.get(i), stats.get(i)));
            if (i < 3) {
                left.add(newStat);
            } else if (i < 6) {
                centre.add(newStat);
            } else {
                right.add(newStat);
            }
        }

        if (number % 2 != 0) {
            pLabel.setBackground(grey);
            left.setBackground(grey);
            centre.setBackground(grey);
            right.setBackground(grey);
            main.setBackground(grey);
        }

        main.add(pLabel);
        main.add(left);
        main.add(centre);
        main.add(right);

        return main;
    }
}
