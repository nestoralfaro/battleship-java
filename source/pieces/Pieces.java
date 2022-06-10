package source.pieces;

import source.pieces.board.Board;
import source.pieces.board.State;
import source.pieces.ship.Ship;
import source.pieces.ship.Ships;
import source.pieces.cannon.Fire;

public class Pieces {
    public Board board;
    public Ship carrier, battleship, cruiser, submarine, destroyer;
    public State CellResult;
    public Fire cannon;

    public Pieces() {
        board = new Board();
        createShips();
    }

    void createShips() {
        carrier = new Ship(Ships.CARRIER, 5);
        battleship = new Ship(Ships.BATTLESHIP, 4);
        cruiser = new Ship(Ships.CRUISER, 3);
        submarine = new Ship(Ships.SUBMARINE, 3);
        destroyer = new Ship(Ships.DESTROYER, 2);
    }
}
