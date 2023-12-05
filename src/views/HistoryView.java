package views;

import interface_adapter.SearchController;
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
    private final JButton[] buttons = new JButton[]{view1, view2, view3, view4, view5};
    private Map<Integer, String> buttonMap = new HashMap<>(Map.ofEntries(
            Map.entry(1, ""),
            Map.entry(2, ""),
            Map.entry(3, ""),
            Map.entry(4, ""),
            Map.entry(5, "")
    ));
    private JPanel history = new JPanel();
    private JPanel history1 = new JPanel();
    private JPanel history2 = new JPanel();
    private JPanel history3 = new JPanel();
    private JPanel history4 = new JPanel();
    private JPanel history5 = new JPanel();
    private final JPanel[] historyPanels = new JPanel[]{history1, history2, history3, history4, history5};

    private Map<String, SearchController> searchControllerMap = new HashMap<>();
    private Map<Integer, String> currentViewHistory = new HashMap<>(Map.ofEntries(
            Map.entry(1, ""),
            Map.entry(2, ""),
            Map.entry(3, ""),
            Map.entry(4, ""),
            Map.entry(5, "")
    ));

    public HistoryView(HistoryController historyController, HistoryViewModel historyViewModel, SearchController compareController, SearchController videoSearchController) {
        this.historyController = historyController;
        this.historyViewModel = historyViewModel;
        historyViewModel.addPropertyChangeListener(this);

        searchControllerMap.put("compare", compareController);
        searchControllerMap.put("videoSearch", videoSearchController);

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

        for (int i = 1; i < 6; i++) {
            history.add(historyPanels[i]);
            historyPanels[i].setLayout(new BoxLayout(historyPanels[i], BoxLayout.Y_AXIS));
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        List<String> userHistory = historyViewModel.getState().getUserHistory();

        for (int i = 0; i < 5; i++) {
            try {
                userHistory.get(userHistory.size() - i - 1);
            } catch (IndexOutOfBoundsException ignored) {
                for (int i2 = historyPanels[i].getComponentCount() - 1; i2 > -1; i2--) {
                    historyPanels[i].remove(i2);
                }
            }

            // get the most recent queries which are at the back of the list
            currentViewHistory.put(i + 1, userHistory.get(userHistory.size() - i - 1));
            String[] query = userHistory.get(userHistory.size() - i - 1).split(",", 2);
            String queryType = query[0];
            String data = query[1];
            SortSearchQuery sorter = sorter(queryType);

            JButton button = buttons[i];

            JPanel queryPanel = sorter.sort(data, i + 1, button);
            buttonMap.put(i + 1, queryType);

            button.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource().equals(button)) {

                                searchControllerMap.get(queryType).callExecute(data);
                            }
                        }
                    }
            );

            if (historyPanels[i + 1].getComponentCount() >= 1) {
                historyPanels[i + 1].remove(historyPanels[i + 1].getComponentCount() - 1);
            }

            historyPanels[i + 1].add(queryPanel);
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
