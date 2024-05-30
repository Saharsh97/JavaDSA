package LLD.Game2048;

import LLD.Game2048.models.Direction;
import LLD.Game2048.models.PlayerData;
import LLD.Game2048.models.commands.CommandFactory;
import LLD.Game2048.models.commands.MoveCommand;
import LLD.Game2048.service.GameManager;
import LLD.Game2048.service.ScoreManager;

public class Game2048 {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();

        // Observer Pattern
        ScoreManager scoreManager = new ScoreManager();
        gameManager.addObserver(scoreManager);

        // Player Data
        PlayerData player = new PlayerData("Player1");

        // Command Pattern
        CommandFactory commandFactory = new CommandFactory();
        MoveCommand moveLeftCommand = commandFactory.createCommand(Direction.LEFT);
        MoveCommand moveRightCommand = commandFactory.createCommand(Direction.RIGHT);

        // Execute commands
        moveLeftCommand.execute();
        moveRightCommand.execute();

        // Get the current state of the board
        int[][] currentBoard = gameManager.getBoard();

        // Print the board
        for (int[] row : currentBoard) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

        // Observer Pattern: Update the score
        System.out.println("Current Score: " + scoreManager.getScore());

        // Update player data based on the score
        player.updateScore(scoreManager.getScore());
        System.out.println("Player Score: " + player.getScore());
    }
}
