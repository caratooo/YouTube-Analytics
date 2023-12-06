package views;

import interface_adapter.ViewManagerModel;
import interface_adapter.compare_search.CompareSearchController;
import interface_adapter.compare_search.CompareSearchState;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.home.HomeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class CompareSearchView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "compare";

    private final CompareSearchViewModel compareSearchViewModel;

    private final JTextField videoInputFieldOne = new JTextField(15);
    private final JTextField videoInputFieldTwo = new JTextField(15);

    private final CompareSearchController compareSearchController;

    private final JButton search;

    private final JButton back;

    public CompareSearchView(CompareSearchViewModel compareSearchViewModel, CompareSearchController compareSearchController, HomeViewModel homeViewModel, ViewManagerModel viewManagerModel) {
        this.compareSearchViewModel = compareSearchViewModel;
        this.compareSearchController = compareSearchController;
        compareSearchViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(CompareSearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel videoIdInfoOne = new LabelTextPanel(
                new JLabel(CompareSearchViewModel.VIDEO_ID_LABEL), videoInputFieldOne);
        LabelTextPanel videoIdInfoTwo = new LabelTextPanel(
                new JLabel(CompareSearchViewModel.VIDEO_ID_LABEL), videoInputFieldTwo);

        JPanel buttons = new JPanel();

        search = new JButton(CompareSearchViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(search);

        back = new JButton(CompareSearchViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(search)) {
                    CompareSearchState currState = compareSearchViewModel.getState();

                    try {
                        compareSearchController.execute(currState.getVideoOneId(),currState.getVideoTwoId());
                    } catch (GeneralSecurityException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(back)) {
                    viewManagerModel.setActiveView(homeViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
            }
        });
        videoInputFieldOne.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CompareSearchState currState = compareSearchViewModel.getState();
                        String text = videoInputFieldOne.getText() + e.getKeyChar();
                        currState.setVideoOneId(text);
                        compareSearchViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        videoInputFieldTwo.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CompareSearchState currState = compareSearchViewModel.getState();
                        String text = videoInputFieldTwo.getText() + e.getKeyChar();
                        currState.setVideoTwoId(text);
                        compareSearchViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(videoIdInfoOne);
        this.add(videoIdInfoTwo);
        this.add(buttons);


    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CompareSearchState state = (CompareSearchState) evt.getNewValue();
        if (state.getVideoIdError() != null) {
            JOptionPane.showMessageDialog(this, state.getVideoIdError());
        }
    }
}
