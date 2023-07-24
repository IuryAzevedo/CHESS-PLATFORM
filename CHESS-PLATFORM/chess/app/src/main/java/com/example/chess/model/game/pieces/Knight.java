package com.example.chess.model.game.pieces;

import android.util.Log;
import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;
import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.Piece;

public class Knight extends Piece {

    public Knight(EnumColor color, int row, int col, ImageView image) {
        super(color, row, col, image);
    }

    @Override
    public String checkMoviment(int row, int col, ChessBoard chessBoard) {
        if(this.getChessBoard().getTurn() != this.getChessBoard().getSelectedPiece().getPiece().getColor()){
            return "false";
        }
        if(this.getCol() == col || this.getRow() == row){
            return "false";
        }

        if ((row == (this.getRow() + 2)) || (row == (this.getRow() - 2))) {
            if ((col == (this.getCol() + 1)) || (col == (this.getCol() - 1))) {
                Log.i("testeee", "row +- 2");
                if(this.getChessBoard().getPiece(row, col) != null){
                    if(this.getColor() == this.getChessBoard().getPiece(row, col).getColor()){
                        return "false";
                    }else{
                        return "CAPTURE";
                    }
                }
            } else {
                return "false";
            }
        } else if ((col == (this.getCol() + 2)) || (col == (this.getCol() - 2))) {
            Log.i("testeee", "col +- 2");
            if ((row == (this.getRow() + 1)) || (row == (this.getRow() - 1))) {
                if(this.getChessBoard().getPiece(row, col) != null){
                    if(this.getColor() == this.getChessBoard().getPiece(row, col).getColor()){
                        return "false";

                    }else{
                        return "CAPTURE";
                    }
                }
            } else {
                return "false";
            }
        } else {
            return "false";
        }

        return "DEFALT";
    }
}
