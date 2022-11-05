package h01;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;
import org.tudalgo.algoutils.student.Student;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.tudalgo.algoutils.student.Student.crash;
import static org.tudalgo.algoutils.student.io.PropertyUtils.getIntProperty;

/**
 * {@link Checkers} is a simplified version of Checkers, implemented in FOPBot.
 */
public class Checkers {

    /**
     * The number of rows in the game board.
     */
    public static final int NUMBER_OF_ROWS = getIntProperty("checkers.properties", "NUMBER_OF_ROWS");

    /**
     * The number of columns in the game board.
     */
    public static final int NUMBER_OF_COLUMNS = getIntProperty("checkers.properties", "NUMBER_OF_COLUMNS");

    /**
     * The minimum initial number of coins for a black stone.
     */
    public static final int MIN_NUMBER_OF_COINS = getIntProperty("checkers.properties", "MIN_NUMBER_OF_COINS");

    /**
     * The maximum initial number of coins for a black stone.
     */
    public static final int MAX_NUMBER_OF_COINS = getIntProperty("checkers.properties", "MAX_NUMBER_OF_COINS");

    /**
     * The current state of the game.
     * At the start of the game, the state of the game is set to {@link GameState#RUNNING}.
     * After the game has finished, the state of the game is set to {@link GameState#BLACK_WIN} or {@link GameState#WHITE_WIN}.
     */
    private GameState gameState = GameState.RUNNING;


    /**
     * The robot of the white team.
     */
    private Robot whiteStone;

    /**
     * The robots of the black team.
     */
    private Robot blackStone0, blackStone1, blackStone2, blackStone3, blackStone4;

    /**
     * Runs the initialization of the game.
     * The initialization of the game consists of the initialization of the world and all stones.
     */
    public void initGame() {
        Student.setCrashEnabled(false);
        // initialize the world
        World.setSize(NUMBER_OF_COLUMNS, NUMBER_OF_ROWS);
        // initialize all stones
        initWhiteStone();
        initBlackStones();
    }

    /**
     * Runs the game. After the game has finished, the winner of the game will be printed to the console.
     */
    public void runGame() {
        World.setVisible(true);
        while (isRunning()) {
            doBlackTeamActions();
            doWhiteTeamActions();
            updateGameState();
        }
        System.out.printf("Final State: %s%n", gameState);
    }

    /**
     * Returns {@code true} if the game is running, {@code false} otherwise.
     *
     * @return if the game is running
     */
    public boolean isRunning() {
        return gameState == GameState.RUNNING;
    }

    /**
     * Runs the initialization of the white stone.
     */
    public void initWhiteStone() {
        // Random coordinates
        int x;
        int y;
        do {
            // Generate random coordinates between 0 and NUMBER_OF_COLUMNS - 1 for the x coordinate
            // and between 0 and NUMBER_OF_ROWS - 1 for the y coordinate.
            // nextInt(bound) returns a random integer between 0 (inclusive) and bound (exclusive)
            x = ThreadLocalRandom.current().nextInt(NUMBER_OF_COLUMNS);
            y = ThreadLocalRandom.current().nextInt(NUMBER_OF_ROWS);
        }
        // Sum of x and y must be odd
        while ((x + y) % 2 == 0);

        // Random direction, map int to Direction
        int randomDirection = ThreadLocalRandom.current().nextInt(4);
        Direction direction;
        if (randomDirection == 0) {
            direction = Direction.UP;
        } else if (randomDirection == 1) {
            direction = Direction.RIGHT;
        } else if (randomDirection == 2) {
            direction = Direction.DOWN;
        } else {
            // Since the interval is between [0,4], we do not have to explicit check randomDirection == 4
            direction = Direction.LEFT;
        }

        whiteStone = new Robot(x, y, direction, 0);
    }

    /**
     * Runs the initialization of all black stones.
     */
    public void initBlackStones() {
        crash(); // TODO: H1.2 - remove if implemented
    }

    /**
     * Runs the action of the black team.
     */
    public void doBlackTeamActions() {
        crash(); // TODO: H2.1 - remove if implemented
    }

    /**
     * Runs the action of the white team.
     */
    public void doWhiteTeamActions() {
        crash(); // TODO: H2.2 - remove if implemented
    }

    /**
     * Checks if a team has won the game and, if so, updates the game state to {@link GameState#BLACK_WIN} or {@link GameState#WHITE_WIN}.
     */
    public void updateGameState() {
        crash(); // TODO: H2.3 - remove if implemented
    }

    /**
     * Returns an instance of {@link Random}.
     *
     * @return an instance of {@link Random}
     */
    private Random getRandom() {
        return ThreadLocalRandom.current();
    }

}
