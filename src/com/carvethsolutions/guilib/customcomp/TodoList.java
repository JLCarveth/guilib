package com.carvethsolutions.guilib.customcomp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Composite component representing a To Do list.
 */
public class TodoList extends JPanel {

    private ArrayList<String> tasks;

    private ActionListener al;

    public TodoList(ArrayList<String> tasks) {
        this.tasks = tasks;
        populatePanel();
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    /**
     * Populates the JPanel with
     */
    private void populatePanel() {
        this.removeAll();
        this.setLayout(new GridLayout(tasks.size(), 2));
        for (String t : tasks) {
            JCheckBox cb = new JCheckBox(t);

            if (al != null) {
                cb.addActionListener(al);
            }
            this.add(cb);
        }
    }

    /**
     * Assigns an action listener to be assigned to each JCheckBox
     * @param al
     */
    public void assignActionListener(ActionListener al) {
        this.al = al;
        populatePanel();
    }
}
