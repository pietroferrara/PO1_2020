package it.unive.dais.po1.exercise1;

import org.junit.Assert;
import org.junit.Test;

public class TestBoard {

    @Test public void testBoardDiagonalCircle() {
        TicTacToeBoard board = new TicTacToeBoard();
        boolean added = board.put(Mark.getCircle(), 0, 0);
        added &= board.put(Mark.getCircle(), 1, 1);
        added &= board.put(Mark.getCircle(), 2, 2);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCircle(), board.winner());
    }

    @Test public void testFillCellTwice() {
        TicTacToeBoard board = new TicTacToeBoard();
        boolean added = board.put(Mark.getCircle(), 0, 0);
        Assert.assertTrue(added);
        added =  board.put(Mark.getCircle(), 0, 0);
        Assert.assertFalse(added);
    }

    @Test public void testBoardDiagonalCross() {
        TicTacToeBoard board = new TicTacToeBoard();
        boolean added = board.put(Mark.getCross(), 2, 0);
        added &= board.put(Mark.getCross(), 1, 1);
        added &= board.put(Mark.getCross(), 0, 2);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCross(), board.winner());
    }


    @Test public void testBoardHorizontalCircle() {
        TicTacToeBoard board = new TicTacToeBoard();
        boolean added = board.put(Mark.getCircle(), 0, 1);
        added &= board.put(Mark.getCircle(), 1, 1);
        added &= board.put(Mark.getCircle(), 2, 1);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCircle(), board.winner());
    }

    @Test public void testBoardHorizontalCross() {
        TicTacToeBoard board = new TicTacToeBoard();
        boolean added = board.put(Mark.getCross(), 0, 0);
        added &= board.put(Mark.getCross(), 1, 0);
        added &= board.put(Mark.getCross(), 2, 0);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCross(), board.winner());
    }



    @Test public void testBoardVerticalCircle() {
        TicTacToeBoard board = new TicTacToeBoard();
        boolean added = board.put(Mark.getCircle(), 1, 0);
        added &= board.put(Mark.getCircle(), 1, 1);
        added &= board.put(Mark.getCircle(), 1, 2);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCircle(), board.winner());
    }

    @Test public void testBoardVerticalCross() {
        TicTacToeBoard board = new TicTacToeBoard();
        boolean added = board.put(Mark.getCross(), 2, 0);
        added &= board.put(Mark.getCross(), 2, 1);
        added &= board.put(Mark.getCross(), 2, 2);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCross(), board.winner());
    }

    @Test public void testEmptyBoard() {
        TicTacToeBoard board = new TicTacToeBoard();
        Assert.assertFalse(board.isFull());
        Assert.assertNull(board.winner());
    }

    @Test public void testDraw() {
        TicTacToeBoard board = new TicTacToeBoard();
        boolean added = board.put(Mark.getCross(), 0, 0);
        added &= board.put(Mark.getCircle(), 0, 1);
        added &= board.put(Mark.getCross(), 0, 2);
        added &= board.put(Mark.getCross(), 1, 0);
        added &= board.put(Mark.getCircle(), 1, 1);
        added &= board.put(Mark.getCircle(), 1, 2);
        added &= board.put(Mark.getCircle(), 2, 0);
        added &= board.put(Mark.getCross(), 2, 1);
        added &= board.put(Mark.getCross(), 2, 2);
        Assert.assertTrue(added);
        Assert.assertTrue(board.isFull());
        Assert.assertNull(board.winner());
    }

}
