package com.revature.pieces;

import com.revature.board.Board;
import com.revature.board.Spot;

public class Queen extends Piece {
    
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece().isWhite() == this.isWhite()) { return false; }
        
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        
        if ((x == 0 && y != 0) || (x != 0 && y == 0)) {
            return true;
        }
        else if (y != 0) {
            if (x % y == 0) { return true; }
           
        }
        else if (x != 0) {
            if (y % x == 0) { return true; }
        }
        return false;
    }
}
