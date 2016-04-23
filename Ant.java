package antgame;

public class Ant {
	
	int id;
	int state = 0;		//not sure
	Color color;
	int resting = 0;
	Direction direction = new Direction(0);
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
    
    public int turn(Left_or_Right lr, Direction dir){
//    	int dirToInt = 0;
//    	switch(dir){
//    	case Zero: dirToInt = 0;
//    	case One: dirToInt = 1;
//    	case Two: dirToInt = 2;
//    	case Three: dirToInt = 3;
//    	case Four: dirToInt = 4;
//    	case Five: dirToInt = 5;
//    	}
   
    	switch(lr){
    	case LEFT: return (dir.getDir() + 5) % 6; 
    	case RIGHT: return (dir.getDir() + 1) % 6; 
    	}
    	throw new IllegalArgumentException();
    		
    }
    
    public Position sensed_cell(Position pos, Direction dir, sense_dir sd){
    	switch(sd){
    	case Here: return pos;
    	case Ahead: return pos.adjacent_cell(pos, dir);
    	case LeftAhead: return pos.adjacent_cell(pos, new Direction(turn(Left_or_Right.LEFT, dir)));
    	case RightAhead: return pos.adjacent_cell(pos, new Direction(turn(Left_or_Right.RIGHT, dir)));
    	}
    	throw new IllegalArgumentException();
    }
    
    public boolean some_ant_at(Position p){
    	return
    }
  
    
    public int adjacent_ants(Position p, Color c){
    	int n = 0;
    	for (int i = 0; i <=5; i++){
    		
    	}
    	
    }
    
    public void checkForSurroundedAnts(Position pos){
    	
    }
    public void checkSurrounded(Position pos){
    	
    }
    
    public void step(int num){
    	
    }
    
    
}
