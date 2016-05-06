package antgame;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import antgame.Instructions.Drop;
import antgame.Instructions.Flip;
import antgame.Instructions.Mark;
import antgame.Instructions.Move;
import antgame.Instructions.PickUp;
import antgame.Instructions.Sense;
import antgame.Instructions.Turn;
import antgame.Instructions.UnMark;

/**
 * Represent the world in our simulation.
 * 
 * @author Arco James
 */
public class World {
	static final int WORLDSIZE = 150; // maximum worldsize from requirements
	private static Cell instance[][] = null; // global 2D Cell array
	// global variables to keep track of center of first anthill (RED)
	private int AntHillX = -1;
	private int AntHillY = -1;
	ArrayList<Instructions> blackBrain = null;
	ArrayList<Instructions> redBrain = null;

	// constructor
	public World() {
	}

	/**
	 * @param x
	 *            The 'X' coordinate of the cell
	 * @param y
	 *            The 'Y' coordinate of the cell
	 * @return Cell in the 2D cell array
	 */
	public static Cell getCell(int x, int y) {
		if (instance == null) { // checks if instance is valid and can be used
			return null;
		}
		return instance[x][y];
	}

	/**
	 * Creates a randomWorld
	 * 
	 * @param filename
	 *            Name of the file to create the world with.
	 * @param seed
	 *            Used to generate the random world
	 * @return 2D array of cells representing a world
	 */
	public Cell[][] randomWorld(String filename, int seed) throws FileNotFoundException {
		if (instance == null) {
			// initialize global variable instance
			instance = new Cell[WORLDSIZE][WORLDSIZE];

			// Random class to get random integers
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

			visualWorld(filename);
			return instance;
		}
		return instance;

	}

	public void thisWorld(Cell[][] x) {
		instance = x;
	}

	/**
	 * Reads in a world from a text file and creates it in a 2D array of cells
	 * 
	 * @param fileName
	 *            The file to read the world from
	 * @return The array containing the world.
	 */
	public Cell[][] premadeWorld(String fileName) {
		instance = new Cell[WORLDSIZE][WORLDSIZE];
		Cell premade[][];
		WorldParser wp = new WorldParser();
		premade = wp.parseWorld(fileName);
		instance = premade;
		for (int i = 0; i < WORLDSIZE; i++) {
			for (int j = 0; j < WORLDSIZE; j++) {
				instance[i][j] = (Cell) premade[i][j];
			}
		}
		return instance;
	}

	/**
	 * creates rocky border
	 */
	private void createRockyBorder() {
		for (int i = 0; i < WORLDSIZE; i++) {
			instance[i][0] = new RockyCell(i, 0); // top
			instance[i][WORLDSIZE - 1] = new RockyCell(i, WORLDSIZE - 1); // bottom
			instance[0][i] = new RockyCell(0, i); // left side
			instance[WORLDSIZE - 1][i] = new RockyCell(WORLDSIZE - 1, i); // right
		}
	}

