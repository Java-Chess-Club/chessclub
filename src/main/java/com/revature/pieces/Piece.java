package com.revature.pieces;

import com.revature.board.Board;
import com.revature.board.Spot;

public abstract class Piece implements Moveable {
    
    private boolean killed = false;
    private boolean white = false;
    
    public Piece(boolean white) {
        this.setWhite(white);
    }
    
    public boolean isWhite() {
        return this.white;
    }
    
    public boolean isKilled() {
        return this.killed;
    }
    
    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }
    
    public abstract boolean canMove(Board board, Spot start, Spot end);

    @Override
    public int move() {
        return 1;
    }
}
