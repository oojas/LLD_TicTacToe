import api.AIPlayer;
import api.Engine;
import api.GameRuleManager;
import gamestate.Board;
import gamestate.Cell;
import gamestate.Move;
import gamestate.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Engine eng=new Engine();
        Board board=eng.start("TicTac");
        Scanner sc=new Scanner(System.in);
        AIPlayer aiPlayer=new AIPlayer();
        GameRuleManager ruleManager=new GameRuleManager();
        // Making moves
        System.out.println(board);
        while(!ruleManager.getState(board).getGameComplete()){
            Player computer=new Player("0"),human=new Player("X");
            System.out.println("Make your move!");
            int row=sc.nextInt();
            int col=sc.nextInt();
            Move humanMove=new Move(new Cell(row,col),human);
            eng.move(board,humanMove);
            System.out.println(board);
            if(!ruleManager.getState(board).getGameComplete()){
                Move compMove=aiPlayer.suggestMove(board,computer);
                eng.move(board,compMove);
            }
        }
        System.out.println("Game Ended " + " PLayer won : "+ruleManager.getState(board).playerWon);
    }
}