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
    	
    	// Check if end spot has piece of the same color
        if (end.getPiece() != null) {
        	if(end.getPiece().isWhite() == this.isWhite()) {
        		return false;
        	}
        }
        
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        
        int x_sign = end.getX() - start.getX() < 0 ? -1 : 1;
        
        // Check if pawn can kill piece in end spot
        	// black pawn
        if (end.getPiece() != null && (x==1 && end.getY() - start.getY() == 1) && this.isWhite()) {
            return true;
        }
        	// white pawn
        if (end.getPiece() != null && (x==1 && end.getY() - start.getY() == -1) && !this.isWhite()) {
            return true;
        }
        // Check if end spot is occupied and pawn moving forward
        if (end.getPiece() != null && x == 1 && y == 0) {
            return false;
        }
        
        // Check if end spot is occupied and not blocked pawn moving forward 2 spaces
        if (board.getBox((start.getX()+(1*x_sign)), y).getPiece() != null && x == 2 && y == 0) {
            return false;
        }
        
        // Check if first move
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
