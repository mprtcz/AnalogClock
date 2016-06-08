package com.azotan.clock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Azet on 2015-12-05.
 */
public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(getClass().toString());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUIClock.fxml"));
        System.out.println(loader.getResources());
        Parent root = loader.load();

        Scene scene = new Scene(root, 1024, 768);

        primaryStage.setTitle("The Clock");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
