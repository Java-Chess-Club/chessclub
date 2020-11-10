package com.revature.pieces;

import com.revature.board.Board;
import com.revature.board.Spot;

public class King extends Piece {
    private boolean castlingDone = false;
    private boolean firstMove = true;
    
    public King(boolean white) {
        super(white);
    }
    
    public boolean isCastlingDone() {
        return this.castlingDone;
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
        if (x + y == 1) {
            //Logic for checking if move will not result in king being attacked
            return true;
        }
        return this.isValidCastling(board, start, end);
    }
    
    private boolean isValidCastling(Board board, Spot start, Spot end) {
        if (this.isCastlingDone() && this.firstMove) {
            this.firstMove = false;
            return false;
        }
        // Logic for returning true or false
        return true;
    }
    
    public boolean isCastlingMove(Spot start, Spot end) {
        // check if the starting and ending position are correct
        if(end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                int x = Math.abs(start.getX() - end.getX());
                int y = Math.abs(start.getY() - end.getY());
                if (x + y == 1) {
                    //Logic for checking if move will not result in king being attacked
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "King [isWhite()=" + isWhite() + ", isKilled()=" + isKilled() + "]";
    }
}
