package antgame;

public class Ant {
	int state;
	Color color;
	int resting;
	Direction direction;
	boolean hasFood;
		
	public Ant(int state, Color color, int resting, Direction direction, boolean hasFood){
		this.state = state;
		this.color = color;
		this.resting = resting;
		this.direction = direction;
		this.hasFood = hasFood;
		
		
		
	}
	
	
}
