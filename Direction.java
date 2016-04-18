package antgame;

public class Direction {
	DirectionType direction;

	public Direction(DirectionType direction) {
		this.direction = direction;
	}
	
	//unfinished method
	public Cell adjacent_cell(Position pos, DirectionType direction) {

		if (pos.getX() % 2 != 0) {
			switch (direction) {
			case ZERO:
        	        case ONE:
                        case TWO:
                        case THREE:
                        case FOUR:
                        case FIVE:
		} else {
			switch (direction) {
			case ZERO:
        	        case ONE:
                        case TWO:
                        case THREE:
                        case FOUR:
                        case FIVE:
			}
		//unfinished method
        	return new Cell();
		}
		

	}
		public DirectionType getDirection(){
			return direction;
		}

}
