package antgame;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class World {

	static final int WORLDSIZE = 150; // maximum worldsize from requirements
	private static Cell instance[][] = null; // global 2D Cell array

	// there should only be one ever referred to
	// deciding to make it private
	public World() {

	}

	// return cell in the 2D cell array
	public Cell getCell(int x, int y) {
		if (instance == null) { // checks if instance is valid and can be used
			return null;
		}
		return instance[x][y];
	}

	public Cell[][] randomWorld(int seed) {
		if (instance == null) {
			// initialize global variable instance
			instance = new Cell[WORLDSIZE][WORLDSIZE];

			// taking this out later but just initializing all cells to rock
			for (int i = 0; i < WORLDSIZE; i++) {
				for (int j = 0; j < WORLDSIZE; j++) {
					instance[i][j] = null;
				}
			}

			// creating rocky border
			for (int i = 0; i < WORLDSIZE; i++) {
				instance[i][0] = new RockyCell(i, 0); // top
				instance[i][WORLDSIZE - 1] = new RockyCell(i, WORLDSIZE - 1); // bottom
				instance[0][i] = new RockyCell(0, i); // left side
				instance[WORLDSIZE - 1][i] = new RockyCell(WORLDSIZE - 1, i); // right
			}

			// placing anthills randomly
			// the parameter is the seed number
			antHillCreatorHelper(seed);
			// placing and IDing ants to antHillCells
			 antIDMethod();
			// placing 5x5 blobs of food
			placeFoodBlobs(seed);
			// place 14 random rocks
			// placeRandomRocky(seed);

			// fill in empty remaining cells with ClearCells
			for (int i = 0; i < WORLDSIZE; i++) {
				for (int j = 0; j < WORLDSIZE; j++) {
					if (instance[i][j] == null) {
						instance[i][j] = new ClearCell(i, j, 0);
					}

				}
			}

			return instance;
		}
		return instance;

	}

	private void premadeWorld() {

	}

	public void visualWorld() throws FileNotFoundException {
		int counter = 0;
		PrintWriter out = new PrintWriter("text.txt");

		// i is the y axis due to how printing works
		for (int i = 0; i < WORLDSIZE; i++) {
			// j is the x axis
			for (int j = 0; j < WORLDSIZE; j++) {
				if (instance[j][i].getIsRocky()) {
					out.print("# ");
					++counter;
					
					
					
				} else if (instance[j][i].getIsAntHill()) {
					if (instance[j][i].getHillColor().equals(Color.RED)) {
						out.print("+ ");
					} else {
						out.print("- ");
					}
					++counter;
				} else if (instance[j][i].getIsClear()) {
					if (instance[j][i].getFoodAmount() != 0) {
						// out.print(instance[j][i].getFoodAmount());				
						out.print("5 ");
					} else {
						out.print(". ");
					}
					++counter;
				} else {
					out.print("? ");
				}
				if (counter == WORLDSIZE) {
					out.println();
					counter = 0;
				}

			}
		}
		out.close();
	}

	private void placeRandomRocky(int seed) {
		int rockyCounter = 0;
		int rockySeed = seed + 100;
		boolean freeCell = true;
		int rockX = 0;
		int rockY = 0;
		RandomInt r = new RandomInt();
		rockX = r.randomint(136, rockySeed) + 7;
		rockY = r.randomint(136, rockySeed + 1) + 7;
		rockyCounter += 2;

		while (rockyCounter != 14) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (instance[rockX][rockY] != null) {
						freeCell = false;
					}
				}
			}

			if (freeCell) {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						instance[rockX][rockY] = new RockyCell(rockX, rockY);
					}
				}
				rockyCounter++;
			}
			freeCell = true;

		}

	}

	private void placeFoodBlobs(int seed) {
		int blobCounter = 0;
		int seedCounter = seed + 5;
		boolean freeCells = true;

		// Coordinate for upper left corner for 5x5 food blobs
		int foodX = 0;
		int foodY = 0;

		RandomInt r = new RandomInt();

		while (blobCounter < 5) {
			foodX = r.randomint(136, seedCounter) + 7;
			foodY = r.randomint(136, seedCounter + 1) + 7;
			seedCounter += 2;

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (instance[foodX + i][foodY + j] != null) {
						freeCells = false;
					}
				}
			}

			if (freeCells) {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						instance[foodX + i][foodY + j] = new ClearCell(foodX, foodY, 5);
					}
				}
				blobCounter++;
			}
			freeCells = true;
		}
	}
	
	//this method needs to come after all cells initiated
	private void antIDMethod() {
		Color cHolder;
		int antID = 0; // check if i need to make this static
		Ant antOnHill = null;
		ClearCell c = null;
//		System.out.println(instance[1][1].getIsAntHill());

		for (int i = 0; i < WORLDSIZE; i++) {
			for (int j = 0; j < WORLDSIZE; j++) {
				System.out.println(i + " " + j);
				if (instance[i][j].getIsAntHill()) {
					// typecasting Cell to ClearCell
					// saving it in local variable c
					c = (ClearCell) instance[i][j];
					// getting color
					cHolder = instance[i][j].getHillColor();
					// creating ant
					antOnHill = new Ant(antID, cHolder);
					++antID;

					// sets cell to have ant
					c.setAntExist();
					c.setAnt(antOnHill);
				}
			}
		}
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

		// for testing
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
