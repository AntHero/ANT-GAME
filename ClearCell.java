package antgame;

import antgame.Ant;
import antgame.Cell;
import antgame.Color;
import antgame.Markers;
import antgame.Position;

/**
 * Represents a clear cell in our simulation.
 * 
 * @author Arco
 * @author Abdulrahman
 */
public class ClearCell extends Cell {

	Position position;
	Ant ant = null;
	boolean hasAnt; // this might be unneeded as they it can be implemented
					// later with just ant
	int food;

	Markers redMarker0 = null;
	Markers redMarker1 = null;
	Markers redMarker2 = null;
	Markers redMarker3 = null;
	Markers redMarker4 = null;
	Markers redMarker5 = null;

	Markers blackMarker0 = null;
	Markers blackMarker1 = null;
	Markers blackMarker2 = null;
	Markers blackMarker3 = null;
	Markers blackMarker4 = null;
	Markers blackMarker5 = null;

	/**
	 * Constructor of the clear cell
	 * 
	 * param x 'X' coordinate of the cell param y 'Y' coordinate of the cell
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
	 * @param ant
	 *            The ant instance to be put on this cell
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
	public void setRedMarker(int m) {
		assert(m >= 0 && m <= 5);
		switch (m) {
		case 0:
			redMarker0 = new Markers(m, Color.RED);
		case 1:
			redMarker1 = new Markers(m, Color.RED);
		case 2:
			redMarker2 = new Markers(m, Color.RED);
		case 3:
			redMarker3 = new Markers(m, Color.RED);
		case 4:
			redMarker4 = new Markers(m, Color.RED);
		case 5:
			redMarker5 = new Markers(m, Color.RED);
		}
	}

	/**
	 * set a black marker with marker type set to 0-5
	 */
	public void setBlackMarker(int m) {
		assert(m >= 0 && m <= 5);
		switch(m){
		case 0:
			blackMarker0 = new Markers(m, Color.BLACK);
		case 1:
			blackMarker1 = new Markers(m, Color.BLACK);
		case 2:
			blackMarker2 = new Markers(m, Color.BLACK);
		case 3:
			blackMarker3 = new Markers(m, Color.BLACK);
		case 4:
			blackMarker4 = new Markers(m, Color.BLACK);
		case 5:
			blackMarker5 = new Markers(m, Color.BLACK);
		}
	}

	/**
	 * @return Whether or not cell has red marker
	 */
	public boolean hasRedMarker(int i) {
		switch (i) {
		case 0:
			return redMarker0 != null;
		case 1:
			return redMarker1 != null;
		case 2:
			return redMarker2 != null;
		case 3:
			return redMarker3 != null;
		case 4:
			return redMarker4 != null;
		case 5:
			return redMarker5 != null;
		}
		return false;
	}

	/**
	 * @return Whether or not cell has black marker
	 */
	public boolean hasBlackMarker(int i) {
		switch (i) {
		case 0:
			return blackMarker0 != null;
		case 1:
			return blackMarker1 != null;
		case 2:
			return blackMarker2 != null;
		case 3:
			return blackMarker3 != null;
		case 4:
			return blackMarker4 != null;
		case 5:
			return blackMarker5 != null;
		}
		return false;
	}

	/**
	 * Clear red marker from cell
	 */
	public void clearRedMarker(int i) {
		switch (i) {
		case 0:
			redMarker0 = null;
		case 1:
			redMarker1 = null;
		case 2:
			redMarker2 = null;
		case 3:
			redMarker3 = null;
		case 4:
			redMarker4 = null;
		case 5:
			redMarker5 = null;
		}
	}

	/**
	 * Clear black marker from cell
	 */
	public void clearBlackMarker(int i) {
		switch (i) {
		case 0:
			blackMarker0 = null;
		case 1:
			blackMarker1 = null;
		case 2:
			blackMarker2 = null;
		case 3:
			blackMarker3 = null;
		case 4:
			blackMarker4 = null;
		case 5:
			blackMarker5 = null;
		}
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
	 * Checks if an ant is in the cell, if not sets cell to have a specific ant.
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
