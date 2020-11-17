package it.unive.dais.po1.exercise3;

/**
 * This class represents a player of the game
 *
 * @since 1.0
 */
abstract public class Player {

    /**
     * Plays a round of the game.
     *
     * @param board
     * @throws GameException if the player was not able to play (e.g., because the board was already full)
     */
    abstract public void play(Board board, Mark mark) throws GameException;

    /**
     * Returns the identifier of a player. Two players that have the same identifier must be equals.
     * @return a string representing the identifier of the player
     */
    abstract public String getIdentifier();

    final public String toString() {
        return this.getIdentifier();
    }
}
