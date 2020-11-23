package it.unive.dais.po1.exercise3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class TestPlayer {

    @Test public void testFullGame() throws GameException {
        new Game(ClassProvider.getPlayer(), new RandomPlayer(), ClassProvider.getBoard()).play();
    }

    @Test public void testSingleRounds() {
        Player player1 = ClassProvider.getPlayer();
        Player player2 = new RandomPlayer();
        Board board = ClassProvider.getBoard();
        boolean added = true;
        int i = 0;
        while(true) {
            try {
                if (i % 2 == 0)
                    player1.play(board, Mark.getCross());
                else
                    player2.play(board, Mark.getCircle());
            }
            catch(GameException e) {
                break;
            }
            Assert.assertEquals(i+1, countFullCells(board));
            Assert.assertEquals(i / 2 + i % 2, countCircleCells(board));
            Assert.assertEquals(i / 2 + 1, countCrossCells(board));
            i = i+1;
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
