package com.example.chess.model.game.pieces;

import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;
import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.Piece;

public class Queen extends Piece {

    public Queen(EnumColor color, int row, int col, ImageView image) {
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

        if(this.getCol() == col || this.getRow() == row){ // se não puder ser um bispo;
            if((this.getCol() != col && this.getRow() != row) || (this.getRow() == row && this.getCol() == col)) {
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


        }else{ // se for um bispo -----------------------------------------------

            int currentRow = this.getRow(); // para o loop
            int currentCol = this.getCol(); // para o loop

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
}
