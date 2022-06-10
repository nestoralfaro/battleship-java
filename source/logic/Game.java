package source.logic;

import source.pieces.Coordinate;
import source.pieces.Pieces;
import source.pieces.ship.Ship;
import source.pieces.cannon.Fire;
import source.pieces.ship.Condition;
import source.pieces.ship.Direction;
import source.pieces.board.Cell;
import source.pieces.board.State;
import source.pieces.board.Column;
import source.pieces.board.Row;

//Game class
//Handles the whole game system (pieces and logic)
public class Game {
    public Pieces pieces;
    public Result result;
    public int turns = 0;

    //Constructor that creates pieces (board and ships)
    public Game () {
        pieces = new Pieces();
    }

    //prepares the ships (sets their coordinates) and places them on the board
    public void setShips(String[] positions) {
        for (int ship = 0; ship < positions.length; ship++) {
            switch (ship) {
                case 0:
                    setUp(pieces.carrier, positions[ship]);
                    placeOnBoard(pieces.carrier);
                    break;
                case 1:
                    setUp(pieces.battleship, positions[ship]);
                    placeOnBoard(pieces.battleship);
                    break;
                case 2:
                    setUp(pieces.cruiser, positions[ship]);
                    placeOnBoard(pieces.cruiser);
                    break;
                case 3:
                    setUp(pieces.submarine, positions[ship]);
                    placeOnBoard(pieces.submarine);
                    break;
                case 4:
                    setUp(pieces.destroyer, positions[ship]);
                    placeOnBoard(pieces.destroyer);
                    break;
            }
        }
    }

    //helper method that places a ship on the board
    void placeOnBoard (Ship ship) {
        for (int i = 0; i < ship.length; i++) {
            if ((ship.direction).equals(Direction.HORIZONTAL)) {
                (pieces.board.ocean[ship.coordinate.row.ordinal()] [ship.coordinate.column.ordinal() + i]).craft = ship;
                (pieces.board.ocean[ship.coordinate.row.ordinal()] [ship.coordinate.column.ordinal() + i]).state = State.LOADED;

            }
            else {
                pieces.board.ocean [ship.coordinate.row.ordinal() + i] [ship.coordinate.column.ordinal()].craft = ship;
                pieces.board.ocean [ship.coordinate.row.ordinal() + i] [ship.coordinate.column.ordinal()].state = State.LOADED;

            }
        }
    }

    //helper method that sets a ship's coordinates
    void setUp(Ship ship, String position){
        ship.setUpPosition(new Coordinate(getColumn(position.charAt(0)), getRow(position.charAt(1))), getDirection(position.charAt(2)));
    }

    //helper getter that converts a char to a column and returns it
    public Column getColumn(char point) {
        switch (point) {
            case 'A':
            case 'a':
                return Column.A;
            case 'B':
            case 'b':
                return Column.B;
            case 'C':
            case 'c':
                return Column.C;
            case 'D':
            case 'd':
                return Column.D;
            case 'E':
            case 'e':
                return Column.E;
            case 'F':
            case 'f':
                return Column.F;
            case 'G':
            case 'g':
                return Column.G;
            case 'H':
            case 'h':
                return Column.H;
            case 'I':
            case 'i':
                return Column.I;
            case 'J':
            case 'j':
                return Column.J;
            case 'Q':
            case 'q':
                return Column.Q;
            default:
                return null;
        }
    }

    //helper getter that converts a char to a row and returns it
    public Row getRow (char point) {
        switch (point) {
            case '0':
                return Row.R0;
            case '1':
                return Row.R1;
            case '2':
                return Row.R2;
            case '3':
                return Row.R3;
            case '4':
                return Row.R4;
            case '5':
                return Row.R5;
            case '6':
                return Row.R6;
            case '7':
                return Row.R7;
            case '8':
                return Row.R8;
            case '9':
                return Row.R9;
            default:
                return null;
        }

    }

    //helper getter that converts a char to a direction and returns it
    Direction getDirection (char direction) {
        switch (direction) {
            case 'h':
            case 'H':
                return Direction.HORIZONTAL;
            case 'v':
            case 'V':
                return Direction.VERTICAL;
            default:
                return null;
        }
    }

    //helper method that verifies and sets a ship to sunk if they are
    boolean isSunk (Ship ship) {
        for (int i = 0; i < ship.length; i++) {
            if ((ship.direction).equals(Direction.HORIZONTAL)) {
                if ((pieces.board.ocean [ship.coordinate.row.ordinal()] [ship.coordinate.column.ordinal() + i].state).equals(State.LOADED)) {
                    return false;
                }
            }
            else {
                if ((pieces.board.ocean [ship.coordinate.row.ordinal() + i] [ship.coordinate.column.ordinal()].state).equals(State.LOADED)) {
                    return false;
                }
            }
        }
        return true;
    }

    //shoots the board and returns true if the game continues
    public boolean shoot (String shot) {
        if (shot.equals("q0") || shot.equals("Q0")) {
            result = Result.LOST;
            pieces.cannon = new Fire(getColumn(shot.charAt(0)), getRow(shot.charAt(1)));
            return false;
        }
        else {
            turns++;
            pieces.cannon = new Fire(getColumn(shot.charAt(0)), getRow(shot.charAt(1)));
            Cell currentCell = pieces.board.ocean[pieces.cannon.row.ordinal()][pieces.cannon.column.ordinal()];
            if ((currentCell.state).equals(State.EMPTY) | (currentCell.state).equals(State.MISS)) {
                currentCell.state = State.MISS;
                pieces.CellResult = State.MISS;
            }
            else {
                currentCell.state = State.HIT;
                currentCell.craft.condition = Condition.HIT;
                pieces.CellResult = State.HIT;

                if (isSunk(currentCell.craft)){
                    currentCell.craft.condition = Condition.SUNK;
                }
            }
            return true;
        }
    }

    //verifies if the game is over
    public boolean over() {
        if ((pieces.cannon.toString().equals("Q0")) | (pieces.cannon.toString().equals("q0"))) {
            return true;
        }
        else {
            if (pieces.carrier.condition.equals(Condition.SUNK) &
                    pieces.battleship.condition.equals(Condition.SUNK) &
                    pieces.cruiser.condition.equals(Condition.SUNK) &
                    pieces.submarine.condition.equals(Condition.SUNK) &
                    pieces.destroyer.condition.equals(Condition.SUNK)
            ) {
                result = Result.WIN;
                return true;
            } else
                return false;
        }
    }
}
