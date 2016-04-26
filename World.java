package antgame;

public class World {

	static final int WORLDSIZE = 150;
	private static Cell instance[][] = null;
	private World theOneAndOnly = null;
	private int blackY;
	private int blackX;

	// there should only be one ever referred to
	private World() {

	}

	public Cell getCell(Position p) {
		return instance[p.getX()][p.getY()];
	}

	public Cell[][] randomWorld() {
		if (instance == null) {
			int antID=0;

			instance = new Cell[WORLDSIZE][WORLDSIZE];
			for (int i = 0; i < WORLDSIZE; i++) {
				instance[i][0] = new RockyCell(i, 0); // top
				instance[i][WORLDSIZE - 1] = new RockyCell(i, WORLDSIZE - 1); // bottom
				instance[0][i] = new RockyCell(0, i); // left side
				instance[WORLDSIZE - 1][i] = new RockyCell(WORLDSIZE - 1, i); // right
																				// side
			}

			// placing anthills randomly
			antHillCreatorHelper();
			for (int i = 0; i < WORLDSIZE; i++) {
				for (int j = 0; i < WORLDSIZE; j++) {
					if (instance[i][j].equals(AntHillCell.class)){
						instance[i][j].setAnt();
					}
				}
			}

		} else {
			return instance;
		}

	}

	private void premadeWorld() {

	}

