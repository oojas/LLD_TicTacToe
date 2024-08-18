package api;

import boardtype.TicTac;
import gamestate.Board;
import gamestate.GameResult;

public class GameRuleManager {
    // This will tell whether the game is completed and who has won the game.
    // Receives the board object to check whether the game is completed or not
    public GameResult getState(Board board){
        if(board instanceof TicTac board1){
            boolean rowComplete=true;
            String firstCharacter="-";
            for(int i=0 ; i<3 ; i++) {
                firstCharacter = board1.getCell(i, 0);
                rowComplete = firstCharacter != null;
                if (firstCharacter != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(board1.getCell(i, j))) {
                            rowComplete = false;
                            break;
                        }
                    }
                }
                if(rowComplete){
                    return new GameResult(rowComplete, firstCharacter);
                }
            }

            boolean colComplete=true;
            for(int i=0 ; i<3 ; i++) {
                firstCharacter = board1.getCell(0, i);
                colComplete = firstCharacter != null;
                if (firstCharacter != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(board1.getCell(j, i))) {
                            colComplete = false;
                            break;
                        }
                    }
                }
                if(colComplete){
                    return new GameResult(colComplete, firstCharacter);
                }
            }

            boolean diagComplete=true;
            for(int i=0 ; i<3 ; i++) {
                firstCharacter = board1.getCell(0, 0);
                diagComplete = firstCharacter != null;
                if (firstCharacter != null) {
                    if (!firstCharacter.equals(board1.getCell(i, i))) {
                        diagComplete = false;
                        break;
                    }
                }
            }
            if(diagComplete){
                return new GameResult(diagComplete, firstCharacter);
            }


            boolean revDiagComplete=true;
            for(int i=0 ; i<3 ; i++) {
                firstCharacter = board1.getCell(0, 2);
                revDiagComplete = firstCharacter != null;
                if (firstCharacter != null) {
                    if (!firstCharacter.equals(board1.getCell(i, 2 - i))) {
                        revDiagComplete = false;
                        break;
                    }
                }

            }
            if(revDiagComplete){
                return new GameResult(revDiagComplete, firstCharacter);
            }

            int count=0;
            for(int i=0 ; i<3 ; i++)
            {
                for(int j=0 ; j<3 ; j++)
                {
                    if(board1.getCell(i,j)!=null)count++;
                }
            }
            if(count==9){
                return new GameResult(true,"-");
            }else{
                return new GameResult(false,"-");
            }
        }
        return new GameResult(false, "-");
    }
}
