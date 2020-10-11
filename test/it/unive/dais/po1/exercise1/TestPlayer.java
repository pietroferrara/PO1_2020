package it.unive.dais.po1.exercise1;

import org.junit.Assert;
import org.junit.Test;

public class TestPlayer {

    @Test public void testFullGame() {
        Game.playGame();
    }

    @Test public void testSingleRounds() {
        Player player1 = new Player(Mark.getCircle());
        Player player2 = new Player(Mark.getCross());
        TicTacToeBoard board = new TicTacToeBoard();
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

    private int countFullCells(TicTacToeBoard board) {
        int count = 0;
        for(int x = 0; x < 3; x++)
            for(int y = 0; y < 3; y++)
                if(board.getMark(x, y)!=null)
                    count++;
        return count;
    }
    private int countCrossCells(TicTacToeBoard board) {
        int count = 0;
        for(int x = 0; x < 3; x++)
            for(int y = 0; y < 3; y++)
                if(board.getMark(x, y)== Mark.getCross())
                    count++;
        return count;
    }
    private int countCircleCells(TicTacToeBoard board) {
        int count = 0;
        for(int x = 0; x < 3; x++)
            for(int y = 0; y < 3; y++)
                if(board.getMark(x, y)== Mark.getCircle())
                    count++;
        return count;
    }


}