	private void antHillCreatorHelper() {
		int blackX, blackY;
		int redX, redY;

		RandomInt r = new RandomInt();
		redX = r.randomint(136, 1);
		redY = r.randomint(136, 2);
		blackX = r.randomint(136, 3);
		blackY = r.randomint(136, 4);

		if (redY % 2 == 0) {
			for (int i = 0; i < 7; i++) {
				instance[redX - 3 + i][redY - 6] = new AntHillCell(redX - 3 + i, redY - 6, 0, Color.RED);
				instance[redX - 3 + i][redY + 6] = new AntHillCell(redX - 3 + i, redY + 6, 0, Color.RED);
			}
			for (int i = 0; i < 8; i++) {
				instance[redX - 3 + i][redY - 5] = new AntHillCell(redX - 3 + i, redY - 5, 0, Color.RED);
				instance[redX - 3 + i][redY + 5] = new AntHillCell(redX - 3 + i, redY + 5, 0, Color.RED);

			}
			for (int i = 0; i < 9; i++) {
				instance[redX - 4 + i][redY - 4] = new AntHillCell(redX - 4 + i, redY - 4, 0, Color.RED);
				instance[redX - 4 + i][redY + 4] = new AntHillCell(redX - 4 + i, redY + 4, 0, Color.RED);

			}
			for (int i = 0; i < 10; i++) {
				instance[redX - 4 + i][redY - 3] = new AntHillCell(redX - 4 + i, redY - 3, 0, Color.RED);
				instance[redX - 4 + i][redY + 3] = new AntHillCell(redX - 4 + i, redY + 3, 0, Color.RED);

			}
			for (int i = 0; i < 11; i++) {
				instance[redX - 5 + i][redY - 2] = new AntHillCell(redX - 5 + i, redY - 2, 0, Color.RED);
				instance[redX - 5 + i][redY + 2] = new AntHillCell(redX - 5 + i, redY + 2, 0, Color.RED);

			}
			for (int i = 0; i < 12; i++) {
				instance[redX - 5 + i][redY - 1] = new AntHillCell(redX - 5 + i, redY - 1, 0, Color.RED);
				instance[redX - 5 + i][redY + 1] = new AntHillCell(redX - 5 + i, redY + 1, 0, Color.RED);

			}
			for (int i = 0; i < 13; i++) {
				instance[redX - 6 + i][redY] = new AntHillCell(redX - 6 + i, redY, 0, Color.RED);
			}
		} else {
			for (int i = 0; i < 7; i++) {
				instance[redX - 3 + i][redY - 6] = new AntHillCell(redX - 3 + i, redY - 6, 0, Color.RED);
				instance[redX - 3 + i][redY + 6] = new AntHillCell(redX - 3 + i, redY + 6, 0, Color.RED);
			}
			for (int i = 0; i < 8; i++) {
				instance[redX - 4 + i][redY - 5] = new AntHillCell(redX - 4 + i, redY - 5, 0, Color.RED);
				instance[redX - 4 + i][redY + 5] = new AntHillCell(redX - 4 + i, redY + 5, 0, Color.RED);

			}
			for (int i = 0; i < 9; i++) {
				instance[redX - 4 + i][redY - 4] = new AntHillCell(redX - 4 + i, redY - 4, 0, Color.RED);
				instance[redX - 4 + i][redY + 4] = new AntHillCell(redX - 4 + i, redY + 4, 0, Color.RED);

			}
			for (int i = 0; i < 10; i++) {
				instance[redX - 5 + i][redY - 3] = new AntHillCell(redX - 5 + i, redY - 3, 0, Color.RED);
				instance[redX - 5 + i][redY + 3] = new AntHillCell(redX - 5 + i, redY + 3, 0, Color.RED);

			}
			for (int i = 0; i < 11; i++) {
				instance[redX - 5 + i][redY - 2] = new AntHillCell(redX - 5 + i, redY - 2, 0, Color.RED);
				instance[redX - 5 + i][redY + 2] = new AntHillCell(redX - 5 + i, redY + 2, 0, Color.RED);

			}
			for (int i = 0; i < 12; i++) {
				instance[redX - 6 + i][redY - 1] = new AntHillCell(redX - 6 + i, redY - 1, 0, Color.RED);
				instance[redX - 6 + i][redY + 1] = new AntHillCell(redX - 6 + i, redY + 1, 0, Color.RED);

			}
			for (int i = 0; i < 13; i++) {
				instance[redX - 6 + i][redY] = new AntHillCell(redX - 6 + i, redY, 0, Color.RED);
			}
		}

		if (blackY % 2 == 0) {
			for (int i = 0; i < 7; i++) {
				instance[blackX - 3 + i][blackY - 6] = new AntHillCell(blackX - 3 + i, blackY - 6, 0, Color.BLACK);
				instance[blackX - 3 + i][blackY + 6] = new AntHillCell(blackX - 3 + i, blackY + 6, 0, Color.BLACK);
			}
			for (int i = 0; i < 8; i++) {
				instance[blackX - 3 + i][blackY - 5] = new AntHillCell(blackX - 3 + i, blackY - 5, 0, Color.BLACK);
				instance[blackX - 3 + i][blackY + 5] = new AntHillCell(blackX - 3 + i, blackY + 5, 0, Color.BLACK);

			}
			for (int i = 0; i < 9; i++) {
				instance[blackX - 4 + i][blackY - 4] = new AntHillCell(blackX - 4 + i, blackY - 4, 0, Color.BLACK);
				instance[blackX - 4 + i][blackY + 4] = new AntHillCell(blackX - 4 + i, blackY + 4, 0, Color.BLACK);

			}
			for (int i = 0; i < 10; i++) {
				instance[blackX - 4 + i][blackY - 3] = new AntHillCell(blackX - 4 + i, blackY - 3, 0, Color.BLACK);
				instance[blackX - 4 + i][blackY + 3] = new AntHillCell(blackX - 4 + i, blackY + 3, 0, Color.BLACK);

			}
			for (int i = 0; i < 11; i++) {
				instance[blackX - 5 + i][blackY - 2] = new AntHillCell(blackX - 5 + i, blackY - 2, 0, Color.BLACK);
				instance[blackX - 5 + i][blackY + 2] = new AntHillCell(blackX - 5 + i, blackY + 2, 0, Color.BLACK);

			}
			for (int i = 0; i < 12; i++) {
				instance[blackX - 5 + i][blackY - 1] = new AntHillCell(blackX - 5 + i, blackY - 1, 0, Color.BLACK);
				instance[blackX - 5 + i][blackY + 1] = new AntHillCell(blackX - 5 + i, blackY + 1, 0, Color.BLACK);

			}
			for (int i = 0; i < 13; i++) {
				instance[blackX - 6 + i][blackY] = new AntHillCell(blackX - 6 + i, blackY, 0, Color.BLACK);
			}
		} else {
			for (int i = 0; i < 7; i++) {
				instance[blackX - 3 + i][blackY - 6] = new AntHillCell(blackX - 3 + i, blackY - 6, 0, Color.BLACK);
				instance[blackX - 3 + i][blackY + 6] = new AntHillCell(blackX - 3 + i, blackY + 6, 0, Color.BLACK);
			}
			for (int i = 0; i < 8; i++) {
				instance[blackX - 4 + i][blackY - 5] = new AntHillCell(blackX - 4 + i, blackY - 5, 0, Color.BLACK);
				instance[blackX - 4 + i][blackY + 5] = new AntHillCell(blackX - 4 + i, blackY + 5, 0, Color.BLACK);

			}
			for (int i = 0; i < 9; i++) {
				instance[blackX - 4 + i][blackY - 4] = new AntHillCell(blackX - 4 + i, blackY - 4, 0, Color.BLACK);
				instance[blackX - 4 + i][blackY + 4] = new AntHillCell(blackX - 4 + i, blackY + 4, 0, Color.BLACK);

			}
			for (int i = 0; i < 10; i++) {
				instance[blackX - 5 + i][blackY - 3] = new AntHillCell(blackX - 5 + i, blackY - 3, 0, Color.BLACK);
				instance[blackX - 5 + i][blackY + 3] = new AntHillCell(blackX - 5 + i, blackY + 3, 0, Color.BLACK);

			}
			for (int i = 0; i < 11; i++) {
				instance[blackX - 5 + i][blackY - 2] = new AntHillCell(blackX - 5 + i, blackY - 2, 0, Color.BLACK);
				instance[blackX - 5 + i][blackY + 2] = new AntHillCell(blackX - 5 + i, blackY + 2, 0, Color.BLACK);

			}
			for (int i = 0; i < 12; i++) {
				instance[blackX - 6 + i][blackY - 1] = new AntHillCell(blackX - 6 + i, blackY - 1, 0, Color.BLACK);
				instance[blackX - 6 + i][blackY + 1] = new AntHillCell(blackX - 6 + i, blackY + 1, 0, Color.BLACK);

			}
			for (int i = 0; i < 13; i++) {
				instance[blackX - 6 + i][blackY] = new AntHillCell(blackX - 6 + i, blackY, 0, Color.BLACK);
			}
		}
	}

}
