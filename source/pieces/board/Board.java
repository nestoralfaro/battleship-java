package source.pieces.board;

public class Board {

    int BOARD_SIZE = 10;
    public Cell[][] ocean = new Cell[BOARD_SIZE][BOARD_SIZE];

    //Constructor that sets each cell on the board
    public Board() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                ocean[row][col] = new Cell();
            }
        }
    }

}
