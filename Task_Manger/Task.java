package Task_Manger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Task {
    private JPanel taskPanel;
    private JCheckBox checkBox;
    private JLabel task_label;
    private JPanel parent_Panel;

    public Task(String taskText, JPanel parent_Panel) {
        this.parent_Panel = parent_Panel;
        taskPanel = new JPanel();
        taskPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create a checkbox and label for the task
        checkBox = new JCheckBox();
        task_label = new JLabel(taskText);

        // Add action listener for the checkbox
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_task_status();
                move_completed_task_end();
            }
        });

        // Add components to the task panel
        taskPanel.add(checkBox);
        taskPanel.add(task_label);

        // Add a right-click menu for delete and rename
        JPopupMenu pop_up = new JPopupMenu();

        pop_up.add("Delete").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_task();
            }
        });

        pop_up.add("Rename").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rename_task();
            }
        });

        taskPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    pop_up.show(taskPanel, e.getX(), e.getY());
                }
            }
        });
    }

    private void update_task_status() {
        if (checkBox.isSelected()) {
            task_label.setForeground(Color.BLUE);
            task_label.setFont(new Font(task_label.getFont().getName(), Font.ITALIC, task_label.getFont().getSize()));
        } else {
            task_label.setForeground(Color.RED);
            task_label.setFont(new Font(task_label.getFont().getName(), Font.BOLD, task_label.getFont().getSize()));
        }
    }

    private void move_completed_task_end() {
        if (checkBox.isSelected()) {
            parent_Panel.remove(taskPanel);
            parent_Panel.add(taskPanel);
            parent_Panel.revalidate();
            parent_Panel.repaint();
        }
    }

    private void rename_task() {
        String new_task_text = JOptionPane.showInputDialog(null, "New task", task_label.getText());
        if (new_task_text != null && !new_task_text.isEmpty()) {
            task_label.setText(new_task_text);
        }
    }

    private void delete_task() {
        parent_Panel.remove(taskPanel);
        parent_Panel.revalidate();
        parent_Panel.repaint();
    }

    public JPanel getTaskPanel() {
        return taskPanel;
    }
}

