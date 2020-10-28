package it.unive.dais.po1.exercise2;

import org.junit.Assert;
import org.junit.Test;

public class TestPlayer {

    @Test public void testFullGame() {
        Game.playGame(ClassProvider.getPlayerCircle(), ClassProvider.getPlayerCross(), ClassProvider.getBoard());
    }

    @Test public void testSingleRounds() {
        Player player1 = ClassProvider.getPlayerCircle();
        Player player2 = ClassProvider.getPlayerCross();
        Board board = ClassProvider.getBoard();
        boolean added = true;
        int i = 0;
        while(added) {
            if(i%2==0)
                added = player1.play(board);
            else
                added = player2.play(board);
            if(added) {
                Assert.assertEquals(i+1, countFullCells(board));
                Assert.assertEquals(i / 2 + 1, countCircleCells(board));
                Assert.assertEquals(i / 2 + i % 2, countCrossCells(board));
                i = i+1;
            }
        }
        Assert.assertTrue(board.winner()!=null || board.isFull());
    }

    private int countFullCells(Board board) {
        int count = 0;
        for(int x = 0; x < board.getDimension(); x++)
            for(int y = 0; y < board.getDimension(); y++)
                if(board.getMark(x, y)!=null)
                    count++;
        return count;
    }
    private int countCrossCells(Board board) {
        int count = 0;
        for(int x = 0; x < board.getDimension(); x++)
            for(int y = 0; y < board.getDimension(); y++)
                if(board.getMark(x, y)== Mark.getCross())
                    count++;
        return count;
    }
    private int countCircleCells(Board board) {
        int count = 0;
        for(int x = 0; x < board.getDimension(); x++)
            for(int y = 0; y < board.getDimension(); y++)
                if(board.getMark(x, y)== Mark.getCircle())
                    count++;
        return count;
    }


}
