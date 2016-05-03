package antgame;
/**
 * Represents a clear cell in our simulation.
 * @author Arco
 * @author Abdulrahman
 */
public class ClearCell extends Cell {

	Position position;
	Ant ant = null;
	boolean hasAnt; // this might be unneeded as they it can be implemented
					// later with just ant
	int food;
	// TO-DO implement type marker.
	int redMarker = -1;
	int blackMarker = -1;
	
	/**
	 * Constructor of the clear cell
	 * 
	 * param x 'X' coordinate of the cell
	 * param y 'Y' coordinate of the cell
	 * param food The amount of food on this cell
	 */
	public ClearCell(int x, int y, int food) {
		this.hasAnt = false;
		this.food = food;
		this.position = new Position(x, y);
		instance = this;
		superFood = food;
	}

	/**
	 * Removes the ant from this cell
	 */
	public void antMovedAway() {
		this.ant = null;
		hasAnt = false;
	}

	/**
	 * Add an ant to this cell
	 * 
	 * @param ant The ant instance to be put on this cell
	 */
	public void antMoveHere(Ant ant) {
		this.ant = ant;
		hasAnt = true;
	}

	/**
	 * Take an item of food from this cell
	 */
	public void foodPickedUp() {
		this.food = this.food - 1;
	}

	/**
	 * Set down one iteam of food
	 */
	public void foodSetDown() {
		this.food = this.food + 1;
	}

	/**
	 * Set the number of food on the cell
	 */
	public void setFood(int i) {
		this.food = i;
	}

	/**
	 * Set a red marker with marker type set to 0-5
	 */
	public void setRedMarker(int redMarker) {
		assert(redMarker >= 0 && redMarker <= 5);
		this.redMarker = redMarker;
	}

	/**
	 * set a black marker with marker type set to 0-5
	 */
	public void setBlackMarker(int blackMarker) {
		assert(blackMarker >= 0 && blackMarker <= 5);
		this.blackMarker = blackMarker;
	}

	/**
	 * @return Whether or not cell has red marker
	 */
	public boolean hasRedMarker() {
		return redMarker != -1;
	}

	/**
	 * @return Whether or not cell has black marker
	 */
	public boolean hasBlackMarker() {
		return blackMarker != -1;
	}

	/**
	 * Clear red marker from cell
	 */
	public void clearRedMarker() {
		redMarker = -1;
	}

	/**
	 * Clear black marker from cell
	 */
	public void clearBlackMarker() {
		blackMarker = -1;
	}

	/**
	 * @return The instance of Ant on this cell
	 */
	public Ant getAnt() {
		return ant;
	}

	/**
	 * @return Whether or not this cell has an ant on it.
	 */
	public boolean hasAnt() {
		return hasAnt;
	}
	
	/**
	 * @return The amount of food on the cell.
	 */
	public int getFood() {
		return food;
	}

	/**
	 * Checks if the cell has an ant, if not set then sets hasAnt to true.
	 */
	public void setHasAnt() {
		assert(hasAnt == false);
		this.hasAnt = true;
	}

	/**
	 * Checks if an ant is in the cell, if not
	 * sets cell to have a specific ant.
	 */
	public void setAnt(Ant ant) {
		assert(hasAnt == false);
		this.ant = ant;
	}

	/**
	 * Sets cell not to contain an ant
	 */
	public void removeHasAnt() {
		this.hasAnt = false;
	}

	/**
	 * Removes the instance of an ant from the cell.
	 */
	public void removeAnt() {
		this.ant = null;
	}

}
