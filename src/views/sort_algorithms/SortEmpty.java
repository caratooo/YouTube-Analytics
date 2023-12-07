package views.sort_algorithms;

import javax.swing.*;
import java.awt.*;

public class SortEmpty implements SortPanelStrategy {
    /**
     * Returns an empty panel to fill up space
     * @param data the string that contains the stats from a video search query
     * @param number the panel number (1 < number < 5)
     * @param button the button to used to call VideoSearchController
     * @return an empty panel
     */
    @Override
    public JPanel sort(String data, Integer number, JButton button) {
        JPanel main = new JPanel();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

        JLabel label = new JLabel("");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (number % 2 != 0) {
            panel.setBackground(new Color(227, 227, 227));
            main.setBackground(new Color(227, 227, 227));
        }

        panel.add(label);
        main.add(panel);

        return main;
    }
}
