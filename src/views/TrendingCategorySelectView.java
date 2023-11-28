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
                String categoryInt = handleCategorySelection(selectedCategory);
                System.out.println(categoryInt);
                System.out.println(categoryInt == null);
                controller.execute(categoryInt);
            }
        });


    }



    private String handleCategorySelection(String selectedCategory) {
        System.out.println("Selected category: " + selectedCategory);
    //    youtube category:
    //            General
    //            10 - Music
    //            15 - Animals
    //            17 - Sports
    //            20 - Gaming
    //            25 - News
    //            30 - Movies
    //            31 - Animation

        if(selectedCategory.equals("General")){
            return "0";
        }
        else if(selectedCategory.equals("Music")){
            return "10";
        }
        else if(selectedCategory.equals("Animals")){
            return "15";
        }
        else if(selectedCategory.equals("Sports")){
            return "17";
        }
        else if(selectedCategory.equals("Gaming")){
            return "20";
        }
        else if(selectedCategory.equals("News")){
            return "25";
        }
        else if(selectedCategory.equals("Movies")){
            return "30";
        }
        else {
            return "31";
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
