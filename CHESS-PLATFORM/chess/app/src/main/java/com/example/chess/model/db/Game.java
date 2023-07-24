package com.example.chess.model.db;

import com.example.chess.model.game.EnumColor;

public class Game {
    boolean result;
    String adversaryName;
    int adversaryRating;
    EnumColor color;

    Game(boolean result, String adversaryName, int adversaryRating, EnumColor color){
        this.result = result;
        this.adversaryName = adversaryName;
        this.adversaryRating = adversaryRating;
        this.color = color;
    }

    public boolean isResult() {
        return result;
    }

    public String getAdversaryName() {

        return adversaryName;
    }

    public int getAdversaryRating() {

        return adversaryRating;
    }

    public EnumColor getColor() {

        return color;
    }

    public void setResult(boolean result) {

        this.result = result;
    }

    public void setAdversaryName(String adversaryName) {

        this.adversaryName = adversaryName;
    }

    public void setAdversaryRating(int adversaryRating) {

        this.adversaryRating = adversaryRating;
    }

    public void setColor(EnumColor color) {

        this.color = color;
    }

}
