package source.pieces.ship;

import source.pieces.Coordinate;

public class Ship {

    public Ships craft;
    public int length;
    public Coordinate coordinate;
    public Direction direction;
    public Condition condition;

    public Ship (Ships craft, int length){
        this.craft = craft;
        this.length = length;
        condition = Condition.NEW;
    }

    public void setUpPosition (Coordinate c, Direction d) {
        coordinate = c;
        direction = d;
    }

    public Ships getType() {
        return craft;
    }
}
