package com.example.chess.model.game.pieces;

import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;
import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.Piece;

public class Bishop extends Piece {

    public Bishop(EnumColor color, int row, int col, ImageView image){
        super(color, row, col, image);
    }

    @Override
    public String checkMoviment(int row, int col, ChessBoard chessBoard) {
        if(this.getChessBoard().getTurn() != this.getChessBoard().getSelectedPiece().getPiece().getColor()){
            return "false";
        }
        int currentRow = this.getRow(); // para o loop
        int currentCol = this.getCol(); // para o loop

        if(this.getCol() == col || this.getRow() == row){
            return "false";
        }

        int aux, aux2;
        if(row> this.getRow()){
            currentRow++;
            aux = row-this.getRow();
            if(col>this.getCol()) {
                currentCol++;
                aux2 = col - this.getCol();
            }else {
                currentCol--;
                aux2 = this.getCol() - col;
            }
        }else{
            aux = this.getRow()-row;
            currentRow--;
            if(col>this.getCol()) {
                currentCol++;
                aux2 = col - this.getCol();
            }else {
                currentCol--;
                aux2 = this.getCol() - col;
            }
        }
        if(aux != aux2)
            return "false";
        // ------


        while(currentRow != row && currentCol != col){
            if(this.getChessBoard().getPiece(currentRow, currentCol) != null){
                if (this.getColor() == this.getChessBoard().getPiece(currentRow, currentCol).getColor()){
                    return "false";
                }else{
                    return "CAPTURE";
                }
            }
            if(row>this.getRow())
                currentRow++;
            else
                currentRow--;

            if (col > this.getCol())
                currentCol++;
            else
                currentCol--;

        }
        if(this.getChessBoard().getPiece(currentRow, currentCol) != null){
            if (this.getColor() == this.getChessBoard().getPiece(currentRow, currentCol).getColor()){
                return "false";
            }else{
                return "CAPTURE";
            }
        }
        return "DEFALT";
    }
}
