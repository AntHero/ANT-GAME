package antgame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This is the class which acts as the simulation. 
 * It uses the other class to create the ant game.
 * @author Abdulrahman
 */
public class GameSimulator {
	
	//alright this class should be where everything comes together
	//string arguments should go either
	//brain1 brain2	randomworldname seed OR
	//brain1 brain2 world 
	/**
	 * Main argument uses the ant brain and map files as arguments
	 * reads in the two brains and the map.
	 * @param args The list of arguments
	 */
    public static void main(String[] args) throws FileNotFoundException, IOException {
    	File arg1;
    	File arg2;
    	File arg3;
    	int arg4;
    	ArrayList blackAntBrain;
		ArrayList redAntBrain;
		World antWorld = new World();
		Cell[][] world;
    	
    	if (args.length == 3){
    		blackAntBrain = new BrainParser().proccessBrain(args[0]);
    		redAntBrain = new BrainParser().proccessBrain(args[1]);
    		world = antWorld.premadeWorld(args[2]);
    	}else if(args.length ==4){
    		blackAntBrain = new BrainParser().proccessBrain(args[0]);
    		redAntBrain = new BrainParser().proccessBrain(args[1]);
    		world = antWorld.randomWorld(args[2], Integer.parseInt(args[3]));
    	}else{
    		System.out.println("INVALID NUMBER OF ARGUMENTS");
    	}    	
    }
}
