package source.pieces;

import source.pieces.board.Column;
import source.pieces.board.Row;

public class Coordinate {
    public Row row;
    public Column column;

    public Coordinate(Column c, Row r){
        row = r;
        column = c;
    }
}
