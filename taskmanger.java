package Task_Manger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class taskmanger {

    private static JPanel task_panel;

    public static void main(String[] args) {

        // Create the main window frame for the project
        JFrame gui_frame = new JFrame("😊 Task Manager 😊");
        gui_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui_frame.setSize(500, 500);
        gui_frame.setLayout(null);

        // Create a panel to hold tasks
        task_panel = new JPanel();
        task_panel.setLayout(new BoxLayout(task_panel, BoxLayout.Y_AXIS));

        // Create a scrollable view for the task panel
        JScrollPane scroll = new JScrollPane(task_panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(10, 10, 460, 400);

        // Create an Add Task button and link it to the addnewTask() method
        JButton add_button = new JButton("Add Task");
        add_button.setBounds(120, 420, 120, 30);
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addnewTask();
            }
        });

        // Create a Clear All button and link it to clearAllTask() method
        JButton clear_button = new JButton("Clear All");
        clear_button.setBounds(250, 420, 120, 30);
        clear_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllTask();
            }
        });

        // Add components to the main frame
        gui_frame.add(scroll);
        gui_frame.add(add_button);
        gui_frame.add(clear_button);

        // Set frame visibility and make it non-resizable
        gui_frame.setVisible(true);
        gui_frame.setResizable(false);
    }

    private static void addnewTask() {
        // Create a dialog for adding a new task
        Addtask addtask = new Addtask();
        int result = JOptionPane.showConfirmDialog(null, addtask.getPanel(), "Create New Task", JOptionPane.OK_CANCEL_OPTION);

        // If the user clicks OK, add the task to the task panel
        if (result == JOptionPane.OK_OPTION) {
            String task_text = addtask.getTaskTaskField().getText();
            if (!task_text.isEmpty()) {
                Task new_task = new Task(task_text, task_panel);
                task_panel.add(new_task.getTaskPanel());
                task_panel.revalidate();
                task_panel.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Task cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void clearAllTask() {
        // Clear all tasks from the task panel
        task_panel.removeAll();
        task_panel.revalidate();
        task_panel.repaint();
    }
}
