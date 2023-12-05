package views;

import interface_adapter.ViewManagerModel;
import interface_adapter.compare_stats.CompareStatsViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class CompareStatsView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "compare video stats";

    private final CompareStatsViewModel compareStatsViewModel;
    JLabel videoIdOne;
    JLabel channelNameOne;
    JLabel videoTitleOne;
    JLabel descriptionOne;
    JLabel videoPublishDateOne;
    JLabel viewCountOne;
    JLabel likeCountOne;
    JLabel commentCountOne;
    JLabel videoIdTwo;
    JLabel channelNameTwo;
    JLabel videoTitleTwo;
    JLabel descriptionTwo;
    JLabel videoPublishDateTwo;
    JLabel viewCountTwo;
    JLabel likeCountTwo;
    JLabel commentCountTwo;

    public CompareStatsView(CompareStatsViewModel compareStatsViewModel, HomeView homeView, ViewManagerModel viewManagerModel) {
        this.compareStatsViewModel = compareStatsViewModel;
    }

    //TODO

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
