package com.revature.board;

import com.revature.pieces.Piece;

public class Spot {
    private Piece piece;
    private int x;
    private int y;
    
    // boolean protected-threatened by white
    // boolean protected-threatened by black
    
    
    public Spot(int x, int y, Piece piece) {
        this.setPiece(piece);
        this.setX(x);
        this.setY(y);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Spot [piece=" + piece + ", x=" + x + ", y=" + y + "]";
    }
}
