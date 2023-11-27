package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TrendingCategorySelectView extends JPanel implements ActionListener, PropertyChangeListener {
    private JComboBox<String> categoryComboBox;
    private JButton selectButton;

    public TrendingCategorySelectView() {
        initializeComponents();
        layoutComponents();
        addEventListeners();
    }

    private void initializeComponents() {
        categoryComboBox = new JComboBox<>(new String[]{"Music", "Sports", "Movies", "Gaming", "News"});
        selectButton = new JButton("Select");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(categoryComboBox, BorderLayout.NORTH);
        add(selectButton, BorderLayout.SOUTH);
    }

    private void addEventListeners() {
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = (String) categoryComboBox.getSelectedItem();
                handleCategorySelection(selectedCategory);
            }
        });
    }

    private void handleCategorySelection(String category) {
        // Implement the logic to fetch and display trending videos for the selected category
        // This might involve calling a method in a controller or a use case class
        System.out.println("Selected category: " + category);
        // For example: trendingVideosController.fetchTrendingVideos(category);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
