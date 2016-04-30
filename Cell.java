package antgame;

public class Cell {

	Position position;
	Cell instance;
	Color color;

	public Position getPosition() {
		return position;
	}

	public boolean getIsRocky() {
		return instance.getClass().equals(RockyCell.class);
	}

	public boolean getIsClear() {
		return instance.getClass().equals(ClearCell.class);
	}

	public boolean getIsAntHill() {
		return instance.getClass().equals(AntHillCell.class);
	}

	public Color getHillColor() {
		return color;
	}

}
