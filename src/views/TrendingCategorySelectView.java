package views;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.trending.TrendingCategorySelectState;
import interface_adapter.trending.TrendingCategorySelectViewModel;
import interface_adapter.trending.TrendingController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class TrendingCategorySelectView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "trending select";
    private final TrendingController controller;
    private final TrendingCategorySelectViewModel trendingCategorySelectViewModel;

    private JComboBox<String> categoryComboBox;
    private JButton selectButton;
    private JButton homeButton;

    public TrendingCategorySelectView(TrendingController controller, TrendingCategorySelectViewModel trendingCategorySelectViewModel, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {

        this.controller = controller;
        this.trendingCategorySelectViewModel = trendingCategorySelectViewModel;
        this.trendingCategorySelectViewModel.addPropertyChangeListener(this);

        // initialize Components
        categoryComboBox = new JComboBox<>(new String[]{"General", "Music", "Animals","Sports", "Gaming", "News", "Movies"});
        selectButton = new JButton("Select");
        homeButton = new JButton("home");

        // layout Components
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(categoryComboBox);
        JPanel boxPanel = new JPanel();
        boxPanel.add(selectButton);
        // this.add(Box.createRigidArea(new Dimension(0, 5))); // Adds some space
        boxPanel.add(homeButton);
        this.add(boxPanel);

        // add Event Listeners
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = (String) categoryComboBox.getSelectedItem();
                TrendingCategorySelectState currState = trendingCategorySelectViewModel.getState();
                String categoryInt = handleCategorySelection(selectedCategory);
                System.out.println(categoryInt);
                System.out.println(categoryInt == null);
                try {
                    controller.execute(categoryInt);
                } catch (GeneralSecurityException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                trendingCategorySelectViewModel.setState(currState);
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManagerModel.setActiveView(homeViewModel.getViewName());
                viewManagerModel.firePropertyChanged();
            }
        });


    }



    private String handleCategorySelection(String selectedCategory) {
        System.out.println("Selected category: " + selectedCategory);
    //    youtube category:
    //            General
    //            1 - Movies
    //            10 - Music
    //            15 - Animals
    //            17 - Sports
    //            20 - Gaming
    //            25 - News

        if(selectedCategory.equals("General")){
            return "0";
        }
        else if(selectedCategory.equals("Movies")){
            return "1";
        }
        else if(selectedCategory.equals("Music")){
            return "10";
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
        else {
            return "15"; // selectedCategory.equals("Animals")
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
