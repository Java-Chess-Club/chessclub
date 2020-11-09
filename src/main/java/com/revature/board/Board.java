package com.revature.board;

import com.revature.pieces.Bishop;
import com.revature.pieces.King;
import com.revature.pieces.Knight;
import com.revature.pieces.Pawn;
import com.revature.pieces.Queen;
import com.revature.pieces.Rook;

public class Board {
    private Spot[][] boxes;
    
    public Board() {
        this.resetBoard();
    }
    
    public Spot getBox(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        return boxes[x][y];
    }
    
    public void resetBoard() {
        boxes[0][0] = new Spot(0, 0, new Rook(true));
        boxes[0][1] = new Spot(0, 1, new Knight(true)); 
        boxes[0][2] = new Spot(0, 2, new Bishop(true));
        boxes[0][3] = new Spot(0, 3, new Queen(true)); 
        boxes[0][4] = new Spot(0, 4, new King(true));
        boxes[0][5] = new Spot(0, 5, new Bishop(true)); 
        boxes[0][6] = new Spot(0, 6, new Knight(true));
        boxes[0][7] = new Spot(0, 7, new Rook(true)); 
        
        boxes[1][0] = new Spot(1, 0, new Pawn(true)); 
        boxes[1][1] = new Spot(1, 1, new Pawn(true));
        boxes[1][2] = new Spot(1, 2, new Pawn(true)); 
        boxes[1][3] = new Spot(1, 3, new Pawn(true));
        boxes[1][4] = new Spot(1, 4, new Pawn(true)); 
        boxes[1][5] = new Spot(1, 5, new Pawn(true));
        boxes[1][6] = new Spot(1, 6, new Pawn(true)); 
        boxes[1][7] = new Spot(1, 7, new Pawn(true));
        
        boxes[0][0] = new Spot(7, 0, new Rook(true));
        boxes[0][1] = new Spot(7, 1, new Knight(true)); 
        boxes[0][2] = new Spot(7, 2, new Bishop(true));
        boxes[0][3] = new Spot(7, 3, new Queen(true)); 
        boxes[0][4] = new Spot(7, 4, new King(true));
        boxes[0][5] = new Spot(7, 5, new Bishop(true)); 
        boxes[0][6] = new Spot(7, 6, new Knight(true));
        boxes[0][7] = new Spot(7, 7, new Rook(true)); 
        
        boxes[1][0] = new Spot(1, 0, new Pawn(true)); 
        boxes[1][1] = new Spot(1, 1, new Pawn(true));
        boxes[1][2] = new Spot(1, 2, new Pawn(true)); 
        boxes[1][3] = new Spot(1, 3, new Pawn(true));
        boxes[1][4] = new Spot(1, 4, new Pawn(true)); 
        boxes[1][5] = new Spot(1, 5, new Pawn(true));
        boxes[1][6] = new Spot(1, 6, new Pawn(true)); 
        boxes[1][7] = new Spot(1, 7, new Pawn(true));
        
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Spot(i, j, null);
            }
        }
    }
}
