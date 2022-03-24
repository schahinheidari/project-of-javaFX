package com.example.tptictactoefx;

import static com.example.tptictactoefx.Constants.*;
import static com.example.tptictactoefx.EPlayer.*;
import static com.example.tptictactoefx.EState.*;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;


public class Controller {
    @FXML
    private Canvas board;
    @FXML
    private CheckBox computer;
    @FXML
    private CheckBox human;
    @FXML
    private ComboBox<String> level;
    @FXML
    private  Label winner;
    private GraphicsContext gc;
    private Game game;
    public Controller(){

    }
    @FXML
    public void initialize(){
        gc = board.getGraphicsContext2D();
        level.setItems(FXCollections.observableList(Arrays.asList(RANDOM, PERFECT)));
    }
    @FXML
    public void init(){
        var firstPlayer = human.isSelected() ? HUMAN : COMPUTER;
        //var secondPlayer = computer.isSelected() ? COMPUTER : HUMAN;
        var mode = level.getSelectionModel().getSelectedIndex();

        game = new Game(firstPlayer, mode);
        game.winner.addListener((obs, old, newv) -> updateWinner());
        game.pos.addListener((obs, old, newv) -> View.drawMove(View.circle, gc, game.cell.num));
        board.setOnMouseClicked(this::getInputs);

        View.drawBoard(gc);
    }
    @FXML
    public void run(){
        var t = new Thread(game);
        t.start();
    }
    @FXML
    public void reset(){
        game.end = true;
        game.move = END;
        game.winner.set("------");
        game.cancel();
        gc.clearRect(0, 0, W_BOARD, W_BOARD);
    }

    public void getInputs(MouseEvent e){
        int i = (e.getX() < W_CASE) ? 0 : (e.getX() < 500) ? 1 : 2;
        int j = (e.getY() < W_CASE) ? 0 : (e.getY() < 500) ? 1 : 2;

        game.move = COMPUTER;
        game.board.grid[j * 3 + i].state = X;
        game.board.update(j * 3 + i, X);
        View.drawMove(View.cross, gc, i, j);


    }
    private void updateWinner(){
        Platform.runLater(()-> winner.setText(game.winner.get()));
    }
}