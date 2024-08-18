package gamestate;

public class Player {
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

   public  String symbol;
    public Player(String symbol){
        this.symbol=symbol;
    }
}
