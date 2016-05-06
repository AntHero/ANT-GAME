package antgame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This is the class which acts as the simulation. 
 * It uses the other class to create the ant game.
 * @author Arco James
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
	 
    static World antWorld = new World();
    static Cell[][] map;

    public static void main(String[] args) throws FileNotFoundException, IOException {


     
        ArrayList blackAntBrain;
        ArrayList redAntBrain;

        blackAntBrain = new BrainParser().proccessBrain(args[0]);
        redAntBrain = new BrainParser().proccessBrain(args[1]);
        
        if (args.length == 3) {
            map = antWorld.premadeWorld(args[2]);
        } else if (args.length == 4) {

            map = antWorld.randomWorld(args[2], Integer.parseInt(args[3]));           
        } else {
            System.out.println("INVALID NUMBER OF ARGUMENTS");
        }
        
        antWorld.thisWorld(map);
        antWorld.setBlackBrain(blackAntBrain);
        antWorld.setRedBrain(redAntBrain);
    }
    
    
    private int roundCount = 0;

    public void oneRound() {

        while (roundCount < 3000) {

            antWorld.round();

        }
        
        System.out.println("finished");

    }
    	
    	
    }
}
