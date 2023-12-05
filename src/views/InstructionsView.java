package views;

import javax.swing.*;
import java.awt.*;

public class InstructionsView extends JPanel{
    public static void openInstructionsPanel() {
        // Create a new JFrame for the search video view
        JFrame instructionsFrame = new JFrame("Instructions");
        instructionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        instructionsFrame.setSize(500, 250);

        // Create a panel for the search video view
        JPanel instructionsPanel = new JPanel();
        instructionsPanel.setLayout(new BoxLayout(instructionsPanel, BoxLayout.Y_AXIS));

        // Sample instructions
        String[] instructions = {
                "   Search Video: Type in Youtube Video ID in the search bar to see its stats.",
                "   Trending: Search top three most popular videos in general or by categories.",
                "   Compare: Type in two Video ID and compare statistics between two videos.",
                "   History: Show 5 most recent search history in Search Video and/or Compare."
        };

        // Add instructions to the panel
        for (String instruction : instructions) {
            JLabel instructionLabel = new JLabel(instruction);
            instructionsPanel.add(instructionLabel);

            instructionsPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        }
        // Set the search panel as the content pane of the search frame
        instructionsFrame.setContentPane(instructionsPanel);

        // Display the search frame
        instructionsFrame.setVisible(true);
    }

}
