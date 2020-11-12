package com.revature.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.game.Game;
import com.revature.pieces.Bishop;
import com.revature.pieces.Pawn;
import com.revature.pieces.Rook;
import com.revature.players.HumanPlayer;
import com.revature.players.Player;

public class ChessApplicationTests {
    
    private static Game game;
    private static Player p1;
    private static Player p2;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        game = new Game();
        p1 = new HumanPlayer(true, "jandrew");
        p2 = new HumanPlayer(false, "scareras");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        game.initialize(p1, p2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void boardResetTest() {
        game.initialize(p1, p2); 
        assertNotNull(game.getBoard());
    }
    
    @Test
    public void movePawnTestSuccess() {
        assertTrue(game.playerMove(p1, 1, 0, 2, 0));
    }
    
    @Test
    public void movePawnTwoSpacesTestSuccess() {
        assertTrue(game.playerMove(p1, 1, 0, 3, 0));
    }
    
    @Test
    public void movePawnTwoSpacesBlockedByPiece() {
    	game.getBoard().getBox(2, 0).setPiece(new Pawn(true));
        assertFalse(game.playerMove(p1, 1, 0, 3, 0));
    }
    
    @Test
    public void movePawnTestFail1() {
        assertFalse(game.playerMove(p2, 1, 0, 2, 0));
    }
    
    @Test
    public void movePawnTestFail2() {
        assertFalse(game.playerMove(p1, 1, 0, 4, 0));
    }
    
    @Test
    public void pawnKillSuccess() {
        game.playerMove(p1, 1, 0, 3, 0);
        game.playerMove(p2, 6, 1, 4, 1);
        game.playerMove(p1, 3, 0, 4, 1); 
        assertTrue(game.getGraveyard().get(0) instanceof Pawn && game.getGraveyard().get(0).isKilled() == true);
    }
    
    @Test
    public void moveRookBlockedByPieceTest() {
        assertFalse(game.playerMove(p1, 0, 0, 5, 0));
    }
    
    @Test
    public void moveRookTestVerticalDown() {
        game.getBoard().getBox(1, 0).setPiece(null);
        game.getBoard().getBox(5, 0).setPiece(new Rook(true));
        assertTrue(game.playerMove(p1, 5, 0, 1, 0));
    }
    
    @Test
    public void moveRookVerticalUpTest() {
        game.getBoard().getBox(1, 0).setPiece(null);
        assertTrue(game.playerMove(p1, 0, 0, 5, 0));
    }
    
    @Test
    public void moveRookHorizontalRight() {
        game.getBoard().getBox(5, 0).setPiece(new Rook(true));
        assertTrue(game.playerMove(p1, 5, 0, 5, 7));
    }
    
    @Test
    public void moveRookHorizontalLeft() {
        game.getBoard().getBox(5, 7).setPiece(new Rook(true));;
        assertTrue(game.playerMove(p1, 5, 7, 5, 0));
    }
    
    @Test
    public void moveKnightTest() {
        assertTrue(game.playerMove(p1, 0, 1, 2, 2));
    }
    
    @Test
    public void moveBishopBlockedByPieceTest() {
        assertFalse(game.playerMove(p1, 0, 2, 2, 0));
    }
    
    @Test
    public void moveBishopDiagonalUpLeft() {
        game.getBoard().getBox(1, 1).setPiece(null);
        assertTrue(game.playerMove(p1, 0, 2, 2, 0));
    }
    
    @Test
    public void moveBishopDiagonalUpRight() {
    	game.getBoard().getBox(1, 3).setPiece(null);
        assertTrue(game.playerMove(p1, 0, 2, 2, 4));
    }
    
    @Test
    public void moveBishopDiagonalDownRight() {
    	game.getBoard().getBox(4, 3).setPiece(new Bishop(true));
        assertTrue(game.playerMove(p1, 4, 3, 2, 5));
    }
    
    @Test
    public void moveBishopDiagonalDownLeft() {
    	game.getBoard().getBox(4, 3).setPiece(new Bishop(true));
        assertTrue(game.playerMove(p1, 4, 3, 2, 1));
    }
    
    @Test
    public void moveQueenTest() {
        game.getBoard().getBox(1, 2).setPiece(null);
        assertTrue(game.playerMove(p1, 0, 3, 3, 0));
    }
}
