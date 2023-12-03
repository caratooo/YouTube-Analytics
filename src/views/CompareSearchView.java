package views;

import interface_adapter.compare_search.CompareSearchController;
import interface_adapter.compare_search.CompareSearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CompareSearchView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "compare";

    private final CompareSearchViewModel compareSearchViewModel;

    private final JTextField videoInputField = new JTextField(15);

    private final CompareSearchController compareSearchController;

    private final JButton search;

    private final JButton back;

    public CompareSearchView(CompareSearchViewModel compareSearchViewModel, CompareSearchController compareSearchController) {
        this.compareSearchViewModel = compareSearchViewModel;
        this.compareSearchController = compareSearchController;
        compareSearchViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(CompareSearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel videoIdInfoOne = new LabelTextPanel(
                new JLabel(CompareSearchViewModel.VIDEO_ID_LABEL), videoInputField);
        LabelTextPanel videoIdInfoTwo = new LabelTextPanel(
                new JLabel(CompareSearchViewModel.VIDEO_ID_LABEL), videoInputField);

        JPanel buttons = new JPanel();

        search = new JButton(CompareSearchViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(search);

        back = new JButton(CompareSearchViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}