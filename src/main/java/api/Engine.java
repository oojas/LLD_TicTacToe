package api;

import boardtype.TicTac;
import gamestate.Board;
import gamestate.Move;
// A game engine is only responsible for starting the game and making moves. Checking whether someone has won or suggesting move is managed by GameManager
public class Engine {


    // This is the start point of the game.
    public Board start(String type){
        if(type.equalsIgnoreCase("TicTac")){
            return new TicTac();
        }else{
            throw new IllegalArgumentException();
        }

    }

    // Players will make a move here
    // Player is a User who is making a move
    public void move(Board board, Move move) {

        if(board instanceof TicTac board1){
            board1.move(move); // We have declared our move function in TicTacToe class because this api belongs to TicTacToe.
        }else{
            throw new IllegalArgumentException();
        }
    }

}