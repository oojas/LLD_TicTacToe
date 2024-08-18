package gamestate;
// this class is abstract because the board can be any board basically the board can be a chess board or a tic tac toe board.
// and the move function also depends on the type of move made. A chess move can be completely different from a tic tac toe move.
public abstract class Board {
    public abstract void move(Move move);
}
