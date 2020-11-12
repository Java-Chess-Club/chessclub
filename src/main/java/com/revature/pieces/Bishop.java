package com.revature.pieces;

import com.revature.board.Board;
import com.revature.board.Spot;

public class Bishop extends Piece {
    
    public Bishop(boolean white) {
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
        
        int x_sign = end.getX() - start.getX() < 0 ? -1 : 1;
        int y_sign = end.getY() - start.getY() < 0 ? -1 : 1;
        
    	for(int i = 1; i < x; i++) {
    		if(board.getBox(start.getX()+(i*x_sign), start.getY()+(i*y_sign)).getPiece() != null) {
    			return false;
    		}
    	}
       
        return x == y;
    }
    
    @Override
    public String toString() {
        return "Bishop [isWhite()=" + isWhite() + ", isKilled()=" + isKilled() + "]";
    }
}
