package LLD.Game2048.models;

 // PlayerData class
public class PlayerData {
    private String playerName;
    private int score;

    public PlayerData(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int points) {
        score += points;
    }
}