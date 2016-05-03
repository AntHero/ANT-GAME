package antgame;
/**
 * The superclass of AntHillCell and RockyCell
 * Represents a cell in the simulation.
 * 
 * @author Arco
 * @author Abdulrahman
 */
public class Cell {

	Position position;
	//initialized in every class so cell type info can be used by world class
	Cell instance;		
	//initialized in AntHillCell class so color can be accessed by super
	Color superColor = null;
	//initialized in ClearCell class so food access in super
	int superFood = 0;

	/**
	 * @return The position of cell
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @return Whether or not the cell is rocky
	 */
	public boolean getIsRocky() {
		return instance.getClass().equals(RockyCell.class);
	}
	
	/**
	 * @return Whether or not the cell is clear
	 */
	public boolean getIsClear() {
		return instance.getClass().equals(ClearCell.class);
	}
	
	/**
	 * @return Whether or not the cell is an anthill.
	 */
	public boolean getIsAntHill() {
		return instance.getClass().equals(AntHillCell.class);
	}

	/**
	 * @return The color of the anthill.
	 */
	public Color getHillColor() {
		return superColor;
	}
	
	/**
	 * @return The amount of food on the current cell
	 */
	public int getFoodAmount(){
		return superFood;
	}

}
