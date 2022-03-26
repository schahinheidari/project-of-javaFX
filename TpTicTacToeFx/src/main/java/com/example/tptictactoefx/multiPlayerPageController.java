package com.example.tptictactoefx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class multiPlayerPageController implements Initializable {

    @FXML
    private Button Startbtnmultiplayer, exitbtn;
    @FXML
    private TextField nameplayer1, nameplayer2;
    @FXML
    private Label errorlbl;
    static Stage startGameStage = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorlbl.setText("");

        exitbtn.setOnAction(e -> closeStage());
        //Startbtnmultiplayer.setOnAction(e -> createUser());
        Startbtnmultiplayer.setOnAction(e-> {
            try {
                startGame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void closeStage(){
        ((Stage) exitbtn.getScene().getWindow()).close();
        FirstPageController.multiPlayerStage = null;
    }

    private void createUser() {
        if (checkFields()){
            User user = new User(nameplayer1.getText(), nameplayer2.getText());
        }
    }

    private boolean checkFields() {
        if (nameplayer1.getText().isEmpty() || nameplayer2.getText().isEmpty()) {
            errorlbl.setText("please fill the names");
            return false;
        }
        return true;
    }
    private void startGame() throws IOException {
        if (startGameStage == null){
            HBox root = FXMLLoader.load (getClass().getResource("viewUpdate.fxml"));
            Scene scene = new Scene(root);
            startGameStage.setTitle("Tic-Tac-Toe");
            startGameStage.setScene(scene);
            startGameStage.show();
            startGameStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        }
    }
}
