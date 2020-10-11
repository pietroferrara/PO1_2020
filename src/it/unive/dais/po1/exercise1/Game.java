package it.unive.dais.po1.exercise1;

/**
 * This class contains some utilities to run the implementation of the game and debug it.
 *
 * @author Pietro Ferrara
 * @since 1.0
 */
public class Game {

    /**
     * Plays a whole game
     * @return the mark of the winner, or null if the game resulted in a draw
     */
    public static Mark playGame() {
        Player player1 = new Player(Mark.getCircle());
        Player player2 = new Player(Mark.getCross());
        TicTacToeBoard board = new TicTacToeBoard();
        System.out.println("Board at the beginning:");
        print(board);
        for(int i = 0; i < 9; i++) {
            boolean round;
            if(i%2==0)
                round = player1.play(board);
            else round = player2.play(board);
            if(! round) {
                System.out.println("Player "+((i%2)+1)+"refusing to play, terminating the game");
                return null;
            }
            System.out.println("Board after round "+i);
            print(board);
            Mark winner = board.winner();
            if(winner!=null)
                return winner;
        }
        return null;
    }

    public static void main(String[] args) {
        Mark result = playGame();
        if(result!=null)
            System.out.println("The winner is "+(result==Mark.getCircle() ? "player 1" : "player 2"));
        else System.out.println("Draw!");
    }

    /**
     * Prints on the standard output the status of the board
     * @param board the board to be printed
     */
    public static void print(TicTacToeBoard board) {
        for(int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Mark s = board.getMark(x, y);
                System.out.print((s== null ? " e " : (s==Mark.getCircle()? " O " : " X " )));
            }
            System.out.print("\n");
        }
    }

}
