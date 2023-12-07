package views;

import interface_adapter.SearchController;
import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryController;
import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.home.HomeViewModel;
import views.sort_algorithms.SortCompare;
import views.sort_algorithms.SortEmpty;
import views.sort_algorithms.SortPanelStrategy;
import views.sort_algorithms.SortVideoSearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.List;

public class HistoryView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "history";
    private final HistoryViewModel historyViewModel;
    private final HistoryController historyController;
    private PanelMaker maker = new PanelMaker();

    private final JButton home;
    private final JButton view1 = new JButton("View");
    private final JButton view2 = new JButton("View");
    private final JButton view3 = new JButton("View");
    private final JButton view4 = new JButton("View");
    private final JButton view5 = new JButton("View");
    private final JButton[] buttonList = new JButton[]{view1, view2, view3, view4, view5};
    private JPanel history = new JPanel();
    private JPanel history1 = new JPanel();
    private JPanel history2 = new JPanel();
    private JPanel history3 = new JPanel();
    private JPanel history4 = new JPanel();
    private JPanel history5 = new JPanel();
    private final JPanel[] historyPanels = new JPanel[]{history1, history2, history3, history4, history5};

    private Map<String, SearchController> searchControllerMap = new HashMap<>();
    private final Map<String, SortPanelStrategy> sorters = new HashMap<>(Map.ofEntries(
            Map.entry("empty", new SortEmpty()),
            Map.entry("compare", new SortCompare()),
            Map.entry("videoSearch", new SortVideoSearch())
    ));

    public HistoryView(HistoryController historyController, HistoryViewModel historyViewModel, SearchController compareController, SearchController videoSearchController, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {
        this.historyController = historyController;
        this.historyViewModel = historyViewModel;
        historyViewModel.addPropertyChangeListener(this);

        searchControllerMap.put("compare", compareController);
        searchControllerMap.put("videoSearch", videoSearchController);

        JLabel paddingTop = new JLabel(" ");
        JLabel title = new JLabel(HistoryViewModel.TITLE_LABEL);
        JLabel paddingBot = new JLabel(" ");
        paddingTop.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        paddingBot.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        home = new JButton(HistoryViewModel.HOME_BUTTON_LABEL);
        buttons.add(home);

        home.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(home)) {
                            viewManagerModel.setActiveView(homeViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(paddingTop);
        this.add(title);
        this.add(paddingBot);

        history.setLayout(new BoxLayout(history, BoxLayout.Y_AXIS));
        for (int i = 0; i < 5; i++) {
            history.add(historyPanels[i]);
            historyPanels[i].setLayout(new BoxLayout(historyPanels[i], BoxLayout.Y_AXIS));
        }

        this.add(history);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        HistoryState state = (HistoryState) evt.getNewValue();
        if (state.getUserHistoryError() != null) {
            JOptionPane.showMessageDialog(this, state.getUserHistoryError());
            state.setUserHistoryError(null);
        } else {
            List<String> userHistory = historyViewModel.getState().getUserHistory();

            for (int i = 0; i < 5; i++) {
                try {
                    userHistory.get(userHistory.size() - i - 1);
                } catch (IndexOutOfBoundsException ignored) {
                    for (int i2 = historyPanels[i].getComponentCount() - 1; i2 > -1; i2--) {
                        historyPanels[i].remove(i2);
                    }

                    maker.setSorter(sorters.get("empty"));
                    JPanel emptyPanel = maker.makePanel(null, i + 1, null);
                    historyPanels[i].add(emptyPanel);

                    continue;
                }

                // get the most recent queries which are at the back of the list
                String[] query = userHistory.get(userHistory.size() - i - 1).split(",", 2);
                String queryType = query[0];
                String data = query[1];

                JButton button = buttonList[i];

                for (ActionListener listener : button.getActionListeners()) {
                    button.removeActionListener(listener);
                }

                maker.setSorter(sorters.get(queryType));
                JPanel queryPanel = maker.makePanel(data, i + 1, button);

                button.addActionListener(
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (e.getSource().equals(button)) {
                                    try {
                                        System.out.println(queryType);
//                                        System.out.println(data);
                                        searchControllerMap.get(queryType).callExecute(data, historyViewModel.getState().getUsername());
                                    } catch (GeneralSecurityException ex) {
                                        throw new RuntimeException(ex);
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                            }
                        }
                );

                if (historyPanels[i].getComponentCount() >= 1) {
                    historyPanels[i].remove(historyPanels[i].getComponentCount() - 1);
                }

                historyPanels[i].add(queryPanel);
            }
        }
    }
}
