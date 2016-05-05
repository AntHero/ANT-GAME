package antgame;
/**
 * Represents the Anthill cell on the map in the simulation.
 * 
 * @author Arco
 * @author Abdulrahman
 */
public class AntHillCell extends ClearCell {

	Color color;
	// static int id = 0;

	// note to ab: took Ant parameter out because have to initialize ants left
	// to right
	// we can put it back in and set Ants to null when creating AntHillCell
	// classes
	// but I thought that was redundant
	// just initialize ants with their ids after making the AntHillCells
	//
	
	/**
	 * Constructor for AntHillCell class.
	 * 
	 * @param x The 'X' coordinate of the cell
	 * @param y The 'Y' coordinate of the cell
	 * @param food The number of food items on the cell
	 * @param color The color of ants which this anthill belongs too.
	 */
	public AntHillCell(int x, int y, int food, Color color) {
		super(x, y, food);
		// this.ant = new Ant(id, color);
		// id++;
		this.color = color;
		instance = this;	//needed for all Cell classes so super can access what type of cell it is in world
		superColor = color;	//needed for super to find color of antHill
							//you cant access subclasses from object *****Cell[][]

	}
	public Color getColor(){
		return color;
	}

}
