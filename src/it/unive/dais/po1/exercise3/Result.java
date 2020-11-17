package it.unive.dais.po1.exercise3;

/**
 * The result of a game
 */
public class Result {
    /**
     * A draw, where happening when none of the players won
     */
    public final static Result draw = new Result();

    /**
     * The winner is the first player of a game
     */
    public final static Result player1 = new Result();

    /**
     * The winner is the second player of a game
     */
    public final static Result player2 = new Result();
}
