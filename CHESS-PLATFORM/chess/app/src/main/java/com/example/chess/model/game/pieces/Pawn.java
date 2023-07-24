package com.example.chess.model.game.pieces;

import android.util.Log;
import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;
import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.Piece;

public class Pawn extends Piece {

    public Pawn(EnumColor color, int row, int col, ImageView image) {
        super(color, row, col, image);
    }

    @Override
    public String checkMoviment(int row, int col, ChessBoard chessBoard) {
        if(this.getChessBoard().getTurn() != this.getChessBoard().getSelectedPiece().getPiece().getColor()){
            return "false";
        }
        if(this.getCol() == col && this.getRow() == row){
            return "false";
        }

        if (this.getColor() == EnumColor.WHITE) {
            if (this.getRow() == 1) { // primeiro lançe que pode ser de uma ou duas casas
                if ((row == 2 || row == 3) && (col == this.getCol())) {
                    Log.i("testeee", "defalt");
                    return "DEFAULT";
                }else
                    return "false";

            } else {
                if ((row == this.getRow() + 1) && (col == this.getCol())) {
                    if (chessBoard.getPiece(row, col) == null) {
                        Log.i("testeee", "defalt");
                        return "DEFAULT";
                    }
                }
                if (row == this.getRow() + 1 && (col == this.getCol() + 1 || col == this.getCol() - 1)) {
                    if (chessBoard.getPiece(row, col) == null)
                        return "false";
                    if (chessBoard.getPiece(row, col).getColor() == EnumColor.DARK) {
                        Log.i("testeee", "capture");
                        return "CAPTURE";
                    }
                }
                return "false";
            }
        } else { //lances das pretas
            if (this.getRow() == 6) { // primeiro lançe que pode ser de uma ou duas casas
                if ((row == 5 || row == 4) && (col == this.getCol())) {
                    Log.i("testeee", "defalt");
                    return "DEFAULT";
                }else
                    return "false";

            } else {
                if ((row == this.getRow() - 1) && (col == this.getCol())) {
                    if (chessBoard.getPiece(row, col) == null) {
                        Log.i("testeee", "defalt");
                        return "DEFAULT";
                    }
                }
                if (row == this.getRow() - 1 && (col == this.getCol() + 1 || col == this.getCol() - 1)) {
                    if (chessBoard.getPiece(row, col) == null)
                        return "false";
                    if (chessBoard.getPiece(row, col).getColor() == EnumColor.WHITE) {
                        Log.i("testeee", "capture");
                        return "CAPTURE";
                    }
                }
                return "false";
            }
        }
    }
}
