package com.revature.chess;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.board.Board;



public class ChessApplicationTests {
	
	Board testBoard = new Board(); 

	@Test
	public void boardResetTest() {
		assertNotNull(testBoard); 
	}

}
