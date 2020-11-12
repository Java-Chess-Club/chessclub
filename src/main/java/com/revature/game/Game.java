package com.revature.game;

import java.util.ArrayList;
import java.util.List;

import com.revature.board.Board;
import com.revature.board.Spot;
import com.revature.pieces.King;
import com.revature.pieces.Piece;
import com.revature.players.HumanPlayer;
import com.revature.players.Player;

public class Game {
    private Player[] players = new Player[2];
    private Board board = new Board();
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed = new ArrayList<>();
    private List<Piece> graveyard = new ArrayList<>();
    
    public Board getBoard() {
        return board;
    }
    
    public List<Move> getMovesPlayed() {
        return movesPlayed;
    }
    
    public List<Piece> getGraveyard() {
        return graveyard;
    }

    public void initialize(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        
        board.resetBoard();
        
        if (p1.isWhiteSide()) {
            this.currentTurn = p1;
        }
        else {
            this.currentTurn = p2;
        }
        movesPlayed.clear();
    }
    
    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE;
    }
    
    public GameStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(GameStatus status) {
        this.status = status;
    }
    
    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) {
        Spot startBox = board.getBox(startX, startY);
        Spot endBox = board.getBox(endX, endY);
        Move move = new Move(player, startBox, endBox);
        return this.makeMove(move, player);
    }
    
    public boolean makeMove(Move move, Player player) {
        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null || player != currentTurn || sourcePiece.isWhite() != player.isWhiteSide()) {
            return false;
        }
        
        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
            return false;
        }
        
        Piece destPiece = move.getEnd().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            graveyard.add(destPiece);
            move.setPieceKilled(destPiece);
        }
        
        // castling?
        if (sourcePiece instanceof King) {
            King king = (King) sourcePiece;
            if (king.isCastlingMove(move.getStart(), move.getEnd())) {
                move.setCastlingMove(true);
            }
        }
        
        movesPlayed.add(move);
        
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);
        
        if (destPiece instanceof King) {
            if (player.isWhiteSide()) {
                this.setStatus(GameStatus.WHITE_WIN);
            }
            else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }
        
        if (this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        }
        else {
            this.currentTurn = players[0];
        }
        return true;
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        Player p1 = new HumanPlayer(true, "jandrew");
        Player p2 = new HumanPlayer(false, "scaceres");
        game.initialize(p1, p2);   
    }
    
    
}
