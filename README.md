# TicTacToe API Documentation

This API provides the structure and functionality to implement a TicTacToe game, with components for managing game logic, player moves, and game states.

## 1. AIPlayer
The `AIPlayer` class is responsible for suggesting moves to the computer player.

- **suggestMove:**  
  Suggests the best move for the computer player based on the current game state.

## 2. Engine
The `Engine` class is where the game initiates and moves are processed.

- **start:**  
  Checks if the game to be started is a TicTacToe game. If true, it returns a `TICTACTOE` object to begin the game.

- **move:**  
  Processes and stores a move in the game board's cells.

## 3. GameRuleManager
The `GameRuleManager` class handles the validation of moves and determines the outcome of the game.

- **getGameState:**  
  Validates moves and checks the current state of the game, including whether a player has won, lost, or if the game is tied.

## 4. TicTac
The `TicTac` class represents the TicTacToe game board and extends the abstract `Board` class.

- **Cell:**  
  An object reference for a cell on the board.

- **cells[]:**  
  An array where all moves are stored.

- **setCell:**  
  Stores legal moves that have been made on the board.

- **move:**  
  Inherited from the `Board` class, this method stores moves on the game board.

- **toString:**  
  Overrides the default method to visualize the current state of the board and the moves made.

## 5. Board
The `Board` class is an abstract class representing the concept of a game board. It is designed to be extended by specific game boards like TicTacToe or Chess.

- **move():**  
  Abstract method that must be implemented by subclasses to handle how moves are made on different types of boards.

## 6. Cell
The `Cell` class defines the structure of a cell on the board, with members representing its row and column.

## 7. GameResult
The `GameResult` class tracks the outcome of the game.

- **playerWon:**  
  Indicates which player won the game.

- **isComplete:**  
  Indicates whether the game is complete.

## 8. Move
The `Move` class defines how a move is made within the game.

- **Player:**  
  A member of type `Player`, indicating which player made the move.

- **cell:**  
  Indicates which cell the move was made on.

## 9. Player
The `Player` class defines the players in the game.

- **symbol:**  
  Represents whether the player is "X" or "O".
