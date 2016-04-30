package antgame;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class World {

	static final int WORLDSIZE = 150; // maximum worldsize from requirements
	private static Cell instance[][] = null; // global 2D Cell array

	private World theOneAndOnly = null;
	private int blackY;
	private int blackX;

	// there should only be one ever referred to
	// deciding to make it private
	public World() {

	}

	// return cell in the 2D cell array
	public Cell getCell(Position p) {
		if (instance == null) { // checks if instance is valid and can be used
			return null;
		}
		return instance[p.getX()][p.getY()];
	}

	public Cell[][] randomWorld() {
		if (instance == null) {

			// System.out.println("hello");

			// counter for numbering the ants
			int antID = 0;
			Ant antOnHill = null;
			AntHillCell c = null;
			ClearCell foodBlobUpperLeftCorner = null;
			int foodX;
			int foodY;

			instance = new Cell[WORLDSIZE][WORLDSIZE];

			// creating rocky border
			for (int i = 0; i < WORLDSIZE; i++) {
				instance[i][0] = new RockyCell(i, 0); // top
				instance[i][WORLDSIZE - 1] = new RockyCell(i, WORLDSIZE - 1); // bottom
				instance[0][i] = new RockyCell(0, i); // left side
				instance[WORLDSIZE - 1][i] = new RockyCell(WORLDSIZE - 1, i); // right
			}

			// taking this out later but just initializing all cells to rock
			for (int i = 0; i < WORLDSIZE; i++) {
				for (int j = 0; j < WORLDSIZE; j++) {
					instance[i][j] = new RockyCell(i, j);
				}
			}
			// placing anthills randomly
			// the parameter is the seed number
			antHillCreatorHelper(0);

			// scans world left to right initializing ants on the antcells
			// for (int i = 0; i < WORLDSIZE; i++) {
			// for (int j = 0; j < WORLDSIZE; j++) {
			// if (instance[i][j].equals(AntHillCell.class)){
			// c = (AntHillCell) instance[i][j];
			// if(c.getColor().equals(Color.RED)){
			// antOnHill = new Ant(antID, Color.RED);
			// c.setAnt(antOnHill);
			// c.setAntExist();
			// antID++;
			// }else{
			// antOnHill = new Ant(antID, Color.BLACK);
			// c.setAnt(antOnHill);
			// c.setAntExist();
			// antID++;
			// }
			// }
			// }
			// }
			//
			// //11 food blob placements
			//
			//
			//
			// //random 14 RockyCells
			//
			//
			//
			//
			// } else {
			// return instance;
			// }
			return null;
		}
		return null;

	}

	private void premadeWorld() {

	}

	public void visualWorld() throws FileNotFoundException {
		int counter = 0;
		PrintWriter out = new PrintWriter("text.txt");
		for (int i = 0; i < WORLDSIZE; i++) {
			for (int j = 0; j < WORLDSIZE; j++) {
				if (instance[i][j].getIsRocky()) {
					out.print("# ");
					++counter;
				} else if (instance[i][j].getIsAntHill()) {
					out.print("* ");
					++counter;
				}else if(instance[i][j].getIsClear()){
					out.print(". ");
					++counter;
				}
				if (counter == WORLDSIZE) {
					out.println();
					counter = 0;
				}

			}
		}
		out.close();
	}

	private void antHillCreatorHelper(int seed) {
		int blackX, blackY;
		int redX, redY;
		// random number generator
		RandomInt r = new RandomInt();

		// creates random int between 0 and 136
		// then adds 7 to ensure anthill center is away from the wall
		redX = r.randomint(136, seed + 1) + 7;
		redY = r.randomint(136, seed + 2) + 7;
		blackX = r.randomint(136, seed + 3) + 7;
		blackY = r.randomint(136, seed + 4) + 7;
		System.out.println(redX);
		System.out.println(redY);
		System.out.println(blackX);
		System.out.println(blackY);

		

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
