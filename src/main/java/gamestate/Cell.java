package gamestate;

public class Cell {
    int row;

    public int getCol() {
        return col;
    }


    public int getRow() {
        return row;
    }

    int col;
   public  Cell(int row,int col){
        this.row=row;
        this.col=col;
    }
}
