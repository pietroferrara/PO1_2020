package it.unive.dais.po1.exercise3;


/**
 * This class represents a game between two players on a given board
 *
 * @author Pietro Ferrara
 * @since 1.0
 */
final public class Game {
    protected Player playerCross, playerCircle;
    protected Board board;

    public Game(Player playerCross, Player playerCircle, Board board) throws GameException {
        if(playerCircle.equals(playerCross))
            throw new GameException("A player cannot play against itself");
        this.board = board.clone();
        this.playerCircle = playerCircle;
        this.playerCross = playerCross;
    }

    /**
     * Plays a whole game
     * @return the results of the game
     * @throws GameException if one of the two players does not play the game correctly
     */
    public Result play() throws GameException {
        System.out.println("Board at the beginning:");
        System.out.println(board.toString());
        int i = 0;
        while(true) {
            i++;
            Board previous = board.clone();
            if(board.isFull()) {
                System.out.println("The board is full!");
                return null;
            }
            Mark mark = i%2==0 ? Mark.getCross() : Mark.getCircle();
            if(mark==Mark.getCross())
                try {
                    playerCross.play(board, mark);
                }
                catch(GameException e) {
                    System.err.println("Player "+playerCross.getIdentifier()+" failed to play");
                    return Result.player2;
                }
            else
                try {
                    playerCircle.play(board, mark);
                }
                catch(GameException e) {
                    System.err.println("Player "+playerCircle.getIdentifier()+" failed to play");
                    return Result.player1;
                }
            System.out.println("Board after round "+i);
            System.out.println(board.toString());
            if(!board.isValidMove(previous, mark))
                throw new GameException("Illegal move");
            Mark winner = board.winner();
            if(winner==Mark.getCross())
                return Result.player1;
            else if(winner==Mark.getCircle())
                return Result.player2;
        }
    }

    /**
     * Returns the first player of the game
     * @return the first player of the game
     */
    public Player getPlayer1() {
        return playerCross;
    }


    /**
     * Returns the second player of the game
     * @return the second player of the game
     */
    public Player getPlayer2() {
        return playerCircle;
    }
}
