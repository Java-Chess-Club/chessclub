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
import com.revature.pieces.Pawn;
import com.revature.pieces.Piece;
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
    public void movePawnTestFail1() {
        assertFalse(game.playerMove(p2, 1, 0, 2, 0));
    }
    
    @Test
    public void movePawnTestFail2() {
        assertFalse(game.playerMove(p1, 1, 0, 4, 0));
    }
    
    @Test
    public void pawnKillSuccess() {
        Piece pawn = new Pawn(false);
        pawn.setKilled(true);
        game.playerMove(p1, 1, 0, 3, 0);
        game.playerMove(p2, 6, 1, 4, 1);
        game.playerMove(p1, 3, 0, 4, 1); 
        assertTrue(game.getGraveyard().get(0) instanceof Pawn && game.getGraveyard().get(0).isKilled() == true);
    }
    
    @Test
    public void moveRookTest() {
        game.getBoard().getBox(1, 0).setPiece(null);
        assertTrue(game.playerMove(p1, 0, 0, 5, 0));
    }
    
    @Test
    public void moveKnightTest() {
        assertTrue(game.playerMove(p1, 0, 1, 2, 2));
    }
    
    @Test
    public void moveBishopTest() {
        game.getBoard().getBox(1, 1).setPiece(null);
        assertTrue(game.playerMove(p1, 0, 2, 2, 0));
    }
    
    @Test
    public void moveQueenTest() {
        game.getBoard().getBox(1, 2).setPiece(null);
        assertTrue(game.playerMove(p1, 0, 3, 3, 0));
    }
}
