package com.example.tptictactoefx;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;

import java.util.Arrays;
import java.util.Random;

import static com.example.tptictactoefx.EPlayer.*;
import static com.example.tptictactoefx.Constants.*;
import static com.example.tptictactoefx.EState.*;

public class Game extends Task<Void> {
    public boolean end;
    public EPlayer move;
    int nbMoves;
    IntegerProperty pos;
    Board board;
    Cell cell;
    Random random;
    StringProperty winner;
    IPlay computer;

    public Game(EPlayer firstPlayer, int mode){
        winner = new SimpleStringProperty();
        pos = new SimpleIntegerProperty();
        end = false;
        computer = (mode == 0) ? this::playRandom : this::playPerfect;
        nbMoves = NB_MOVES;
        board = new Board();
        cell  = new Cell(-1, E);
        move = firstPlayer;
        random = new Random();
    }

    public boolean isEndGame(){
        end = board.checkWin()|| nbMoves == 0;
        return end;
    }
    public void playHuman() throws InterruptedException {
        while (move == HUMAN){
            Thread.sleep(100);

        }
    }

    public void playRandom(){
        var validCells = Arrays.stream(board.grid).filter(c -> c.state == E).toList();

        cell = validCells.get(random.nextInt(validCells.size()));
        cell.state = O;
        pos.set(cell.num);
        board.update(cell.num, O);
        move = HUMAN;

    }
    public void playPerfect(){

    }
    @Override
    protected Void call() throws Exception {
        do {
            switch (move){
                case HUMAN :
                    playHuman();
                    break;
                case COMPUTER:
                    computer.play();
                    break;
                default:
                    break;
            }
        } while (!isEndGame());
        winner.set(move == COMPUTER ? "HUMAN" : "COMPUTER" );
        return null;
    }
}
