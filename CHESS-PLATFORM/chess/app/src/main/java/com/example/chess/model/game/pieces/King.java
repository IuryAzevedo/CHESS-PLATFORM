package com.example.chess.model.game.pieces;

import android.util.Log;
import android.widget.ImageView;

import com.example.chess.model.game.ChessBoard;
import com.example.chess.model.game.EnumColor;
import com.example.chess.model.game.Piece;

public class King extends Piece {
    private boolean canCastle = true;
    public King(EnumColor color, int row, int col, ImageView image) {
        super(color, row, col, image);
        this.setCanCastle(true);
    }

    @Override
    public String checkMoviment(int row, int col, ChessBoard chessBoard) {
        if(this.getChessBoard().getTurn() != this.getChessBoard().getSelectedPiece().getPiece().getColor()){
            return "false";
        }
        if(this.getCol() == col && this.getRow() == row){
            return "false";
        }

        if(col == this.getCol()+2){
            if(this.canCastle && (this.getChessBoard().getPiece(row, 7) != null)){//check roque
                if(this.getChessBoard().getPiece(row, 7).isCanCastle()){
                    for(int i = this.getCol()+1; i<col; i++){
                        if(this.getChessBoard().getPiece(row,i) != null){
                            return "false";
                        }
                    }
                    this.canCastle = false;
                    return "CASTLE";
                }
            }
        }else if(col == this.getCol()-2){
            if(this.canCastle && (this.getChessBoard().getPiece(row, 0) != null)){ //check grande roque
                if(this.getChessBoard().getPiece(row, 0).isCanCastle()){
                    for(int i = this.getCol()-1; i>col; i--){
                        if(this.getChessBoard().getPiece(row,i) != null){
                            return "false";
                        }
                    }
                    this.canCastle = false;
                    return "BIGCASTLE";
                }
            }
        }else  if(row >= this.getRow()-1 && row <= this.getRow()+1 && col >= this.getCol()-1 && col <= this.getCol()+1){ //check movimentos normais

           if(this.getChessBoard().getPiece(row, col) != null){
               if(this.getChessBoard().getPiece(row, col).getColor() != this.getColor()){
                   this.canCastle = false;
                   return "CAPTURE";
               }
           }else{
               this.canCastle = false;
               return "DEFAULT";
           }
        }
        return "false";
    }
}
