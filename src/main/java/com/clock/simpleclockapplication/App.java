package com.clock.simpleclockapplication;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
     private CLock clock;

    @Override
    public void start(Stage primaryStage) {
        clock = new CLock(300, 300);

        // Create a label for the title
        Label titleLabel = new Label("Angelo Clock");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Use a StackPane to layer the label on top of the clock
        StackPane root = new StackPane();
        root.getChildren().addAll(titleLabel, clock);
        StackPane.setAlignment(titleLabel, Pos.TOP_CENTER); // Align label to the top

        // Create a thread for updating the clock
        Thread clockUpdater = new Thread(() -> {
            while (true) {
                clock.updateClock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Clock update interrupted.");
                }
            }
        });
        clockUpdater.setPriority(Thread.MAX_PRIORITY);

        // Start the clock updater thread
        clockUpdater.start();

        // Set up the scene and stage
        Scene scene = new Scene(root, 350, 350); // Adjust size as needed
        primaryStage.setTitle("Analog Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}