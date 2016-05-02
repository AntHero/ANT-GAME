package antgame;

public class Ant {
	int id;
	int state = 0; 
	Color color;
	int resting = 0;
	int direction = 0;
	boolean hasFood = false;
	boolean isAlive = true;

	public Ant(int id, Color color) {
		this.id = id;
		this.color = color;
	}
	
	//kill ant
	public void setToDead() {
		this.isAlive = false;
	}

	//change state
	public void setState(int state) {
		this.state = state;
	}

	//set resting
	public void setResting(int resting) {
		this.resting = resting;
	}

	//set direction
	public void setDirection(int direction) {
		assert(direction >= 0 && direction <= 5);	//ensure dir is from 0-5
		this.direction = direction;
	}
	
	//set ant to have food *note: ants can only carry one food
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

	//method for turning the direction of the ant	
	public int turn(Left_or_Right lr, int dir) {
		assert(direction >= 0 && direction <= 5);	//ensure dir is from 0-5

		switch (lr) {
		case Left:
			return (dir + 5) % 6;	//turn left
		case Right:
			return (dir + 1) % 6;	//turn right
		}
		
		throw new IllegalArgumentException();	//should never get here

	}
	
	//sense the cell in the direction that the ant is facing
	public Position sensed_cell(Position pos, int dir, sense_dir sd) {
		assert(dir >= 0 && dir <= 5);

		switch (sd) {
		case Here:
			return pos;		//cell ant is on now
		case Ahead:
			return pos.adjacentCell(pos, dir);		//cell the ant is facing with dir
		case LeftAhead:
			return pos.adjacentCell(pos, turn(Left_or_Right.Left, dir));	//cell to the left of faced direction
		case RightAhead:
			return pos.adjacentCell(pos, turn(Left_or_Right.Right, dir));	//cell to the right of faced direction
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
