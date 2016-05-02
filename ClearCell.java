package antgame;

public class ClearCell extends Cell {

	Position position;
	Ant ant = null;
	boolean hasAnt; // this might be unneeded as they it can be implemented
					// later with just ant
	int food;
	// TO-DO implement type marker.
	int redMarker = -1;
	int blackMarker = -1;

	public ClearCell(int x, int y, int food) {
		this.hasAnt = false;
		this.food = food;
		this.position = new Position(x, y);
		instance = this;
		superFood = food;
	}

	// ant is no longer on the cell
	public void antMovedAway() {
		this.ant = null;
		hasAnt = false;
	}

	// ant is moved to this cell
	public void antMoveHere(Ant ant) {
		this.ant = ant;
		hasAnt = true;
	}

	// food taken from cell
	public void foodPickedUp() {
		this.food = this.food - 1;
	}

	// food set down on cell
	public void foodSetDown() {
		this.food = this.food + 1;
	}

	// set number of food on cell
	public void setFood(int i) {
		this.food = i;
	}

	// set a red marker with marker type set to 0-5
	public void setRedMarker(int redMarker) {
		assert(redMarker >= 0 && redMarker <= 5);
		this.redMarker = redMarker;
	}

	// set a black marker with marker type set to 0-5
	public void setBlackMarker(int blackMarker) {
		assert(blackMarker >= 0 && blackMarker <= 5);
		this.blackMarker = blackMarker;
	}

	// check has red marker
	public boolean hasRedMarker() {
		return redMarker != -1;
	}

	// check if has black marker
	public boolean hasBlackMarker() {
		return blackMarker != -1;
	}

	// clear redmarker
	public void clearRedMarker() {
		redMarker = -1;
	}

	// clear blackmarker
	public void clearBlackMarker() {
		blackMarker = -1;
	}

	// get ant
	public Ant getAnt() {
		return ant;
	}

	// has ant
	public boolean hasAnt() {
		return hasAnt;
	}

	// get how much food on cell
	public int getFood() {
		return food;
	}

	//// sets cell to have a ant
	// asserts there is no ant there already
	public void setHasAnt() {
		assert(hasAnt == false);
		this.hasAnt = true;
	}

	// sets cell to have a specific ant
	// asserts there is no ant there already
	public void setAnt(Ant ant) {
		assert(hasAnt == false);
		this.ant = ant;
	}

	// sets cell to not have an ant
	public void removeHasAnt() {
		this.hasAnt = false;
	}

	// remove ant from cell
	public void removeAnt() {
		this.ant = null;
	}

}
