package antgame;

public class Position {
	int x;
	int y;
	//constructor x and y axis
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
				
	}
	
	public int getY(){
		return y;
	}
	
	//takes Position and Direction parameters to return the adjacent(directly in front) position of current position
	public Position adjacentCell(Position pos, int dir) {
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
	
}
