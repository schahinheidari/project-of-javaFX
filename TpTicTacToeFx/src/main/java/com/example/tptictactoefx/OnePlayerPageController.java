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

public class OnePlayerPageController implements Initializable {

    @FXML
    private Button Startbtnoneplayer, exitbtn;
    @FXML
    private TextField nameoneplayer;
    @FXML
    private Label errorlbl;

    static Stage startGameStage = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorlbl.setText("");

        exitbtn.setOnAction(e -> closeStage());
        //Startbtnoneplayer.setOnAction(e -> createUser());
        Startbtnoneplayer.setOnAction(e-> {
            try {
                startGame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void closeStage() {
        ((Stage) exitbtn.getScene().getWindow()).close();
        FirstPageController.onePlayerStage = null;
    }

    private void createUser() {
        if (checkField()){
            User user = new User(nameoneplayer.getText());

        }
    }

    private boolean checkField() {
        if (nameoneplayer.getText().isEmpty()){
            errorlbl.setText("please fill the names");
            return false;
        }
        return true;
    }

    private void startGame() throws IOException {
        if (startGameStage == null){
            HBox root = FXMLLoader.load (getClass().getResource("viewUpdate.fxml"));
            Stage stage = (Stage) Startbtnoneplayer.getScene().getWindow();
            stage.setScene(new Scene(root));
            startGameStage.setTitle("Tic-Tac-Toe");
            //startGameStage.setScene(scene);
            startGameStage.show();
            startGameStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        }
    }

}

