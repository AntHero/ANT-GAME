package antgame;

public class Cell {

	Position position;
	//initialized in every class so cell type info can be used by world class
	Cell instance;		
	//initialized in AntHillCell class so color can be accessed by  super
	Color superColor;

	//returns position of cell
	public Position getPosition() {
		return position;
	}

	//checks if cell is rocky
	public boolean getIsRocky() {
		return instance.getClass().equals(RockyCell.class);
	}
	
	//checks if cell is clera
	public boolean getIsClear() {
		return instance.getClass().equals(ClearCell.class);
	}
	
	//checks if cell is anthill
	public boolean getIsAntHill() {
		return instance.getClass().equals(AntHillCell.class);
	}

	//returns anthill color
	public Color getHillColor() {
		return superColor;
	}

}
