package com.example.chess.model.game.pieces;

import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;
import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.Piece;

public class Rook extends Piece {
    public Rook(EnumColor color, int row, int col, ImageView image){
        super(color, row, col, image);
        this.setCanCastle(true);
    }

    @Override
    public String checkMoviment(int row, int col, ChessBoard chessBoard) {
        if(this.getChessBoard().getTurn() != this.getChessBoard().getSelectedPiece().getPiece().getColor()){
            return "false";
        }
        if((this.getCol() != col && this.getRow() != row) || (this.getRow() == row && this.getCol() == col)) {
            return "false";
        }
        if(this.getCol() == col && this.getRow() == row){
            return "false";
        }

        int currentRow = this.getRow();
        int currentCol = this.getCol();

        if(row > this.getRow()){
            currentRow++;
            while(currentRow < row){
                if(this.getChessBoard().getPiece(currentRow, currentCol) != null){
                    if (this.getColor() == this.getChessBoard().getPiece(currentRow, currentCol).getColor()){
                        return "false";
                    }else{
                        this.setCanCastle(false);
                        return "CAPTURE";
                    }
                }
                currentRow++;
            }
        }else if(this.getRow() > row){
            currentRow--;
            while(currentRow > row){
                if(this.getChessBoard().getPiece(currentRow, currentCol) != null){
                    if (this.getColor() == this.getChessBoard().getPiece(currentRow, currentCol).getColor()){
                        return "false";
                    }else{
                        this.setCanCastle(false);
                        return "CAPTURE";
                    }
                }
                currentRow--;
            }
        }else if(col > this.getCol()){
            currentCol++;
            while(currentCol < col){
                if(this.getChessBoard().getPiece(currentRow, currentCol) != null){
                    if (this.getColor() == this.getChessBoard().getPiece(currentRow, currentCol).getColor()){
                        return "false";
                    }else{
                        this.setCanCastle(false);
                        return "CAPTURE";
                    }
                }
                currentCol++;
            }

        }else if(this.getCol() > col){
            currentCol--;
            while(col < currentCol){
                if(this.getChessBoard().getPiece(currentRow, currentCol) != null){
                    if (this.getColor() == this.getChessBoard().getPiece(currentRow, currentCol).getColor()){
                        return "false";
                    }else{
                        this.setCanCastle(false);
                        return "CAPTURE";
                    }
                }
                currentCol--;
            }
        }
        if(this.getChessBoard().getPiece(currentRow, currentCol) != null){
            if (this.getColor() == this.getChessBoard().getPiece(currentRow, currentCol).getColor()){
                return "false";
            }else{
                this.setCanCastle(false);
                return "CAPTURE";
            }
        }

        this.setCanCastle(false);
        return "DEFALT";
    }

}
