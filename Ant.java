package antgame;
/**
 * A Class which represents an ant in the simulation.
 * 
 * @author Arco
 * @author Abdulrahman
 */
public class Ant {
	int id;
	int state = 0; 
	Color color;
	int resting = 0;
	int direction = 0;
	boolean hasFood = false;
	boolean isAlive = true;

	/**
	 * Constructor of the Ant Class.
	 * 
	 * @param id The unique int value for each ant in the simulation
	 * @param color The color of the ant, either red or black. 
	 */
	public Ant(int id, Color color) {
		this.id = id;
		this.color = color;
	}
	
	/**
	 * Sets the value isAlive to dead. Kills the Ant
	 */
	 public void setToDead() {
		this.isAlive = false;
	}

	/**
	 * Change the ants current state.
	 * 
	 * @param state The state which the ant will become.
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * Sets the Ant as resting. Represents the wait after the ant has moved.
	 * 
	 * @param resting The value which represents if the ant is at rest.
	 */
	public void setResting(int resting) {
		this.resting = resting;
	}

	/**
	 * Sets the direction which the ant is facing.
	 * 
	 * @param direction The direction in which the ant will face.
	 */
	public void setDirection(int direction) {
		assert(direction >= 0 && direction <= 5);	//ensure dir is from 0-5
		this.direction = direction;
	}
	
	/**
	 *Sets the ant to be carrying food.
	 * 
	 * @param hasFood The boolean value which represents if the ant is carrying food.
	 */
	public void setHasFood(boolean hasFood) {
		this.hasFood = hasFood;
	}

	/**
	 * @return The state which the ant is in.
	 */
	public int getState() {
		return state;
	}

	/**
	 * @return The color of the ant. (Red or Black)
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * @return The value representing whether the ant is resting
	 */
	public int getResting() {
		return resting;
	}

	/**
	 * @return The direction which the ant is facing
	 */
	public int getDirection() {
		return direction;
	}
	
	/**
	 * @return Whether or not the ant is carrying food.
	 */
	public boolean hasFood() {
		return hasFood;
	}
	
	/**
	 * @return The ant's ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return Whether or not the ant is alive
	 */
	public boolean isAlive() {
		return isAlive;
	}
	/**
	 * method for turning the direction of the ant	
	 * 
	 * @param lr The direction left or right to be used in the case statement
	 * @param dir The direction in which the ant is currently facing
	 * @throws IllegalArgumentException In the case that the switch statement fails.
	 * @return An integer representing the way the ant will face after turning.
	 */
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
	
	/**
	 * Sense the cell in the direction that the ant is facing.
	 * 
	 * @param pos The posistion of the ant
	 * @param dir The direction the ant is facing
	 * @param sd The direction in which the ant will 'sense'
	 * @throws IllegalArgumentException in the case the switch statement fails
	 */
	public Position sensedCell(Position pos, int dir, sense_dir sd) {
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
