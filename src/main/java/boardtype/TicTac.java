package boardtype;

import gamestate.Board;
import gamestate.Cell;
import gamestate.Move;

public class TicTac extends Board {
    String[][] cells =new String[3][3];

    // We are creating the getCell function in TicTac class and not in Board because
    // we are not sure whether all boards have cells.
    public String getCell(int row,int column){
       // System.out.println("Getter "+"Row : "+row+" Col : "+column+" value : "+cells[row][column]);
        return cells[row][column];
    }
    public void setCell(Cell cell, String symbol){
        if (cells[cell.getRow()][cell.getCol()] == null) {
            cells[cell.getRow()][cell.getCol()] = symbol;
        } else {
            System.out.println(this);
            throw new IllegalArgumentException(cell.getRow() + " " + cell.getCol());
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result.append(cells[i][j] == null ? "-" : cells[i][j]);
            }
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public void move(Move move) {
       setCell(move.getCell(),move.getPlayer().symbol);
    }
}
