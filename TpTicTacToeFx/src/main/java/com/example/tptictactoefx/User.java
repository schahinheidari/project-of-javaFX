package com.example.tptictactoefx;

public class User {

    private String nameoneplayer;
    private String nameplayer1;
    private String nameplayer2;

    public User(String nameplayer1, String nameplayer2) {
        this.nameplayer1 = nameplayer1;
        this.nameplayer2 = nameplayer2;
    }

    public String getNameoneplayer() {
        return nameoneplayer;
    }

    public void setNameoneplayer(String nameoneplayer) {
        this.nameoneplayer = nameoneplayer;
    }

    public String getNameplayer1() {
        return nameplayer1;
    }

    public void setNameplayer1(String nameplayer1) {
        this.nameplayer1 = nameplayer1;
    }

    public String getNameplayer2() {
        return nameplayer2;
    }

    public void setNameplayer2(String nameplayer2) {
        this.nameplayer2 = nameplayer2;
    }

    public User(String nameoneplayer) {
        this.nameoneplayer = nameoneplayer;
    }
}
