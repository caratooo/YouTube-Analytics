package views;

import interface_adapter.home.HomeViewModel;
import interface_adapter.trending.TrendingViewModel;
import jdk.jfr.Category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TrendingSelectView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "trending select";
    private final TrendingViewModel trendingViewModel;
    final JButton general;
    final JButton category;

    public TrendingSelectView(TrendingViewModel trendingViewModel) {
        this.trendingViewModel = trendingViewModel;
        trendingViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(TrendingViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        general = new JButton(TrendingViewModel.GENERAL_BUTTON_LABEL);
        buttons.add(general);
        category = new JButton(TrendingViewModel.CATEGORY_BUTTON_LABEL);
        buttons.add(category);

        general.addActionListener(
//                 This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(general)) {
//                            new TrendingDataView();
                        }
                    }
                }
        );

        category.addActionListener(
//                 This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(category)) {
//                            new TrendingCategorySelectView();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
