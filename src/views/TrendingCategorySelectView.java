package views;

import interface_adapter.trending.TrendingCategorySelectState;
import interface_adapter.trending.TrendingCategorySelectViewModel;
import interface_adapter.trending.TrendingController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TrendingCategorySelectView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "trending select";
    private final TrendingController controller;
    private final TrendingCategorySelectViewModel trendingCategorySelectViewModel;

    private JComboBox<String> categoryComboBox;
    private JButton selectButton;

    public TrendingCategorySelectView(TrendingController controller, TrendingCategorySelectViewModel trendingCategorySelectViewModel) {

        this.controller = controller;
        this.trendingCategorySelectViewModel = trendingCategorySelectViewModel;
        this.trendingCategorySelectViewModel.addPropertyChangeListener(this);

        // initialize Components
        categoryComboBox = new JComboBox<>(new String[]{"General", "Music", "Animals","Sports", "Gaming", "News", "Movies", "Animation"});
        selectButton = new JButton("Select");

        // layout Components
        setLayout(new BorderLayout());
        add(categoryComboBox, BorderLayout.NORTH);
        add(selectButton, BorderLayout.SOUTH);

        // add Event Listeners
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = (String) categoryComboBox.getSelectedItem();
                TrendingCategorySelectState currState = trendingCategorySelectViewModel.getState();
                handleCategorySelection(selectedCategory);
            }
        });


    }

//    youtube category id:
//            general
//            10 - Music
//            15 - Animals
//            17 - Sports
//            20 - Gaming
//            25 - News
//            30 - Movies
//            31 - Animation


    private void handleCategorySelection(String category) {
        System.out.println("Selected category: " + category);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
