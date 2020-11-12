package com.revature.pieces;

import com.revature.board.Board;
import com.revature.board.Spot;

public class Rook extends Piece {
	
	private boolean firstMove = true;
    
    public Rook(boolean white) {
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
        
        if((x == 0 && y != 0)) {
        	for(int j = 1; j < y; j++) {
        		if(board.getBox(start.getX(), start.getY()+(j*y_sign)).getPiece() != null) {
        			return false;
        		}
        	}
        } else if(x != 0 && y == 0) {
        	for(int i = 1; i < x; i++) {
        		if(board.getBox(start.getX()+(i*x_sign), start.getY()).getPiece() != null) {
        			return false;
        		}
        	}
        }
        
        firstMove = false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Rook [isWhite()=" + isWhite() + ", isKilled()=" + isKilled() + "]";
    }
}
