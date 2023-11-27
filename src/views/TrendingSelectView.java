package views;

import interface_adapter.trending.TrendingSelectViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TrendingSelectView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "trending select";
    private final TrendingSelectViewModel trendingSelectViewModel;
    final JButton general;
    final JButton category;

    public TrendingSelectView(TrendingSelectViewModel trendingSelectViewModel) {
        this.trendingSelectViewModel = trendingSelectViewModel;
        trendingSelectViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(TrendingSelectViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        general = new JButton(TrendingSelectViewModel.GENERAL_BUTTON_LABEL);
        buttons.add(general);
        category = new JButton(TrendingSelectViewModel.CATEGORY_BUTTON_LABEL);
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
                            TrendingCategorySelectView categorySelectView = new TrendingCategorySelectView();
                            JFrame frame = new JFrame("Select Category");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.getContentPane().add(categorySelectView);
                            frame.pack();
                            frame.setLocationRelativeTo(null); // Center the frame
                            frame.setVisible(true);

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
