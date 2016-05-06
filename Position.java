package antgame;
/**
 * This class is used by many other classes to specify where ants and cells are.
 * 
 * @author Arco James
 */
public class Position {
	int x;
	int y;
	/**
	 * Constructor of the x and y axis
	 * @param x 'X' Coordinate
	 * @param y 'Y' Coordinate
	 */
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**
	 * @return The X coordinate.
	 */
	public int getX(){
		return x;
				
	}
	
	/**
	 * @return The Y coordinate
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * takes Position and Direction parameters to return the adjacent(directly in front) position of current position
	 * @param pos The posistion of the cell
	 * @param dir The direction which the ant is facing
	 * @throws IllegalArgumentException If the switch statement fails
	 * @return The cell adjacent to this one (In relation to where the ant if looking)
	 */
	public static Position adjacentCell(Position pos, int dir) {
		assert(dir>=0 && dir<=5);
		//local variables for the Position
		int x = pos.getX();
		int y = pos.getY();

	
		//adjacent position depends on the x axis of current position 
		//because hexagon grid 
		if (x % 2 == 0) { // for even x position values
			switch (dir) {
			case 0:
				return new Position(x+1, y);
			case 1:
				return new Position(x, y+1);
			case 2:
				return new Position(x-1, y+1);
			case 3:
				return new Position(x-1, y);
			case 4:
				return new Position(x-1, y-1);
			case 5:
				return new Position(x, y-1);
			}
		} else {	//for odd x position values
			switch (dir) {
			case 0:
				return new Position(x+1, y);
			case 1:
				return new Position(x+1, y+1);
			case 2:
				return new Position(x, y+1);
			case 3:
				return new Position(x-1, y);
			case 4:
				return new Position(x, y-1);
			case 5:
				return new Position(x+1, y-1);
			}

		}
		throw new IllegalArgumentException();
	}
	
	/*
	*Overides equal method of object so that if x and y of two different instances of position are equals they are equal.
	*/
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
        return hash;
    }
	
}
