package Task_Manger;

import javax.swing.*;
import java.awt.*;

public class Addtask {
    private JPanel panel;
    private JTextField taskTaskField;
    private JButton addButton;

    public Addtask() {
        // Initialize the Add Task panel
        panel = new JPanel();
        panel.setLayout(null);

        // Label for the task input
        JLabel label = new JLabel("Task: ");
        label.setBounds(10, 10, 50, 20);

        // Text field for task input
        taskTaskField = new JTextField();
        taskTaskField.setBounds(70, 10, 200, 20);

        // Add button with an icon (optional)
        addButton = new JButton("Add");
        addButton.setBounds(10, 40, 120, 30);

        // Add components to the panel
        panel.add(label);
        panel.add(taskTaskField);
        panel.add(addButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTaskTaskField() {
        return taskTaskField;
    }

    public JButton getAddButton() {
        return addButton;
    }
}
