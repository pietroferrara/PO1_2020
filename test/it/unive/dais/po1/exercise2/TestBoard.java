package it.unive.dais.po1.exercise2;

import org.junit.Assert;
import org.junit.Test;

public class TestBoard {

    @Test public void testBoardDiagonalCircle() {
        Board board = ClassProvider.getBoard();
        boolean added = board.putMark(Mark.getCircle(), 0, 0);
        added &= board.putMark(Mark.getCircle(), 1, 1);
        added &= board.putMark(Mark.getCircle(), 2, 2);
        added &= board.putMark(Mark.getCircle(), 3, 3);
        added &= board.putMark(Mark.getCircle(), 4, 4);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCircle(), board.winner());
    }

    @Test public void testFillCellTwice() {
        Board board = ClassProvider.getBoard();
        boolean added = board.putMark(Mark.getCircle(), 0, 0);
        Assert.assertTrue(added);
        added =  board.putMark(Mark.getCircle(), 0, 0);
        Assert.assertFalse(added);
    }

    @Test public void testBoardDiagonalCross() {
        Board board = ClassProvider.getBoard();
        boolean added = board.putMark(Mark.getCross(), 4, 0);
        added &= board.putMark(Mark.getCross(), 3, 1);
        added &= board.putMark(Mark.getCross(), 2, 2);
        added &= board.putMark(Mark.getCross(), 1, 3);
        added &= board.putMark(Mark.getCross(), 0, 4);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCross(), board.winner());
    }


    @Test public void testBoardHorizontalCircle() {
        Board board = ClassProvider.getBoard();
        boolean added = board.putMark(Mark.getCircle(), 0, 1);
        added &= board.putMark(Mark.getCircle(), 1, 1);
        added &= board.putMark(Mark.getCircle(), 2, 1);
        added &= board.putMark(Mark.getCircle(), 3, 1);
        added &= board.putMark(Mark.getCircle(), 4, 1);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCircle(), board.winner());
    }

    @Test public void testBoardHorizontalCross() {
        Board board = ClassProvider.getBoard();
        boolean added = board.putMark(Mark.getCross(), 0, 0);
        added &= board.putMark(Mark.getCross(), 1, 0);
        added &= board.putMark(Mark.getCross(), 2, 0);
        added &= board.putMark(Mark.getCross(), 3, 0);
        added &= board.putMark(Mark.getCross(), 4, 0);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCross(), board.winner());
    }



    @Test public void testBoardVerticalCircle() {
        Board board = ClassProvider.getBoard();
        boolean added = board.putMark(Mark.getCircle(), 1, 0);
        added &= board.putMark(Mark.getCircle(), 1, 1);
        added &= board.putMark(Mark.getCircle(), 1, 2);
        added &= board.putMark(Mark.getCircle(), 1, 3);
        added &= board.putMark(Mark.getCircle(), 1, 4);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCircle(), board.winner());
    }

    @Test public void testBoardVerticalCross() {
        Board board = ClassProvider.getBoard();
        boolean added = board.putMark(Mark.getCross(), 2, 0);
        added &= board.putMark(Mark.getCross(), 2, 1);
        added &= board.putMark(Mark.getCross(), 2, 2);
        added &= board.putMark(Mark.getCross(), 2, 3);
        added &= board.putMark(Mark.getCross(), 2, 4);
        Assert.assertTrue(added);
        Assert.assertEquals(Mark.getCross(), board.winner());
    }

    @Test public void testEmptyBoard() {
        Board board = ClassProvider.getBoard();
        Assert.assertFalse(board.isFull());
        Assert.assertNull(board.winner());
    }

}
