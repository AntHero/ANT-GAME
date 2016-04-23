package antgame;

public class Position {
	int x;
	int y;
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
	
	public Position adjacent_cell(Position pos, Direction direction) {
		int x = pos.getX();
		int y = pos.getY();

	
		if (x % 2 == 0) { // for even x position values
			switch (direction.getDir()) {
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
			switch (direction.getDir()) {
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
