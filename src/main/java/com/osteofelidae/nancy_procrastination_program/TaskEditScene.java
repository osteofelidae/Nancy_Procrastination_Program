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
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

// Custom scene to edit a task
public class TaskEditScene extends Scene{

    // Instance variables
    private Pane pane;
    private Task task;
    private String taskTitle;
    private String taskDescription;
    private CustomDate taskDeadline;
    private int taskDifficulty;
    private Object[] scenes;

    // Constructor without task
    public TaskEditScene (Pane pane, int v, int v1) {

        // Super constructor
        super(pane, v, v1);

        // Set instance variables
        this.pane = pane;

    }

    // Constructor without task
    public TaskEditScene (Pane pane, int v, int v1, Object[] scenes) {

        // Super constructor
        super(pane, v, v1);

        // Set instance variables
        this.pane = pane;
        this.scenes = scenes;

    }

    // Constructor with task
    public TaskEditScene (Pane pane, int v, int v1, Task task, Object[] scenes) {

        // Super constructor
        super(pane, v, v1);

        // Set instance variables
        this.pane = pane;
        this.scenes = scenes;
        setTask(task);

    }

    // Set task
    public void setTask (Task task) {

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

        // TODO Create display objects

        // Title
        TextField title = new TextField(this.taskTitle);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, CONSTANTS.DETAILS_TITLE_TEXT_SIZE));
        //title.setPrefWidth(800);
        //title.setPrefHeight(100);
        title.setLayoutX(CONSTANTS.DETAILS_X_OFFSET-19);
        title.setLayoutY(CONSTANTS.DETAILS_TITLE_Y_OFFSET-43);
        this.pane.getChildren().add(title);
        // TODO text color

        // Description
        TextArea description = new TextArea(this.taskDescription);
        description.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.REGULAR, CONSTANTS.DETAILS_CONTENT_TEXT_SIZE));
        description.setLayoutX(CONSTANTS.DETAILS_X_OFFSET-7);
        description.setLayoutY(CONSTANTS.DETAILS_DESCRIPTION_Y_OFFSET-15);
        description.setPrefWidth(399);
        description.setPrefHeight(150);
        description.setWrapText(true);
        this.pane.getChildren().add(description);

        // TODO Date
        Text date = new Text();
        date.setText("Due: " + this.taskDeadline);
        date.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.REGULAR, CONSTANTS.DETAILS_CONTENT_TEXT_SIZE));
        date.setLayoutX(CONSTANTS.DETAILS_X_OFFSET);
        date.setLayoutY(CONSTANTS.DETAILS_DEADLINE_Y_OFFSET);
        this.pane.getChildren().add(date);

        // Difficulty text
        Text difficultyText = new Text();
        difficultyText.setText("Difficulty: ");
        difficultyText.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.ITALIC, CONSTANTS.DETAILS_CONTENT_TEXT_SIZE));
        difficultyText.setLayoutX(CONSTANTS.DETAILS_X_OFFSET);
        difficultyText.setLayoutY(CONSTANTS.DETAILS_DIFFICULTY_Y_OFFSET);
        this.pane.getChildren().add(difficultyText);

        // Difficulty input
        TextField difficultyInput = new TextField("" + this.taskDifficulty);
        difficultyInput.setFont(Font.font("Comic Sans MS", FontWeight.LIGHT, FontPosture.ITALIC, CONSTANTS.DETAILS_CONTENT_TEXT_SIZE));
        difficultyInput.setLayoutX(CONSTANTS.DETAILS_X_OFFSET + 54);
        difficultyInput.setLayoutY(CONSTANTS.DETAILS_DIFFICULTY_Y_OFFSET - 14);
        difficultyInput.setPrefWidth(338);
        this.pane.getChildren().add(difficultyInput);

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

                // Set scene to input scenes[2] which is task details scene
                ((Stage)scenes[0]).setScene((Scene)scenes[2]);

            }
        });
        this.pane.getChildren().add(closeButton);

    }

    public void setSceneList(Object[] scenes) {

        // Set instance variable
        this.scenes = scenes;

    }

}
