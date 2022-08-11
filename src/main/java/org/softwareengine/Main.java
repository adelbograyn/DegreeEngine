package org.softwareengine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.softwareengine.core.controller.EmployeeController;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(new EmployeeController().root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.out.println("fuck you java ");
        launch(args);
    }
}