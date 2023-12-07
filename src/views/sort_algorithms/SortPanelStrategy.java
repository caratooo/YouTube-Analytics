package views.sort_algorithms;

import javax.swing.*;
import java.awt.*;

public interface SortPanelStrategy {
    JPanel sort(String data, Integer number, JButton button);
}
