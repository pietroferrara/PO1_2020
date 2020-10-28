package it.unive.dais.po1.exercise2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
    public static Mark playGame(Player player1, Player player2, Board board) {
        System.out.println("Board at the beginning:");
        print(board);
        int i = 0;
        while(true) {
            i++;
            boolean round;
            if(board.isFull()) {
                System.out.println("The board is full!");
                return null;
            }
            if(i%2==0)
                round = player1.play(board);
            else round = player2.play(board);
            if(! round) {
                System.out.println("Player "+((i%2)+1)+" refusing to play, terminating the game");
                return null;
            }
            System.out.println("Board after round "+i);
            print(board);
            Mark winner = board.winner();
            if(winner!=null)
                return winner;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String matricola = args[0];
        Class<?> clgb = Class.forName("it.unive.dais.po1.exercise2.m"+matricola+".GomokuBoard");
        Constructor<?> consgb = clgb.getConstructor(int.class);
        Board board = (Board) consgb.newInstance(15);
        Class<?> clp = Class.forName("it.unive.dais.po1.exercise2.m"+matricola+".Player");
        Constructor<?> consp = clp.getConstructor(Mark.class);
        Player player_circle = (Player) consp.newInstance(Mark.getCircle());
        Player player_cross = (Player) consp.newInstance(Mark.getCross());

        Mark result = playGame(player_circle, player_cross, board);
        if(result!=null)
            System.out.println("The winner is "+(result== Mark.getCircle() ? "player 1" : "player 2"));
        else System.out.println("Draw!");
    }

    /**
     * Prints on the standard output the status of the board
     * @param board the board to be printed
     */
    public static void print(Board board) {
        for(int x = 0; x < board.getDimension(); x++) {
            for (int y = 0; y < board.getDimension(); y++) {
                Mark s = board.getMark(x, y);
                System.out.print((s== null ? " e " : (s== Mark.getCircle()? " O " : " X " )));
            }
            System.out.print("\n");
        }
    }

}
