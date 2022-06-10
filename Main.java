//Nestor Alfaro | 04/26/2021
import source.logic.Game;
import source.logic.Result;
import source.io.io;

public class Main {
    public static void main(String[] args) {

        //Create new game
        Game game = new Game();
        //Enter ships
        game.setShips(io.enterShips());
        //Display board
        io.displayBoard(game.pieces.board);
        //while still playing
        while ((game.shoot(io.enterShot())) & (!(game.over()))){
            //display feedback of the shot
            io.displayFeedback(game.pieces.board, game.pieces.cannon);
            //display board
            io.displayBoard(game.pieces.board);
        }
        //if the game is over
        if (((game.over()))) {
            //if it won, display the board one more time
            if (game.result.equals(Result.WIN)) {
                io.displayFeedback(game.pieces.board, game.pieces.cannon);
                io.displayBoard(game.pieces.board);
            }
        }
        //display game's results
        io.displayEnd(game);
    }
}