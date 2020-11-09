package com.revature.pieces;

import com.revature.board.Board;
import com.revature.board.Spot;

public class Rook extends Piece {
    
    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece().isWhite() == this.isWhite()) { return false; }
        
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        
        return (x == 0 && y != 0) || (x != 0 && y == 0); 
    }
}
