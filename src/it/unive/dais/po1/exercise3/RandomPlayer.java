package it.unive.dais.po1.exercise3;

import java.util.Random;

public class RandomPlayer extends Player {

    @Override
    public void play(Board board, Mark mark) throws GameException {
        double dimension = board.getDimension();
        if(board.isFull() || board.winner()!=null)
            throw new GameException("Full board");
        if(board.winner()!=null)
            throw new GameException("There is already a winner (mark "+board.winner()+")");
        while(true) {
            int x = (int) (Math.random()*dimension);
            int y = (int) (Math.random()*dimension);
            if(board.getMark(x, y)==null) {
                board.putMark(mark, x, y);
                return;
            }
        }
    }

    @Override
    public String getIdentifier() {
        return "RandomPlayer";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof RandomPlayer;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
