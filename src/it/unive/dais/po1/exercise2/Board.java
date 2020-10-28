package it.unive.dais.po1.exercise2;

/**
 * This class represents a generic board
 *
 * @since 1.0
 */
abstract public class Board {
    private Mark[][] board;

    /**
     * Creates a square board
     * @param dimension the dimension of the square board
     */
    public Board(int dimension) {
        board = new Mark[dimension][dimension];
    }


    /**
     * Puts a mark in a given cell
     *
     * @param c the mark to put in the board
     * @param x the x coordinate of the cell to be filled
     * @param y the y coordinate of the cell to be filled
     * @return true if the mark is not null, the cell is empty,
     * the game is not ended (e.g., no winner yet) and
     * it fills it, false otherwise
     */
    public boolean putMark(Mark c, int x, int y) {
        Mark previous = this.getMark(x, y);
        if(previous!=null || this.winner()!=null || c==null)
            return false;
        board[x][y]=c;
        return true;
    }

    /**
     * Returns the mark of a cell, null if empty
     * @param x the x coordinate of the cell
     * @param y the y coordinate of the cell
     * @return the mark in the given cell, null if the cell is empty
     */
    public Mark getMark(int x, int y) {
        return board[x][y];
    }

    /**
     * Returns the dimension of the square board
     * @return the dimension of the square board
     */
    public int getDimension() {
        return board.length;
    }

    /**
     * Returns the winner of the game
     *
     * @return the mark of the winner of the game, or null if there is not yet a winner
     */
    abstract public Mark winner();

    /**
     * Returns true if the board is full
     *
     * @return true iff the board is full
     */
    public boolean isFull() {
        for(int x = 0; x < board.length; x++)
            for(int y = 0; y < board.length; y++)
                if(this.getMark(x, y)==null)
                    return false;
        return true;
    }
}
