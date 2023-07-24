package com.example.chess.model.game;

import android.widget.ImageView;

public abstract class Piece {
    private EnumColor color;  // 0 para brancas, 1 para pretas
    private int row, col;
    private ImageView image;
    private ChessBoard chessBoard;
    private boolean eliminated = false;
    private boolean selected = false;
    private boolean canCastle = false;


    public Piece(EnumColor color, int row, int col, ImageView image){
        this.color = color;
        this.row = row;
        this.col = col;
        this.image = image;
    }

    public abstract String checkMoviment(int row, int col, ChessBoard chessBoard);

    public EnumColor getColor() {
        return color;
    }



    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public ImageView getImage() {
        return image;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean isCanCastle(){
        return this.canCastle;
    }


    public void setColor(EnumColor color) {
        this.color = color;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public void setSelected(boolean select) {
        this.selected = select;
    }

    public void setCanCastle(boolean canCastleValue){
        this.canCastle = canCastleValue;
    }
}
