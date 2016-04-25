package antgame;

public class World {

	static final int WORLDSIZE = 150;
	private static Cell instance[][] = null;

	public World() {
		if (instance == null) {
			instance= new Cell[WORLDSIZE][WORLDSIZE];
			for (int i = 0; i < WORLDSIZE; i++) {
				instance[i][0] = new RockyCell(i, 0);
				instance[i][WORLDSIZE - 1] = new RockyCell(i, WORLDSIZE - 1);
			}
			for (int i = 1; i < WORLDSIZE; i++) {
				instance[0][i] = new RockyCell(0, i);
				instance[WORLDSIZE - 1][i] = new RockyCell(WORLDSIZE - 1, i);
			}			
		}
	}
	
	public Cell getCell(Position p){
		return instance[p.getX()][p.getY()];
	}

	private void randomWorld() {
		
	}

	private void premadeWorld() {

	}

}
