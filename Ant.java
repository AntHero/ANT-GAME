package antgame;

public class Ant {
	//testing
	
	int id;
	int state;
	Color color;
	int resting;
	Direction direction;
	boolean hasFood;
	boolean isAlive;
	
	public Ant(int state, Color color, int resting, Direction direction, boolean hasFood){
		this.id = id;
		this.state = 0;
		this.color = color;
		this.resting = resting;
		this.direction = new Direction(DirectionType.ZERO);
		this.hasFood = hasFood;
		this.isAlive = true;
		
		//Test Commit
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

    public void setDirection(Direction direction) {
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

    public Direction getDirection() {
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
    
    
}
