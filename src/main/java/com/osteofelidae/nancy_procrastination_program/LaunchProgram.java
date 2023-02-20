// Package declaration
package com.osteofelidae.nancy_procrastination_program;

// Import required libraries
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

// Launcher
public class LaunchProgram extends Application {

    // Public variables
    public static String sceneName = "taskList";
    public static boolean continueLoop = true;

    // Override
    @Override

    // Start function called by javaFX
    public void start(Stage applicationStage){

        // Task list

        Pane taskListPane = new Pane();
        TaskListScene taskListScene = new TaskListScene(taskListPane, 1200, 400);

        // Task details
        Pane taskDetailsPane = new Pane();
        TaskDetailsScene taskDetailsScene = new TaskDetailsScene(taskDetailsPane, 1200, 400);

        // Edit task
        Pane taskEditPane = new Pane();
        TaskEditScene taskEditScene = new TaskEditScene(taskEditPane, 1200, 400);

        // Object array to be passed into task objects
        Object[] taskData = {applicationStage, taskListScene, taskDetailsScene, taskEditScene};

        taskDetailsScene.setSceneList(taskData);
        taskEditScene.setSceneList(taskData);


        // TODO Test task
        Task testTask = new Task(taskData, "Hello");
        testTask.setTaskDescription("Test task description");
        testTask.setTaskDeadline(2000, 2, 29);
        testTask.setTaskTitle("Hi");

        Task testTask2 = new Task(taskData, "Hello");
        testTask2.setTaskDescription("Test task2 description");
        testTask2.setTaskDeadline(2000, 2, 29);
        testTask2.setTaskTitle("Hi2");

        Task testTask3 = new Task(taskData, "Hello");
        testTask3.setTaskDescription("");
        testTask3.setTaskDeadline(2000, 2, 29);
        testTask3.setTaskTitle("Hi3");
        //taskDetailsPane.getChildren().add(testTask3);

        Task[] taskList = {testTask, testTask2, testTask3};
        taskListScene.setTaskList(taskList);





        // Set Task list scene
        applicationStage.setScene(taskListScene);

        // Run
        applicationStage.show();

    }

}
