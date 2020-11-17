package it.unive.dais.po1.exercise3;

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

    @Override
    public String toString() {
        if(this==CIRCLE)
            return "O";
        if(this==CROSS)
            return "X";
        throw new UnsupportedOperationException("A mark can be only a circle or a cross");
    }
}
