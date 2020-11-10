package com.revature.pieces;

import com.revature.board.Board;
import com.revature.board.Spot;

public class Pawn extends Piece {
    private boolean isFirstMove = true;
    
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
            }
        }
        
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
             
        if (end.getPiece() != null && (x==1 && end.getY() - start.getY() == 1) && this.isWhite()) {
            return true;
        }
        if (end.getPiece() != null && (x==1 && end.getY() - start.getY() == -1) && !this.isWhite()) {
            return true;
        }
        
        if (end.getPiece() != null && x == 1 && y == 0) {
            return false;
        }
        
        if(isFirstMove) {
            isFirstMove = false;
            return (x <= 2 && y == 0);
        }
        else {
            return (x == 1 && y == 0);
        }
    }

    @Override
    public String toString() {
        return "Pawn [isWhite()=" + isWhite() + ", isKilled()=" + isKilled() + "]";
    }
}
