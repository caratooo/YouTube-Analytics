package views;

import interface_adapter.video_search.VideoSearchController;
import interface_adapter.video_search.VideoSearchPresenter;
import interface_adapter.video_search.VideoSearchState;
import interface_adapter.video_search.VideoSearchViewModel;

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

public class VideoSearchView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "video search";

    private final VideoSearchViewModel videoSearchViewModel;

    private final JTextField videoInputField = new JTextField(15);

    private final VideoSearchController videoSearchController;

    private final JButton search;


    public VideoSearchView(VideoSearchController controller, VideoSearchViewModel videoSearchViewModel) {

        this.videoSearchViewModel = videoSearchViewModel;
        this.videoSearchController = controller;
        videoSearchViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(VideoSearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel videoIdInfo = new LabelTextPanel(
                new JLabel(VideoSearchViewModel.VIDEO_ID_LABEL), videoInputField);

        JPanel buttons = new JPanel();
        search = new JButton(VideoSearchViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(search);

        search.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(search)) {
                            VideoSearchState currState = videoSearchViewModel.getState();

                            try {
                                videoSearchController.execute(currState.getVideoId());
                            } catch (GeneralSecurityException ex) {
                                throw new RuntimeException(ex);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );


        videoInputField.addKeyListener(

                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        VideoSearchState currState = videoSearchViewModel.getState();
                        String text = videoInputField.getText() + e.getKeyChar();
                        currState.setVideoId(text);
                        videoSearchViewModel.setState(currState);
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
        this.add(videoIdInfo);
        this.add(buttons);

    }


    public void actionPerformed(ActionEvent e) {
        // TODO check plz
    }


    public void propertyChange(PropertyChangeEvent evt) {
        VideoSearchState state = (VideoSearchState) evt.getNewValue();
        // TODO check if need to add errors
        if (state.getVideoIdError() != null) {
            JOptionPane.showMessageDialog(this, state.getVideoIdError());
        }
    }
}
