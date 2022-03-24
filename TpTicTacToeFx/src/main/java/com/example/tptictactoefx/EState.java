package com.example.tptictactoefx;

public enum EState {
    X(1), O(-1), E(0);

    int value;
    private EState(int value){
        this.value = value;
    }
}
