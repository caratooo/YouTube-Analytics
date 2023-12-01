package views;

import interface_adapter.compare.CompareController;
import interface_adapter.compare.CompareViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CompareInputView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "compare";

    private final CompareViewModel compareViewModel;

    private final JTextField videoInputField = new JTextField(15);

    private final CompareController compareController;

    private final JButton search;

    private final JButton back;

    public CompareInputView(CompareViewModel compareViewModel, CompareController compareController) {
        this.compareViewModel = compareViewModel;
        this.compareController = compareController;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
