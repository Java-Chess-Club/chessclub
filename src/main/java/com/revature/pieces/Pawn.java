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
        if (end.getPiece().isWhite() == this.isWhite()) { return false; }
        
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
             
        if (end.getPiece() != null && (x==1 && end.getY() - start.getY() == 1) && this.isWhite()) {
            return true;
        }
        if (end.getPiece() != null && (x==1 && end.getY() - start.getY() == -1) && !this.isWhite()) {
            return true;
        }
        
        if(isFirstMove) {
            return (x == 0 && y <= 2);
        }
        else {
            return (x == 0 && y == 1);
        }
    }
}
