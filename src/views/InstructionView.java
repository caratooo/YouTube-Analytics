package views;

import javax.swing.*;
import java.awt.*;

public class InstructionView extends JPanel{
    public static void openInstructionPanel() {
        // Create a new JFrame for the search video view
        JFrame instructionFrame = new JFrame("Instructions");
        instructionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        instructionFrame.setSize(400, 300);

        // Create a panel for the search video view
        JPanel instructionPanel = new JPanel(new GridLayout(0, 1));

        // Sample instructions
        String[] instructions = {
                "Search Video: Type in Youtube Video ID in the search bar to see its stats.",
                "Search Channel: Type in Youtube Channel ID in the search bar to see its stats.",
                "Trending: Search most popular videos in general or by categories.",
                "Compare: Compare statistics between two videos.",
                "History: Show 5 most recent search history."
        };

        // Add instructions to the panel
        for (String instruction : instructions) {
            JLabel instructionLabel = new JLabel(instruction);
            instructionPanel.add(instructionLabel);
        }
        // Set the search panel as the content pane of the search frame
        instructionFrame.setContentPane(instructionPanel);

        // Display the search frame
        instructionFrame.setVisible(true);
    }

}
