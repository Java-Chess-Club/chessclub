package com.revature.pieces;

import com.revature.board.Board;
import com.revature.board.Spot;

public class Bishop extends Piece {
    
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece().isWhite() == this.isWhite()) { return false; }
        
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        
        if (y != 0) { return x % y == 0; }
        else { return y % x == 0; }
    }
}
