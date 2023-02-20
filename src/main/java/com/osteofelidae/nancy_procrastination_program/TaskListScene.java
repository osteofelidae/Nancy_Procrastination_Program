// Package declaration
package com.osteofelidae.nancy_procrastination_program;

// Import required libraries
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

// Custom scene for task list
public class TaskListScene extends Scene {

    // Instance variables
    private Task[] taskList;
    private Pane pane;

    // Constructor without tasklist
    public TaskListScene (Pane pane, int v, int v1) {

        // Super constructor
        super(pane, v, v1);

        // Set instance variables
        this.pane = pane;

    }

    // Constructor with tasklist
    public TaskListScene (Pane pane, int v, int v1, Task[] taskList) {

        // Super constructor
        super(pane, v, v1);

        // Set instance variables
        this.pane = pane;

        // Y index int
        int yIndex = CONSTANTS.LIST_Y_OFFSET;

        // Set instance taskList
        setTaskList(taskList);

    }

    // Method to set task list
    public void setTaskList(Task[] taskList) {

        // Clear pane
        this.pane.getChildren().clear();

        // Y index int
        int yIndex = CONSTANTS.LIST_Y_OFFSET;

        // Set instance taskList
        this.taskList = taskList;

        // Loop through array
        for (Task task : taskList) {

            // Set task location
            task.setLayoutX(CONSTANTS.LIST_X_OFFSET);
            task.setLayoutY(yIndex);

            // Add task to pane
            this.pane.getChildren().add(task);

            // Increment y index
            yIndex += CONSTANTS.BUTTON_HEIGHT + CONSTANTS.LIST_Y_SPACING;

        }

    }

}
