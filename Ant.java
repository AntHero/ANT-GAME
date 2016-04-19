package antgame;

public class Ant {
	
	int id;
	int state = 0;		//not sure
	Color color;
	int resting = 0;
	Direction direction;
	boolean hasFood = false;
	boolean isAlive = true;
	
	public Ant(int id, Color color){
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
    
    public void adjacent_ants(Position pos, Color color){
    	
    }
    
    public void checkForSurroundedAnts(Position pos){
    	
    }
    public void checkSurrounded(Position pos){
    	
    }
    
    public void step(int num){
    	
    }
    
    
}
