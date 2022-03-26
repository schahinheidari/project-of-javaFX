package com.example.tptictactoefx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstPageController implements Initializable {

    @FXML
    private Button oneplayerbtn, exitbtn, multiplayerbtn;

    static  Stage onePlayerStage = null;
    static Stage multiPlayerStage = null;
    public FirstPageController() {
    }

    @FXML
    public void run1(){

    }

    @FXML
    public void run2(){

    }
    @FXML
    public void exit(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        oneplayerbtn.setOnAction(e -> {
            try {
                onePlayerPage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        multiplayerbtn.setOnAction(e -> {
            try {
                multiPlayerPage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        exitbtn.setOnAction(e -> Platform.exit());

    }

    private void openFirstPage() throws IOException {
        BorderPane root = FXMLLoader.load(this.getClass().getResource("com/example/tptictactoefx/firstPage.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Welcome to tic tac toe game");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void onePlayerPage() throws IOException {
        if (onePlayerStage == null) {
            BorderPane root = FXMLLoader.load(this.getClass().getResource("com/example/tptictactoefx/one-player.fxml"));
            onePlayerStage = new Stage();
            onePlayerStage.setTitle("Play tic tac toe game with computer");
            onePlayerStage.setScene(new Scene(root));
            onePlayerStage.show();
        }
    }

    private void multiPlayerPage() throws IOException {
        if (multiPlayerStage == null) {
            BorderPane root = FXMLLoader.load(this.getClass().getResource("com/example/tptictactoefx/multi-player.fxml"));
            multiPlayerStage = new Stage();
            multiPlayerStage.setTitle("Play tic tac toe game two persons");
            multiPlayerStage.setScene(new Scene(root));
            multiPlayerStage.show();
        }
    }
}
