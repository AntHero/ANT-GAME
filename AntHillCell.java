package antgame;

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
	public AntHillCell(int x, int y, int food, Color color) {
		super(x, y, food);
		// this.ant = new Ant(id, color);
		// id++;
		this.color = color;
		instance = this;	//needed for all Cell classes so super can access what type of cell it is in world
		superColor = color;	//needed for super to find color of antHill
							//you cant access subclasses from object *****Cell[][]

	}

}
