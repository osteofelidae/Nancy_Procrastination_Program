// Package declaration
package com.osteofelidae.nancy_procrastination_program;

// Import required modules
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// Class for displaying button
public class Task extends Button{

    // Constants
    private String BUTTON_COLOR = CONSTANTS.BUTTON_COLOR;
    private String BUTTON_BORDER_COLOR = CONSTANTS.BUTTON_BORDER_COLOR;
    private String BUTTON_TEXT_COLOR = CONSTANTS.BUTTON_TEXT_COLOR;
    private double BUTTON_WIDTH = CONSTANTS.BUTTON_WIDTH;
    private double BUTTON_HEIGHT = CONSTANTS.BUTTON_HEIGHT;



    // Instance variables
    public String taskTitle;
    public String taskDescription;
    public CustomDate taskDeadline;
    public int taskDifficulty;
    public Object[] scenes;
    public TaskDetailsScene taskDetailsScene;

    // Basic constructor
    public Task(Object[] scenes, String taskTitle) {

        // Call button constructor
        super(taskTitle);

        // Set instance variables
        this.taskTitle = taskTitle;
        this.scenes = scenes;

        // Setup button action
        setupButton();

    }

    // Constructor with all instance variables
    public Task(Object[] scenes, String taskTitle, String taskDescription, CustomDate taskDeadline, int taskDifficulty) {

        // Call button constructor
        super(taskTitle);

        // Set instance variables
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskDeadline = taskDeadline;
        this.taskDifficulty = taskDifficulty;
        this.scenes = scenes;

        // If description is empty
        if (this.taskDescription.equals("")) {

            // Set to a nice description
            this.taskDescription = "[No description]";

        }

        // Setup button action
        setupButton();

    }

    // Set task title
    public void setTaskTitle(String taskTitle) {

        // Set instance variable
        this.taskTitle = taskTitle;

        // Update button text
        updateButtonText();

    }

    // Set task description
    public void setTaskDescription(String taskDescription) {

        // Set instance variable
        this.taskDescription = taskDescription;

        // If description is empty
        if (this.taskDescription.equals("")) {

            // Set to a nice description
            this.taskDescription = "[No description]";

        }

        // Update button text
        updateButtonText();

    }

    // Set task date with date object
    public void setTaskDeadline(CustomDate taskDeadline) {

        // Set instance variable
        this.taskDeadline = taskDeadline;

        // Update button text
        updateButtonText();

    }

    // Set task date with parameters
    public void setTaskDeadline(int year, int month, int day) {

        // Try the code
        taskDeadline = new CustomDate(year, month, day);

    }

    // Set task difficulty
    public void setTaskDifficulty(int taskDifficulty) {

        // If input is in range
        if (taskDifficulty >= 1 && taskDifficulty <= 5) {

            // Set instance variable
            this.taskDifficulty = taskDifficulty;

        }
        // If not
        else {

            // Throw exception
            throw new IllegalArgumentException("Task difficulty out of range");

        }

    }

    // Set button text
    private void updateButtonText() {

        // Set button text
        this.setText(taskTitle + "\n" + taskDeadline);

    }

    // Setup button command
    private void setupButton() {

        // Setup button appearance
        this.setStyle("-fx-background-color:" + BUTTON_COLOR + ";-fx-border-color:" + BUTTON_BORDER_COLOR + ";-fx-text-fill:" + BUTTON_TEXT_COLOR + ";-fx-alignment: center-left;");

        // Setup button size
        this.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        this.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        this.setMaxSize(BUTTON_WIDTH, BUTTON_HEIGHT);

        this.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.ITALIC, CONSTANTS.DETAILS_CONTENT_TEXT_SIZE));

        // Setup button command
        this.setOnAction(new EventHandler<ActionEvent>() {

            // Override
            @Override

            // Handle function
            public void handle(ActionEvent actionEvent) {

                // Set input scenes[2] (task details scene)'s task to self
                ((TaskDetailsScene)scenes[2]).setTask(taskTitle, taskDescription, taskDeadline, taskDifficulty);

                // Set input scenes[3] (task edit scene)'s task to self
                ((TaskEditScene)scenes[3]).setTask(taskTitle, taskDescription, taskDeadline, taskDifficulty);

                // Set scene to input scenes[2] which is task details scene
                ((Stage)scenes[0]).setScene((Scene)scenes[2]);

            }
        });

    }

}
