package api;

import boardtype.TicTac;
import gamestate.Board;
import gamestate.Cell;
import gamestate.Move;
import gamestate.Player;

public class AIPlayer {

    public Move suggestMove(Board board, Player computer){
        if(board instanceof TicTac ticTac){
            for(int i=0 ; i<3 ; i++)
            {
                for(int j=0 ; j<3 ; j++)
                {
                    if(ticTac.getCell(i,j)==null){
                        return new Move(new Cell(i,j),computer);
                    }
                }
            }
            throw new IllegalArgumentException();
        }else{
            throw new IllegalArgumentException();
        }
    }
}
