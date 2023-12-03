package views;

import interface_adapter.history.HistoryController;
import interface_adapter.history.HistoryViewModel;
import views.sort_algorithms.SortCompare;
import views.sort_algorithms.SortSearchQuery;
import views.sort_algorithms.SortVideoSearch;

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
    private final JButton view1 = new JButton("View");
    private final JButton view2 = new JButton("View");
    private final JButton view3 = new JButton("View");
    private final JButton view4 = new JButton("View");
    private final JButton view5 = new JButton("View");
    private final JButton[] buttons = new JButton[]{
            view1, view2, view3, view4, view5
    };
    private Map<Integer, String> buttonMap = Map.ofEntries(
            Map.entry(1, ""),
            Map.entry(2, ""),
            Map.entry(3, ""),
            Map.entry(4, ""),
            Map.entry(5, "")
    );
    private JPanel history = new JPanel();

    public HistoryView(HistoryController historyController, HistoryViewModel historyViewModel) {
        this.historyController = historyController;
        this.historyViewModel = historyViewModel;
        historyViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(HistoryViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        home = new JButton(HistoryViewModel.HOME_BUTTON_LABEL);
        buttons.add(home);

        history.setLayout(new BoxLayout(history, BoxLayout.Y_AXIS));

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
        List<String> userHistory = historyViewModel.getState().getUserHistory();

        for (int i = 0; i < 5; i++) {
            String[] query = userHistory.get(userHistory.size() - i - 1).split(",", 2);
            String queryType = query[0];
            String data = query[1];
            SortSearchQuery sorter = sorter(queryType);

            JPanel queryPanel = sorter.sort(data, i + 1);
            history.add(queryPanel);
        }
    }

    private SortSearchQuery sorter(String queryType) {
        if (queryType.equals("compare")) {
            return new SortCompare();
        } else {
            return new SortVideoSearch();
        }
    }
}
