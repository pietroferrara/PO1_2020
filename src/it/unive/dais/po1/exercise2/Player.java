package it.unive.dais.po1.exercise2;

/**
 * This class represents a player of the game
 *
 * @since 1.0
 */
abstract public class Player {

    protected Mark ownMark;

    /**
     * Intializes a player using the given Mark
     * @param mark the mark of the player
     */
    public Player(Mark mark) {
        this.ownMark = mark;
    }

    /**
     * Plays a round of the game.
     *
     * @param board
     * @return true if the player was able to
     */
    abstract public boolean play(Board board);
}
