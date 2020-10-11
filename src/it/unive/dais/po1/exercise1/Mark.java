package it.unive.dais.po1.exercise1;

/**
 * This class represents a mark in the tic-tac-toe board.
 *
 * @author Pietro Ferrara
 * @since 1.0
 */
public class Mark {
    private int status;

    private static final Mark CIRCLE = new Mark(0), CROSS = new Mark(1);

    private Mark(int status) {
        this.status = status;
    }

    /**
     * Returns the object representing a circle in the board
     * @return the Mark instance representing a circle
     */
    public static Mark getCircle() {
        return CIRCLE;
    }

    /**
     * Returns the object representing a cross in the board
     * @return the Mark instance representing a cross
     */
    public static Mark getCross() {
        return CROSS;
    }

}
