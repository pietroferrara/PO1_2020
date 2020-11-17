package it.unive.dais.po1.exercise3;

/**
 * The standing result from a tournament between some players
 */
abstract public class Standing {

    /**
     * Return the players in the order of the standing (e.g., at index 0 there is the player
     * that is first in the ranking)
     * @return the players ordered by their ranking
     */
    abstract public Player[] getStanding();

    /**
     * Returns the point of a given player
     * @param p a player
     * @return the points obtained by the given player
     */
    abstract public int getPointsOfPlayer(Player p);

    /**
     * Records the result of a played game
     * @param player1 the first player of the game
     * @param player2 the second player of the game
     * @param result the result of the game
     * @throws GameException if the game was not possible (e.g., the two players are indeed the same)
     */
    abstract public void recordResult(Player player1, Player player2, Result result) throws GameException;
}
