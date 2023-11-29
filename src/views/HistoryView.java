package views;

import interface_adapter.history.HistoryController;
import interface_adapter.history.HistoryViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HistoryView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "history";
    private final HistoryViewModel historyViewModel;
    private final HistoryController historyController;

    private final JButton home;

    public HistoryView(HistoryController historyController, HistoryViewModel historyViewModel) {
        this.historyController = historyController;
        this.historyViewModel = historyViewModel;
        historyViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(HistoryViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        home = new JButton(HistoryViewModel.HOME_BUTTON_LABEL);
        buttons.add(home);

        JPanel history = new JPanel();

        home.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                        if (e.getSource().equals(home)) {
//
//                        }
                    }
                }
        );
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
