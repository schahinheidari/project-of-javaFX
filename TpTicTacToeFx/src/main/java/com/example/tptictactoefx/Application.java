package com.example.tptictactoefx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
        //firstPage(stage);

        /*HBox root = FXMLLoader.load (getClass().getResource("viewUpdate.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Tic-Tac-Toe");
        stage.setScene(scene);
        stage.show();*/

        AnchorPane root = FXMLLoader.load(this.getClass().getResource("firstPage.fxml"));
        stage.setTitle("Welcome to tic tac toe game");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}