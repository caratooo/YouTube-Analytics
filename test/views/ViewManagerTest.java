package views;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ViewManagerTest {

    @Test
    void initialize() {
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        ViewManager viewManager = new ViewManager(views, cardLayout, viewManagerModel);
    }

}