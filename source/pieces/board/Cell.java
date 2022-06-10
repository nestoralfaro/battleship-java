package source.pieces.board;
import source.pieces.ship.Ship;

//A Cell "has-a" state and/or a ship
public class Cell {
    public State state;
    public Ship craft;

    Cell() {
        state = State.EMPTY;
    }
}
