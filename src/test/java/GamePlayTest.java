import api.AIPlayer;
import api.Engine;
import api.GameRuleManager;
import gamestate.Board;
import gamestate.Cell;
import gamestate.Move;
import gamestate.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GamePlayTest {
    // Behavioural Driven Tests : How a user interacts with the system.
    AIPlayer aiPlayer;
    GameRuleManager ruleManager;
    Engine engine;

    @Before
    public void setup() { // This method is called for creating the resource at the start of the applications that is why we are creating our objects inside this.
        aiPlayer = new AIPlayer();
        ruleManager = new GameRuleManager();
        engine = new Engine();
    }

    @Test
    public void checkForRowWin() {
        Board board = engine.start("TicTac");
        // Making moves
        int[][] moves = new int[][]{{0, 0}, {1, 1}, {2, 2}}; // Instead of taking values from the user we are taking it from automatically for testing.
        System.out.println(board);
        int next = 0;
        playGame(board, moves, next);
        Assert.assertTrue(ruleManager.getState(board).getGameComplete()); // Checking whether the game is complete or not.
        Assert.assertEquals(ruleManager.getState(board).playerWon, "X"); // We are basically checking whether with the moves that we have provided, are we winning or not. The moves provided are in the moves array.
    }
    @Test
    public void checkForColWin() {
        Board board = engine.start("TicTac");
        // Making moves
        int[][] moves = new int[][]{{0, 0}, {1, 0}, {2, 0}}; // Instead of taking values from the user we are taking it from automatically for testing.
        System.out.println(board);
        int next = 0;
        playGame(board, moves, next);
        Assert.assertTrue(ruleManager.getState(board).getGameComplete()); // Checking whether the game is complete or not.
        Assert.assertEquals(ruleManager.getState(board).playerWon, "X"); // We are basically checking whether with the moves that we have provided, are we winning or not. The moves provided are in the moves array.
    }
    @Test
    public void checkForDiagonalWin() {
        Board board = engine.start("TicTac");
        // Making moves
        int[][] moves = new int[][]{{0, 0}, {1, 1}, {2, 2}}; // Instead of taking values from the user we are taking it from automatically for testing.
        System.out.println(board);
        int next = 0;
        playGame(board, moves, next);
        Assert.assertTrue(ruleManager.getState(board).getGameComplete()); // Checking whether the game is complete or not.
        Assert.assertEquals(ruleManager.getState(board).playerWon, "X"); // We are basically checking whether with the moves that we have provided, are we winning or not. The moves provided are in the moves array.
    }
    @Test
    public void checkForReverseDiagonalWin() {
        Board board = engine.start("TicTac");
        // Making moves
        int[][] moves = new int[][]{{0, 2}, {1,1}, {2, 0}}; // Instead of taking values from the user we are taking it from automatically for testing.
        System.out.println(board);
        int next = 0;
        playGame(board, moves, next);
        Assert.assertTrue(ruleManager.getState(board).getGameComplete()); // Checking whether the game is complete or not.
        Assert.assertEquals(ruleManager.getState(board).playerWon, "X"); // We are basically checking whether with the moves that we have provided, are we winning or not. The moves provided are in the moves array.
    }
    @Test
    public void checkForComputerWin() {
        Board board = engine.start("TicTac");
        // Making moves
        int[][] moves = new int[][]{{1, 2}, {2,0}, {1, 1}}; // Instead of taking values from the user we are taking it from automatically for testing.
        System.out.println(board);
        int next = 0;
        playGame(board, moves, next);
        Assert.assertTrue(ruleManager.getState(board).getGameComplete()); // Checking whether the game is complete or not.
        Assert.assertEquals(ruleManager.getState(board).playerWon, "0"); // We are basically checking whether with the moves that we have provided, are we winning or not. The moves provided are in the moves array.
    }

    private void playGame(Board board, int[][] moves, int next) {
        while (!ruleManager.getState(board).getGameComplete()) {
            Player computer = new Player("0"), human = new Player("X");
            System.out.println("Make your move!");
            int row = moves[next][0];
            int col = moves[next][1];
            next++;
            Move humanMove = new Move(new Cell(row, col), human);
            engine.move(board, humanMove);
            System.out.println(board);
            if (!ruleManager.getState(board).getGameComplete()) {
                Move compMove = aiPlayer.suggestMove(board, computer);
                engine.move(board, compMove);
            }
        }
    }
}
