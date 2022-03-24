package com.example.tptictactoefx;

import static com.example.tptictactoefx.Constants.*;
import static com.example.tptictactoefx.EState.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Board {
    Cell[] grid;
    int[] rows;
    int[] cols;
    int IDiag;
    int rDiag;

    public Board(){
        grid = new Cell[NB_CELLS];
        rows = new int[NB_CASES];
        cols = new int[NB_CASES];
        IDiag = 0;
        rDiag = 0;
        Stream.iterate(0, n -> n + 1).limit(NB_CELLS).forEach(i -> grid[i] = new Cell(i, E));
    }

    public void update(int num, EState state){
        int c = num % 3;
        int r = num / 3;

        rows[r] += state.value;
        cols[c] += state.value;
        IDiag += (r == c) ? state.value : 0;
        rDiag += (r + c == NB_CASES - 1) ? state.value : 0;

    }

    public boolean checkWin(){
        return (Arrays.stream(rows).filter(v -> Math.abs(v) == NB_CASES).count() == 1) ||
               (Arrays.stream(cols).filter(v -> Math.abs(v) == NB_CASES).count() == 1) ||
               (Math.abs(IDiag) == NB_CASES) || (Math.abs(rDiag) == NB_CASES);
    }
}
