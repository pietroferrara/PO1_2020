package it.unive.dais.po1.exercise3;

import java.util.*;

/**
 * A tournament played among some players
 *
 * @since 1.0
 */
abstract public class Tournament {
    protected final Collection<Player> players;
    protected final Board board;


    /**
     * Build up a tournament
     * @param players the players involved in the tournament
     * @param board the board to play the tournament
     * @param drawPoints number of points to be given to a player for a draw
     * @param winPoints number of points to be given to a player for a win
     * @throws GameException
     */
    public Tournament(Collection<Player> players, Board board, int drawPoints, int winPoints) throws GameException {
        this.board = board;
        this.players = players;
    }

    /**
     * Plays the tournament and returns the standing
     * @return the standing of the tournament
     * @throws GameException if something goes wrong while playing the tournament
     */
    abstract public Standing play() throws GameException;

}