	/**
	 * creates anthills
	 * 
	 * @param seedX
	 *            'X' coordinate from the map
	 * @param seedY
	 *            'Y' coordinate from the map
	 * @param col
	 *            The color of the anthill.
	 */
	private void antHillCreatorHelper(int seedX, int seedY, Color col) {
		int xCoord, yCoord;

		// random number generator
		RandomInt r = new RandomInt();

		// creates random int between 0 and 136
		// then adds 7 to ensure anthill center is away from the wall
		xCoord = r.randomInteger(136, seedX) + 7;
		yCoord = r.randomInteger(136, seedY) + 7;

		// checks if the second anthill overlaps the first
		while (xCoord < (AntHillX + 7) && xCoord > (AntHillX - 7)) {
			xCoord = r.randomInteger(136, seedX * 3) + 7;
		}
		while (yCoord < (AntHillY + 7) && yCoord > (AntHillY - 7)) {
			yCoord = r.randomInteger(136, seedY * 5) + 7;
		}

		// saves the center of the anthill as a global variable
		AntHillX = xCoord;
		AntHillY = yCoord;

		// if y coordinate is even
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
			// if y coordinate is even
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

	/**
	 * Places 5 5x5 food blobs randomly
	 * 
	 * @param seed
	 *            The map seed
	 */
	private void placeFoodBlobs(int seed) {
		int blobCounter = 0;
		int seedCounter = seed + 5;
		boolean freeCells = true;

		// Coordinate for upper left corner for 5x5 food blobs
		int foodX = 0;
		int foodY = 0;

		RandomInt r = new RandomInt();

		while (blobCounter < 5) {
			foodX = r.randomInteger(136, seedCounter * 3) + 7;
			foodY = r.randomInteger(136, seedCounter * 4) + 7;
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

	/**
	 * Places 14 single random rocky cells
	 * 
	 * @param seed
	 *            The worlds seed
	 */
	private void placeRandomRocky(int seed) {
		int rockyCounter = 0;
		int rockySeed = seed + 100;
		boolean freeCell = true;
		int rockX = 0;
		int rockY = 0;
		RandomInt r = new RandomInt();

		while (rockyCounter != 14) {
			rockX = r.randomInteger(136, rockySeed * 3) + 7;
			rockY = r.randomInteger(136, rockySeed * 4) + 7;
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

	/**
	 * fills instance (the 2D Cell array) with clear cells
	 */
	private void fillWithClear() {
		for (int i = 0; i < WORLDSIZE; i++) {
			for (int j = 0; j < WORLDSIZE; j++) {
				if (instance[i][j] == null) {
					instance[i][j] = new ClearCell(i, j, 0);
				}
			}
		}
	}

	/**
	 * Checks if cells will contain ants and assigns the ant to the cell if so.
	 */
	private void antIDMethod() {
		Color cHolder;
		int antID = 0; // check if i need to make this static
		Ant antOnHill = null;
		ClearCell c = null;
		// System.out.println(instance[1][1].getIsAntHill());

		for (int i = 0; i < WORLDSIZE; i++) {
			for (int j = 0; j < WORLDSIZE; j++) {
				// ids ants from left to right, bottom to top
				if (instance[j][i].getIsAntHill()) {
					// typecasting Cell to ClearCell
					// saving it in local variable c
					c = (ClearCell) instance[j][i];
					// getting color
					cHolder = instance[j][i].getHillColor();
					// creating ant
					antOnHill = new Ant(antID, cHolder);
					++antID;

					// sets cell to have ant
					c.setHasAnt();
					c.setAnt(antOnHill);
				}
			}
		}
	}

	/**
	 * Creates a visual text file to see the world
	 * 
	 * @param filename
	 *            The file name of the world to visualise
	 */
	public void visualWorld(String filename) throws FileNotFoundException {
		int counter = 0;
		PrintWriter out = new PrintWriter(filename + ".text");

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
						// out.print("5 ");
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

	/**
	 * @param p
	 *            The posistion to check
	 * @returns Whether or not there is an ant at posistion 'p'
	 */
	public boolean someAntAt(Position p) {
		ClearCell cc;
		if (instance == null) {
			throw new NullPointerException("World not constructed");
		} else {
			if (instance[p.getX()][p.getY()].getIsClear()) {
				cc = (ClearCell) instance[p.getX()][p.getY()];
				return cc.hasAnt();
			}
		}
		return false; // never should get here
	}

	/**
	 * @param The
	 *            posistion to check
	 * @return The ant at posistion P if there is one.
	 */
	public Ant antAt(Position p) {
		ClearCell cc;
		if (instance == null) {
			throw new NullPointerException("World not constructed");
		} else {
			if (instance[p.getX()][p.getY()].getIsClear()) {
				cc = (ClearCell) instance[p.getX()][p.getY()];
				return cc.getAnt();
			}
		}
		return null;
	}

	/**
	 * @param p
	 *            The posistion to place the ant at.
	 * @param a
	 *            The ant to be placed.
	 */
	public void setAntAt(Position p, Ant a) {
		ClearCell cc;
		if (instance == null) {
			throw new NullPointerException("World not constructed");
		} else {
			if (instance[p.getX()][p.getY()].getIsClear() || instance[p.getX()][p.getY()].getIsAntHill()) {
				cc = (ClearCell) instance[p.getX()][p.getY()];
				cc.setAnt(a);
				cc.setHasAnt();
			}
		}
	}

	/**
	 * Removes ant from a cell on the map
	 * 
	 * @param p
	 *            The posistion to remove the ant from
	 */
	public void clearAntAt(Position p) {
		ClearCell cc;
		if (instance == null) {
			throw new NullPointerException("World not constructed");
		} else {
			if (instance[p.getX()][p.getY()].getIsClear() || instance[p.getX()][p.getY()].getIsAntHill()) {
				cc = (ClearCell) instance[p.getX()][p.getY()];
				cc.removeHasAnt();
				cc.removeAnt();
			}
		}
	}

	/**
	 * @param ID
	 *            The ID of the ant to check for.
	 * @return Whether or not the ant is alive.
	 */
	public boolean antIsAlive(int ID) {
		ClearCell cc;
		if (instance == null) {
			throw new NullPointerException("World not constructed");
		} else {
			Position p = findAnt(ID);
			if(p!=null){
				return true;
			}else{
				return false;
			}			
			// System.out.println("hel" + c.hasAnt());
			// System.out.println("helt" + c.getAnt().isAlive());

			// return c.getAnt().isAlive();
			// for (int i = 0; i < WORLDSIZE; i++) {
			// for (int j = 0; j < WORLDSIZE; j++) {
			// if (instance[i][j].getIsClear()) {
			// cc = (ClearCell) instance[i][i];
			// if (cc.hasAnt()) {
			//
			// if (cc.getAnt().getId() == ID) {
			// return cc.getAnt().isAlive();
			// }
			// }
			// }
			// }
			// }
		}
		// System.out.println("Should not get here");
		// return false;
	}

	/**
	 * Checks the world for a specified ant
	 * 
	 * @param ID
	 *            The ID of the ant to find
	 * @return The posistion of the ant on the world
	 */
	public Position findAnt(int ID) {
		ClearCell cc;
		if (instance == null) {
			throw new NullPointerException("World not constructed");
		} else {
			for (int i = 0; i < WORLDSIZE; i++) {
				for (int j = 0; j < WORLDSIZE; j++) {

					if (instance[i][j].getIsClear() || instance[i][j].getIsAntHill()) {

						cc = (ClearCell) instance[i][j];
						if (cc.hasAnt()) {
							// System.out.println(cc.getAnt());
							if (cc.getAnt().getId() == ID) {
								// System.out.println("***");
								return new Position(i, j);
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Kills the ant at the specified posistion
	 * 
	 * @param p
	 *            The location where the ant to be killed is currently.
	 */
	public void killAntAt(Position p) {
		int x = p.getX();
		int y = p.getY();
		ClearCell cc = (ClearCell) getCell(x, y);

		cc.removeAnt();
		cc.removeHasAnt();
		if (cc.hasAnt()) {
			cc.getAnt().setToDead();
			if (cc.getAnt().hasFood) {
				cc.foodSetDown();
			}
		}

	}

	/**
	 * Checks if ants are next to eachother
	 * 
	 * @param pos
	 *            The posistion of the ant for which to find the adjacent ants
	 * @param col
	 *            The color of the ant
	 * @return The number of the ants adjacent to this ant.
	 */
	public int adjacentAnts(Position pos, Color col) {
		int n = 0;
		for (int dir = 0; dir < 5; dir++) {
			if (someAntAt(pos) && antAt(pos).getColor() == col) {
				++n;
			}
		}
		return n;
	}

	/**
	 * Checks if the ant is surrounded
	 * 
	 * @param pos
	 *            The posistion of the potentially surrounded ant.
	 */
	public void checkForSurroundedAntAt(Position pos) {
		Ant a;
		ClearCell cc;
		if (someAntAt(pos)) {
			a = antAt(pos);
			if (adjacentAnts(pos, Color.otherColor(a.getColor())) >= 5) {
				killAntAt(pos);
				cc = (ClearCell) instance[pos.getX()][pos.getY()];
				cc.setFood(3);
			}
		}
	}

	/**
	 * Checks if the ant is surrounded
	 * 
	 * @param pos
	 *            The posistion of the potentially surrounded ant.
	 */
	public void checkForSurroundedAnts(Position pos) {
		checkForSurroundedAntAt(pos);
		for (int dir = 0; dir < 5; dir++) {
			checkForSurroundedAntAt(pos.adjacentCell(pos, dir));
		}
	}

	public int foodAt(Position p) {
		ClearCell cc;
		if (instance == null) {
			throw new NullPointerException("World not constructed");
		} else {
			if (instance[p.getX()][p.getY()].getIsClear()) {
				cc = (ClearCell) instance[p.getX()][p.getY()];
				return cc.getFood();
			}
		}
		return 0;
	}

	public void setFoodAt(Position p, int f) {
		ClearCell cc;
		if (instance == null) {
			throw new NullPointerException("World not constructed");
		} else {
			if (instance[p.getX()][p.getY()].getIsClear()) {
				cc = (ClearCell) instance[p.getX()][p.getY()];
				cc.setFood(f);
			}
		}
	}

	public boolean anthillAt(Position p, Color c) {
		AntHillCell acc;
		if (instance == null) {
			throw new NullPointerException("World not constructed");
		} else {
			if (instance[p.getX()][p.getY()].getIsAntHill()) {
				acc = (AntHillCell) instance[p.getX()][p.getY()];
				return (acc.getColor() == c);
			}
		}
		return false;
	}

	public Instructions getInstruction(Color c, int state) {
		if (redBrain == null || blackBrain == null) {
			System.out.println("brains not set");
			return null;
		} else {
			if (c == Color.RED) {
				return (Instructions) redBrain.get(state);
			} else {
				return (Instructions) redBrain.get(state);
			}
		}
	}

	/**
	 * Checks if an ant can move yet.
	 * 
	 * @param antID
	 *            The id of the ant to check if can move.
	 */
	public void step(int antID, ArrayList<Instructions> brain) {

		if (antIsAlive(antID)) {
			Position p = findAnt(antID);
			Ant a = antAt(p);
			Instructions instruction = getInstruction(a.getColor(), a.getState());

			if (a.getResting() > 0) {
				a.setResting(a.getResting() - 1);
			} else {
				if (instruction.equals(Sense.class)) {
					Position sensedP = a.sensedCell(p, a.getDirection(), ((Sense) instruction).getP());
					if (cellMatches(sensedP, ((Sense) instruction).getC(), a.getColor())) {
						a.setState(((Sense) instruction).getSt1());
					} else {
						a.setState(((Sense) instruction).getSt2());
					}
				} else if (instruction.equals(Mark.class)) {
					setMarker(p, a.getColor(), ((Mark) instruction).getI());
					a.setState(((Mark) instruction).getSt());

				} else if (instruction.equals(UnMark.class)) {
					clearMarkerAt(p, a.getColor(), ((UnMark) instruction).getI());
					a.setState(((UnMark) instruction).getSt());

				} else if (instruction.equals(PickUp.class)) {
					if (a.hasFood() || foodAt(p) == 0) {
						a.setState(((PickUp) instruction).getSt2());
					} else {
						ClearCell cc = (ClearCell) getCell(p.getX(), p.getY());
						cc.foodPickedUp();
						a.setHasFood(true);
						a.setState(((PickUp) instruction).getSt1());
					}
				} else if (instruction.equals(Drop.class)) {
					if (a.hasFood()) {
						ClearCell cc = (ClearCell) getCell(p.getX(), p.getY());
						cc.foodSetDown();
						a.setHasFood(false);
					}
					a.setState(((Drop) instruction).getSt());
				} else if (instruction.equals(Turn.class)) {
					a.setDirection(Ant.turn(((Turn) instruction).getLr(), a.getDirection()));
					a.setState(((Turn) instruction).getSt());
				} else if (instruction.equals(Move.class)) {
					Position newp = Position.adjacentCell(p, a.getDirection());
					if (getCell(newp.getX(), newp.getY()).getIsRocky() || someAntAt(newp)) {
						a.setState(((Move) instruction).getSt2());
					} else {
						clearAntAt(p);
						setAntAt(newp, a);
						a.setState(((Move) instruction).getSt2());
						a.setResting(14);
						checkForSurroundedAnts(newp);
					}
				} else if (instruction.equals(Flip.class)) {
					RandomInt rand = new RandomInt();
					if (rand.randomInteger(((Flip) instruction).getP(), 0) == 0) {
						a.setState(((Flip) instruction).getSt1());
					} else {
						a.setState(((Flip) instruction).getSt2());
					}
				} else {
					System.out.println("INVALID INSTRUCTION");
				}
			}

		}
	}

	public boolean cellMatches(Position p, Condition cond, Color c) {
		if (instance[p.getX()][p.getY()].getIsRocky()) {
			return false;
		} else {
			switch (cond) {
			case Friend:
				return someAntAt(p) && antAt(p).getColor() == c;
			case Foe:
				return someAntAt(p) && antAt(p).getColor() != c;
			case FriendWithFood:
				return someAntAt(p) && antAt(p).getColor() == c && antAt(p).hasFood();
			case FoeWithFood:
				return someAntAt(p) && antAt(p).getColor() != c && antAt(p).hasFood();
			case Food:
				return instance[p.getX()][p.getY()].getFoodAmount() > 0;
			case Rock:
				return false;
			case Marker:
				return checkAnyMarkerAt(p, c);
			case FoeMarker:
				return checkAnyMarkerAt(p, Color.otherColor(c));
			case Home:
				return instance[p.getX()][p.getY()].getIsAntHill() && instance[p.getX()][p.getY()].getHillColor() == c;
			case FoeHome:
				return instance[p.getX()][p.getY()].getIsAntHill() && instance[p.getX()][p.getY()].getHillColor() != c;
			}
			return false;
		}
	}

	public void setMarker(Position p, Color c, Markers m) {
		ClearCell cc = (ClearCell) getCell(p.getX(), p.getY());
		if (c == Color.RED) {
			cc.setRedMarker(m.getNumber());
		} else {
			cc.setBlackMarker(m.getNumber());
		}
	}

	public void clearMarkerAt(Position p, Color c, Markers m) {
		ClearCell cc = (ClearCell) getCell(p.getX(), p.getY());
		if (c == Color.RED) {
			cc.clearRedMarker(m.getNumber());
		} else {
			cc.clearBlackMarker(m.getNumber());
		}
	}

	public boolean checkMarkerAt(Position p, Color c, Markers m) {
		ClearCell cc = (ClearCell) getCell(p.getX(), p.getY());
		if (c == Color.RED) {
			return cc.hasRedMarker(m.getNumber());
		} else {
			return cc.hasBlackMarker(m.getNumber());
		}
	}

	public boolean checkAnyMarkerAt(Position p, Color c) {
		ClearCell cc = (ClearCell) getCell(p.getX(), p.getY());
		for (int i = 0; i < 5; i++) {
			if (cc.hasRedMarker(i) || cc.hasBlackMarker(i)) {
				return true;
			}
		}
		return false;
	}

	void round() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	void setBlackBrain(ArrayList s) {
		blackBrain = new ArrayList();
		this.blackBrain = s;
	}

	void setRedBrain(ArrayList s) {
		redBrain = new ArrayList();
		this.redBrain = s;
	}
}
