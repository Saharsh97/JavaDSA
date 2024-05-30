package LLD.Game2048.service;

import LLD.Game2048.models.GameObserver;

public class ScoreManager implements GameObserver {
    private int score;

    public void update(int[][] board) {
        // Update the score based on the current state of the board
        // For simplicity, let's assume the score is the sum of all tile values
        score = calculateScore(board);
        // Notify UI or other components about the score change
        System.out.println("Score Updated: " + score);
    }

    private int calculateScore(int[][] board) {
        int totalScore = 0;
        for (int[] row : board) {
            for (int cell : row) {
                totalScore += cell;
            }
        }
        return totalScore;
    }

    public int getScore() {
        return score;
    }
}
