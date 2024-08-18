package gamestate;

public class GameResult{
    public boolean getGameComplete() {
       return !gameComplete;
    }

   public  boolean gameComplete;
    public String playerWon;

    public GameResult(boolean isComplete,String playerWon) {
        this.gameComplete = isComplete;
        this.playerWon = playerWon;
    }

}
