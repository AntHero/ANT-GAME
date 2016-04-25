package antgame;

public class Ant {

	int id;
	int state = 0; // not sure
	Color color;
	int resting = 0;
	int direction = 0;
	boolean hasFood = false;
	boolean isAlive = true;

	public Ant(int id, Color color) {
		this.id = id;
		this.color = color;

	}

	public void setToDead() {
		this.isAlive = false;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setResting(int resting) {
		this.resting = resting;
	}

	public void setDirection(int direction) {
		assert(direction >= 0 && direction <= 5);
		this.direction = direction;
	}

	public void setHasFood(boolean hasFood) {
		this.hasFood = hasFood;
	}

	public int getState() {
		return state;
	}

	public Color getColor() {
		return color;
	}

	public int getResting() {
		return resting;
	}

	public int getDirection() {
		return direction;
	}

	public boolean hasFood() {
		return hasFood;
	}

	public int getId() {
		return id;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public int turn(Left_or_Right lr, int dir) {
		// int dirToInt = 0;
		// switch(dir){
		// case Zero: dirToInt = 0;
		// case One: dirToInt = 1;
		// case Two: dirToInt = 2;
		// case Three: dirToInt = 3;
		// case Four: dirToInt = 4;
		// case Five: dirToInt = 5;
		// }

		switch (lr) {
		case LEFT:
			return (dir + 5) % 6;
		case RIGHT:
			return (dir + 1) % 6;
		}
		throw new IllegalArgumentException();

	}

	public Position sensed_cell(Position pos, int dir, sense_dir sd) {
		assert(dir >= 0 && dir <= 5);

		switch (sd) {
		case Here:
			return pos;
		case Ahead:
			return pos.adjacent_cell(pos, dir);
		case LeftAhead:
			return pos.adjacent_cell(pos, turn(Left_or_Right.LEFT, dir));
		case RightAhead:
			return pos.adjacent_cell(pos, turn(Left_or_Right.RIGHT, dir));
		}
		throw new IllegalArgumentException();
	}

	/*
	 * ant_is_alive?, find_ant, kill ant, adjacent ants, check for surrounded ant at,
	 * check for surrounded ants step
	 * 
	 * this is implemented somewhere else because we need access to the entire map, or need 
	 * to implement map with cells first
	 */

}
