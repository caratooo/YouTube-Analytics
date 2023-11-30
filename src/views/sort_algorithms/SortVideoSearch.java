package views.sort_algorithms;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SortVideoSearch implements SortSearchQuery {
    private static final List<String> statLabels = Arrays.asList("title", "2", "3", "4", "5", "6", "7");
    @Override
    public JPanel sort(String data, Integer number) {
        JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel pLabel = new JPanel();
        JLabel label = new JLabel(String.);

        JPanel left = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centre = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel right = new JPanel(new FlowLayout(FlowLayout.CENTER));

        List<String> stats = List.of(data.split(","));

        for (int i = 0; i < 7; i++) {

        }

        return main;
    }
}
