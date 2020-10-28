package it.unive.dais.po1.exercise2;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassProvider {
    private static final String matricola = "784578";
    private static Constructor<?> constructorBoard;
    private static Player player_circle, player_cross;

    static {
        try {
            Class<?> clgb = Class.forName("it.unive.dais.po1.exercise2.m"+matricola+".GomokuBoard");
            constructorBoard = clgb.getConstructor(int.class);
            Board trial = (Board) constructorBoard.newInstance(15);
            Class<?> clp = Class.forName("it.unive.dais.po1.exercise2.m"+matricola+".Player");
            Constructor<?> consp = clp.getConstructor(Mark.class);
            player_circle = (Player) consp.newInstance(Mark.getCircle());
            player_cross = (Player) consp.newInstance(Mark.getCross());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.err.println("Failure while loading the classes, probably the given matricola ("+matricola+") is wrong, or the name of the classes you implemented are not complaint with the given specification (Player and GomokuBoard in package it.unive.dais.po1.exercise2.m<matricola>");
            e.printStackTrace();
        }
    }

    public static Board getBoard() {
        try {
            return (Board) constructorBoard.newInstance(15);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.err.println("Impossible to create a board");
            return null;
        }
    }

    public static Player getPlayerCross() {
        return player_cross;
    }

    public static Player getPlayerCircle() {
        return player_circle;
    }

}
