// Package declaration
package com.osteofelidae.nancy_procrastination_program;

// Import required libraries
import javafx.application.Application;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// Custom scene for task details
public class TaskDetailsScene extends Scene {

    // Instance variables
    private Pane pane;
    private Task task;
    private String taskTitle;
    private String taskDescription;
    private CustomDate taskDeadline;
    private int taskDifficulty;
    private Object[] scenes;

    // Constructor without task
    public TaskDetailsScene (Pane pane, int v, int v1) {

        // Super constructor
        super(pane, v, v1);

        // Set instance variables
        this.pane = pane;

    }

    // Constructor without task
    public TaskDetailsScene (Pane pane, int v, int v1, Object[] scenes) {

        // Super constructor
        super(pane, v, v1);

        // Set instance variables
        this.pane = pane;
        this.scenes = scenes;

    }

    // Constructor with task
    public TaskDetailsScene (Pane pane, int v, int v1, Task task, Object[] scenes) {

        // Super constructor
        super(pane, v, v1);

        // Set instance variables
        this.pane = pane;
        this.scenes = scenes;
        setTask(task);

    }

    // Set task
    public void setTask (Task task) {

        // Set instance variable
        this.task = task;

        // Set task
        this.setTask(this.task.taskTitle, this.task.taskDescription, this.task.taskDeadline, this.task.taskDifficulty);

    }

    // Set task with task details
    public void setTask (String taskTitle, String taskDescription, CustomDate taskDeadline, int taskDifficulty) {

        // Set instance variables
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskDeadline = taskDeadline;
        this.taskDifficulty = taskDifficulty;

        // Reset pane
        this.pane.getChildren().clear();

        // Create display objects

        // Title
        Text title = new Text();
        title.setText(this.taskTitle);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, CONSTANTS.DETAILS_TITLE_TEXT_SIZE));
        title.setLayoutX(CONSTANTS.DETAILS_X_OFFSET);
        title.setLayoutY(CONSTANTS.DETAILS_TITLE_Y_OFFSET);
        this.pane.getChildren().add(title);
        // TODO text color

        // Description
        Text description = new Text();
        description.setText(this.taskDescription);
        description.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.REGULAR, CONSTANTS.DETAILS_CONTENT_TEXT_SIZE));
        description.setLayoutX(CONSTANTS.DETAILS_X_OFFSET);
        description.setLayoutY(CONSTANTS.DETAILS_DESCRIPTION_Y_OFFSET);
        this.pane.getChildren().add(description);

        // Date
        Text date = new Text();
        date.setText("Due: " + this.taskDeadline);
        date.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.REGULAR, CONSTANTS.DETAILS_CONTENT_TEXT_SIZE));
        date.setLayoutX(CONSTANTS.DETAILS_X_OFFSET);
        date.setLayoutY(CONSTANTS.DETAILS_DEADLINE_Y_OFFSET);
        this.pane.getChildren().add(date);

        // Difficulty
        Text difficulty = new Text();
        difficulty.setText("Difficulty:    " + this.taskDifficulty);
        difficulty.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.ITALIC, CONSTANTS.DETAILS_CONTENT_TEXT_SIZE));
        difficulty.setLayoutX(CONSTANTS.DETAILS_X_OFFSET);
        difficulty.setLayoutY(CONSTANTS.DETAILS_DIFFICULTY_Y_OFFSET);
        this.pane.getChildren().add(difficulty);

        // Close button
        Button closeButton = new Button("Back");
        // Setup button appearance
        closeButton.setStyle("-fx-background-color:" + CONSTANTS.BUTTON_COLOR + ";-fx-border-color:" + CONSTANTS.BUTTON_BORDER_COLOR + ";-fx-text-fill:" + CONSTANTS.BUTTON_TEXT_COLOR + ";-fx-alignment: center-left;");
        closeButton.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.ITALIC, CONSTANTS.DETAILS_CONTENT_TEXT_SIZE));
        // Setup button size
        closeButton.setMinSize(CONSTANTS.DETAILS_CLOSEBUTTON_WIDTH, CONSTANTS.DETAILS_CLOSEBUTTON_HEIGHT);
        closeButton.setPrefSize(CONSTANTS.DETAILS_CLOSEBUTTON_WIDTH, CONSTANTS.DETAILS_CLOSEBUTTON_HEIGHT);
        closeButton.setMaxSize(CONSTANTS.DETAILS_CLOSEBUTTON_WIDTH, CONSTANTS.DETAILS_CLOSEBUTTON_HEIGHT);
        // Setup button location
        closeButton.setLayoutX(CONSTANTS.DETAILS_CLOSEBUTTON_X);
        closeButton.setLayoutY(CONSTANTS.DETAILS_CLOSEBUTTON_Y);
        // Setup button command
        closeButton.setOnAction(new EventHandler<ActionEvent>() {

            // Override
            @Override

            // Handle function
            public void handle(ActionEvent actionEvent) {

                // Set scene to input scenes[1] which is tasks scene
                ((Stage)scenes[0]).setScene((Scene)scenes[1]);

            }
        });
        this.pane.getChildren().add(closeButton);

        // Edit button
        Button editButton = new Button("Edit");
        // Setup button appearance
        editButton.setStyle("-fx-background-color:" + CONSTANTS.BUTTON_COLOR + ";-fx-border-color:" + CONSTANTS.BUTTON_BORDER_COLOR + ";-fx-text-fill:" + CONSTANTS.BUTTON_TEXT_COLOR + ";-fx-alignment: center-left;");
        editButton.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.ITALIC, CONSTANTS.DETAILS_CONTENT_TEXT_SIZE));
        // Setup button size
        editButton.setMinSize(CONSTANTS.DETAILS_CLOSEBUTTON_WIDTH, CONSTANTS.DETAILS_CLOSEBUTTON_HEIGHT);
        editButton.setPrefSize(CONSTANTS.DETAILS_CLOSEBUTTON_WIDTH, CONSTANTS.DETAILS_CLOSEBUTTON_HEIGHT);
        editButton.setMaxSize(CONSTANTS.DETAILS_CLOSEBUTTON_WIDTH, CONSTANTS.DETAILS_CLOSEBUTTON_HEIGHT);
        // Setup button location
        editButton.setLayoutX(CONSTANTS.DETAILS_EDITBUTTON_X);
        editButton.setLayoutY(CONSTANTS.DETAILS_CLOSEBUTTON_Y);
        // Setup button command
        editButton.setOnAction(new EventHandler<ActionEvent>() {

            // Override
            @Override

            // Handle function
            public void handle(ActionEvent actionEvent) {

                // Set scene to input scenes[3] which is edit scene
                ((Stage)scenes[0]).setScene((Scene)scenes[3]);

            }
        });
        this.pane.getChildren().add(editButton);



    }

    public void setSceneList(Object[] scenes) {

        // Set instance variable
        this.scenes = scenes;

    }

}
