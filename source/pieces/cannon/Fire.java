package source.pieces.cannon;

import source.pieces.board.Row;
import source.pieces.board.Column;

public class Fire {
    public Row row;
    public Column column;

    public Fire(Column c, Row r) {
        row = r;
        column = c;
    }

    String getColumn () {
        switch (column) {
            case A:
                return "A";
            case B:
                return "B";
            case C:
                return "C";
            case D:
                return "D";
            case E:
                return "E";
            case F:
                return "F";
            case G:
                return "G";
            case H:
                return "H";
            case I:
                return "I";
            case J:
                return "J";
            case Q:
                return "Q";
            default:
                throw new IllegalArgumentException();
        }
    }

    String getRow () {
        switch (row) {
            case R0:
                return "0";
            case R1:
                return "1";
            case R2:
                return "2";
            case R3:
                return "3";
            case R4:
                return "4";
            case R5:
                return "5";
            case R6:
                return "6";
            case R7:
                return "7";
            case R8:
                return "8";
            case R9:
                return "9";
            default:
                throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return getColumn() + getRow();
    }
}
