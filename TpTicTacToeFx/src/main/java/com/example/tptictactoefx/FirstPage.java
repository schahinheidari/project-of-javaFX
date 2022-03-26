package com.example.tptictactoefx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FirstPage {
    public static void firstPage(Stage stage){
        Button btnOnePlayer = new Button("One Player");
        btnOnePlayer.setPrefSize(200, 100);
        //btnOnePlayer.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Button btnMultiPlayer = new Button("Multi Player");
        btnMultiPlayer.setPrefSize(200, 100);
        HBox btnFirstPage = new HBox(btnOnePlayer, btnMultiPlayer);
        btnFirstPage.setSpacing(10);
        btnFirstPage.setStyle("-fx-font-size: 24");

        Button exitbtn = new Button("Exit");
        exitbtn.setPrefSize(200, 100);


        HBox btnFirstPageExit = new HBox(exitbtn);
        btnFirstPageExit.setAlignment(Pos.BOTTOM_CENTER);
        //HBox.setMargin(btnFirstPage, new Insets(10,0,0,0));
        //btnFirstPageExit.setPrefSize(100, 100);
        btnFirstPageExit.setSpacing(10);
        btnFirstPageExit.setStyle("-fx-font-size: 24");

        //btnFirstPage.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        //btnFirstPage.setBorder(new Border(new BorderStroke(Color.GRAY,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        btnFirstPage.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(btnFirstPage, btnFirstPageExit);
        vBox.setPrefSize(600,300);
        vBox.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(vBox));
        stage.setTitle("Tic-Tac-Toe");
        stage.show();
    }
}
