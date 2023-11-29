package views;

import interface_adapter.history.HistoryController;
import interface_adapter.history.HistoryViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;

import static java.util.Map.entry;

public class HistoryView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "history";
    private final HistoryViewModel historyViewModel;
    private final HistoryController historyController;

    private final JButton home;

    // 1 is the most recent, 5 is the fifth most recent, rest of the history is ignored
    private JLabel history1 = new JLabel();
    private JPanel history1_desc = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));
    private JLabel history2 = new JLabel();
    private JPanel history2_desc = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));
    private JLabel history3 = new JLabel();
    private JPanel history3_desc = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));
    private JLabel history4 = new JLabel();
    private JPanel history4_desc = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));
    private JLabel history5 = new JLabel();
    private JPanel history5_desc = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));

    private Map<Integer, Object[]> historyPanels = Map.ofEntries(
            entry(1, new Object[]{history1, history1_desc}),
            entry(2, new Object[]{history2, history2_desc}),
            entry(3, new Object[]{history3, history3_desc}),
            entry(4, new Object[]{history4, history4_desc}),
            entry(5, new Object[]{history5, history5_desc})
    );
//    private final List<Object> historyPanels = Arrays.asList(history1, history1_desc, history2, history2_desc, history3,
//        history3_desc,  history4, history4_desc, history5, history5_desc);

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
        history.add(history1);
        history.add(history1_desc);
        history.add(history2);
        history.add(history2_desc);
        history.add(history3);
        history.add(history3_desc);
        history.add(history4);
        history.add(history4_desc);
        history.add(history5);
        history.add(history5_desc);

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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
        this.add(history);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        List<String> userHistory = (List<String>) historyViewModel.getState().getUserHistory();

    }
}
