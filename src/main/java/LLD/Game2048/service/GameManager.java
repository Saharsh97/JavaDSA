package LLD.Game2048.service;

import LLD.Game2048.models.Direction;
import LLD.Game2048.models.GameObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Singleton Pattern
public class GameManager {
    private static GameManager instance;
    private int[][] board;
    private List<GameObserver> observers;

    private GameManager() {
        // Private constructor to prevent instantiation
        initializeBoard();
        observers = new ArrayList<>();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    private void initializeBoard() {
        // Initialize the game board
        board = new int[4][4];
        addRandomTile();
        addRandomTile();
    }

    private void addRandomTile() {
        // Add a new tile (2 or 4) to a random empty cell
        Random random = new Random();
        int value = (random.nextInt(2) + 1) * 2; // Either 2 or 4
        int row, col;

        do {
            row = random.nextInt(4);
            col = random.nextInt(4);
        } while (board[row][col] != 0);

        board[row][col] = value;
    }

    public void move(Direction direction) {
        // Handle the move logic (left, right, up, down)
        // ...
        // After each move, add a new tile
        addRandomTile();
        notifyObservers(); // Notify observers about the board update
    }

    public int[][] getBoard() {
        return board;
    }

    // Observer Pattern
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update(board);
        }
    }
}
