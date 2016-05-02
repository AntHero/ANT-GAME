package antgame;
/*
 * @author Arcooo
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class World {
	static final int WORLDSIZE = 150; // maximum worldsize from requirements
	private static Cell instance[][] = null; // global 2D Cell array
	//global variables to keep track of center of first anthill (RED)
	private int AntHillX = -1;
	private int AntHillY = -1;

	//constructor
	public World() {
	}

	// return cell in the 2D cell array
	public Cell getCell(int x, int y) {
		if (instance == null) { // checks if instance is valid and can be used
			return null;
		}
		return instance[x][y];
	}

	//Creates a randomWorld
	public Cell[][] randomWorld(int seed) {
		if (instance == null) {
			// initialize global variable instance
			instance = new Cell[WORLDSIZE][WORLDSIZE];
			
			//Random class to get random integers
			Random r = new Random();
			r.setSeed(seed);

			// creating rocky border
			createRockyBorder();

			// place the red anthill
			antHillCreatorHelper(r.nextInt(), r.nextInt(), Color.RED);
			// place the black anthill
			antHillCreatorHelper(r.nextInt(), r.nextInt(), Color.BLACK);

			// placing 5x5 blobs of food
			placeFoodBlobs(r.nextInt());
			// place 14 random rocks
			placeRandomRocky(r.nextInt());

			// fill in empty remaining cells with ClearCells
			fillWithClear();

			// placing and IDing ants to antHillCells
			antIDMethod();
			return instance;
		}
		return instance;

	}

	private void premadeWorld() {

	}

	// creates rocky border
	private void createRockyBorder() {
		for (int i = 0; i < WORLDSIZE; i++) {
			instance[i][0] = new RockyCell(i, 0); // top
			instance[i][WORLDSIZE - 1] = new RockyCell(i, WORLDSIZE - 1); // bottom
			instance[0][i] = new RockyCell(0, i); // left side
			instance[WORLDSIZE - 1][i] = new RockyCell(WORLDSIZE - 1, i); // right
		}
	}
	
	//creates anthills
	private void antHillCreatorHelper(int seedX, int seedY, Color col) {
		int xCoord, yCoord;

		// random number generator
		RandomInt r = new RandomInt();

		// creates random int between 0 and 136
		// then adds 7 to ensure anthill center is away from the wall
		xCoord = r.randomInteger(136, seedX) + 7;
		yCoord = r.randomInteger(136, seedY) + 7;

		//checks if the second anthill overlaps the first
		while (xCoord < (AntHillX + 7) && xCoord > (AntHillX - 7)) {
			xCoord = r.randomInteger(136, seedX * 3) + 7;
		}
		while (yCoord < (AntHillY + 7) && yCoord > (AntHillY - 7)) {
			yCoord = r.randomInteger(136, seedY * 5) + 7;
		}
		
		//saves the center of the anthill as a global variable
		AntHillX = xCoord;
		AntHillY = yCoord;

		//if y coordinate is even
		if (yCoord % 2 == 0) {
			for (int i = 0; i < 7; i++) {
				instance[xCoord - 3 + i][yCoord - 6] = new AntHillCell(xCoord - 3 + i, yCoord - 6, 0, col);
				instance[xCoord - 3 + i][yCoord + 6] = new AntHillCell(xCoord - 3 + i, yCoord + 6, 0, col);
			}
			for (int i = 0; i < 8; i++) {
				instance[xCoord - 3 + i][yCoord - 5] = new AntHillCell(xCoord - 3 + i, yCoord - 5, 0, col);
				instance[xCoord - 3 + i][yCoord + 5] = new AntHillCell(xCoord - 3 + i, yCoord + 5, 0, col);

			}
			for (int i = 0; i < 9; i++) {
				instance[xCoord - 4 + i][yCoord - 4] = new AntHillCell(xCoord - 4 + i, yCoord - 4, 0, col);
				instance[xCoord - 4 + i][yCoord + 4] = new AntHillCell(xCoord - 4 + i, yCoord + 4, 0, col);

			}
			for (int i = 0; i < 10; i++) {
				instance[xCoord - 4 + i][yCoord - 3] = new AntHillCell(xCoord - 4 + i, yCoord - 3, 0, col);
				instance[xCoord - 4 + i][yCoord + 3] = new AntHillCell(xCoord - 4 + i, yCoord + 3, 0, col);

			}
			for (int i = 0; i < 11; i++) {
				instance[xCoord - 5 + i][yCoord - 2] = new AntHillCell(xCoord - 5 + i, yCoord - 2, 0, col);
				instance[xCoord - 5 + i][yCoord + 2] = new AntHillCell(xCoord - 5 + i, yCoord + 2, 0, col);

			}
			for (int i = 0; i < 12; i++) {
				instance[xCoord - 5 + i][yCoord - 1] = new AntHillCell(xCoord - 5 + i, yCoord - 1, 0, col);
				instance[xCoord - 5 + i][yCoord + 1] = new AntHillCell(xCoord - 5 + i, yCoord + 1, 0, col);

			}
			for (int i = 0; i < 13; i++) {
				instance[xCoord - 6 + i][yCoord] = new AntHillCell(xCoord - 6 + i, yCoord, 0, col);
			}
		//if y coordinate is even
		} else {
			for (int i = 0; i < 7; i++) {
				instance[xCoord - 3 + i][yCoord - 6] = new AntHillCell(xCoord - 3 + i, yCoord - 6, 0, col);
				instance[xCoord - 3 + i][yCoord + 6] = new AntHillCell(xCoord - 3 + i, yCoord + 6, 0, col);
			}
			for (int i = 0; i < 8; i++) {
				instance[xCoord - 4 + i][yCoord - 5] = new AntHillCell(xCoord - 4 + i, yCoord - 5, 0, col);
				instance[xCoord - 4 + i][yCoord + 5] = new AntHillCell(xCoord - 4 + i, yCoord + 5, 0, col);

			}
			for (int i = 0; i < 9; i++) {
				instance[xCoord - 4 + i][yCoord - 4] = new AntHillCell(xCoord - 4 + i, yCoord - 4, 0, col);
				instance[xCoord - 4 + i][yCoord + 4] = new AntHillCell(xCoord - 4 + i, yCoord + 4, 0, col);

			}
			for (int i = 0; i < 10; i++) {
				instance[xCoord - 5 + i][yCoord - 3] = new AntHillCell(xCoord - 5 + i, yCoord - 3, 0, col);
				instance[xCoord - 5 + i][yCoord + 3] = new AntHillCell(xCoord - 5 + i, yCoord + 3, 0, col);

			}
			for (int i = 0; i < 11; i++) {
				instance[xCoord - 5 + i][yCoord - 2] = new AntHillCell(xCoord - 5 + i, yCoord - 2, 0, col);
				instance[xCoord - 5 + i][yCoord + 2] = new AntHillCell(xCoord - 5 + i, yCoord + 2, 0, col);

			}
			for (int i = 0; i < 12; i++) {
				instance[xCoord - 6 + i][yCoord - 1] = new AntHillCell(xCoord - 6 + i, yCoord - 1, 0, col);
				instance[xCoord - 6 + i][yCoord + 1] = new AntHillCell(xCoord - 6 + i, yCoord + 1, 0, col);

			}
			for (int i = 0; i < 13; i++) {
				instance[xCoord - 6 + i][yCoord] = new AntHillCell(xCoord - 6 + i, yCoord, 0, col);
			}
		}
	}

	//places 5 5x5 food blobs randomly
	private void placeFoodBlobs(int seed) {
		int blobCounter = 0;
		int seedCounter = seed + 5;
		boolean freeCells = true;

		// Coordinate for upper left corner for 5x5 food blobs
		int foodX = 0;
		int foodY = 0;

		RandomInt r = new RandomInt();

		while (blobCounter < 5) {
			foodX = r.randomInteger(136, seedCounter*3) + 7;
			foodY = r.randomInteger(136, seedCounter*4) + 7;
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

	//places 14 single random rocky cells
	private void placeRandomRocky(int seed) {
		int rockyCounter = 0;
		int rockySeed = seed + 100;
		boolean freeCell = true;
		int rockX = 0;
		int rockY = 0;
		RandomInt r = new RandomInt();

		while (rockyCounter != 14) {
			rockX = r.randomInteger(136, rockySeed*3) + 7;
			rockY = r.randomInteger(136, rockySeed*4) + 7;
			rockySeed += 2;
			if (instance[rockX][rockY] != null) {
				freeCell = false;
			}
			if (freeCell) {
				// System.out.println(rockX + " " + rockY);
				instance[rockX][rockY] = new RockyCell(rockX, rockY);
			}
			rockyCounter++;
			freeCell = true;
		}
	}

	//fills instance (the 2D Cell array) with clear cells
	private void fillWithClear() {
		for (int i = 0; i < WORLDSIZE; i++) {
			for (int j = 0; j < WORLDSIZE; j++) {
				if (instance[i][j] == null) {
					instance[i][j] = new ClearCell(i, j, 0);
				}
			}
		}
	}

	// this method needs to come after all cells initiated
	private void antIDMethod() {
		Color cHolder;
		int antID = 0; // check if i need to make this static
		Ant antOnHill = null;
		ClearCell c = null;
		// System.out.println(instance[1][1].getIsAntHill());

		for (int i = 0; i < WORLDSIZE; i++) {
			for (int j = 0; j < WORLDSIZE; j++) {
				// System.out.println(i + " " + j);
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

	//creates a visual text file to see the world
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
						 out.print(instance[j][i].getFoodAmount() + " ");
//						out.print("5 ");
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
}
