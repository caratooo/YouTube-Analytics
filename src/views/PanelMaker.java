package views;

import views.sort_algorithms.SortPanelStrategy;

import javax.swing.*;

public class PanelMaker {
    private SortPanelStrategy sorter;

    public void setSorter(SortPanelStrategy sorter) {
        this.sorter = sorter;
    }

    public JPanel makePanel(String data, Integer number, JButton button) {
        return sorter.sort(data, number, button);
    }
}
