package source.io;

import java.util.*;
import source.logic.Game;
import source.logic.Result;
import source.pieces.board.Board;
import source.pieces.board.State;
import source.pieces.board.Cell;
import source.pieces.cannon.Fire;
import source.pieces.ship.Ships;
import source.pieces.ship.Condition;

//io class
//Takes care of the input and output throughout the code
public class io {
    //prompts to input ships and returns them in an array of Strings
    //e.g. F7H B1V D6V F3H I3V -> ["F7H", "B1V", "D6V", "F3H", "I3V"]

    //Global Scanner instance to receive input.
    static Scanner input = new Scanner(System.in);

    public static String[] enterShips(){
        return (input.nextLine().toUpperCase().split(" "));
    }

    public static void displayBoard(Board board) {
        System.out.println("  ABCDEFGHIJ");
        for (int row = 0; row < board.ocean.length; row++) {
            System.out.print(row);
            System.out.print(' ');
            for (Cell col : board.ocean[row]) {
                switch (col.state) {
                    case HIT:
                        System.out.print('X');
                        break;
                    case MISS:
                        System.out.print('O');
                        break;
                    case EMPTY:
                    case LOADED:
                        System.out.print('.');
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    //prompts to input shot and returns it in a string
    public static String enterShot() {
        return ((input.next()).toUpperCase());
    }

    //displays the result of the shot
    public static void displayFeedback(Board board, Fire shot) {
        System.out.print(shot.toString() + ": ");
        Cell currentCell = board.ocean[shot.row.ordinal()][shot.column.ordinal()];
        if (currentCell.state.equals(State.HIT)){
            System.out.print("Hit ");
            displayShip(currentCell.craft.getType());
            if (currentCell.craft.condition.equals(Condition.SUNK)) {
                System.out.print("You sank my ");
                displayShip(currentCell.craft.getType());
            }
        }
        else {
            System.out.println("Miss");
        }
        System.out.println();
    }

    //helper method that displays a ship's type
    static void displayShip (Ships ship) {
        switch (ship) {
            case CARRIER:
                System.out.println("Carrier");
                break;
            case BATTLESHIP:
                System.out.println("Battleship");
                break;
            case CRUISER:
                System.out.println("Cruiser");
                break;
            case SUBMARINE:
                System.out.println("Submarine");
                break;
            case DESTROYER:
                System.out.println("Destroyer");
                break;
        }
    }

    //displays the end of the game
    public static void displayEnd(Game game) {
        if (game.result.equals(Result.WIN)) {
            System.out.println("You won in " + game.turns + " turns");
        }
        else {
            System.out.println("You lost");
        }
    }
}
