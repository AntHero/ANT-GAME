
package antgame;

import antgame.Instructions.Drop;
import antgame.Instructions.Flip;
import antgame.Instructions.Mark;
import antgame.Instructions.Move;
import antgame.Instructions.PickUp;
import antgame.Instructions.Sense;
import antgame.Instructions.Turn;
import antgame.Instructions.UnMark;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class which deals with the text file, and converts to a FSA.
 * @author D7ooM
 */
public class BrainParser {
	public BrainParser(){
		
	}

	/**
	 * This method checks for the file and sets the filename.
	 *
	 * @param filename The name of the antbrain file.
	 * @return The list of instructions after parsing the antbrain.
	 */
    public ArrayList brainParser(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println(fileName + " does not exist.");
            return null;
        }
        if (!(file.isFile() && file.canRead())) {
            System.out.println(file.getName() + " cannot be read from.");
            return null;
        }
        try {
            BrainParser parse = new BrainParser();
            return parse.proccessBrain(fileName);
        } catch (IOException e) {
        }
		return null;
    }

    /**
     * The method creates an array list constisting of instructions taken from a parsed ant brain file.
     * 
     * @param filename The name of the ant brain to be parsed.
     * @throws FileNotFoundException When the specified file is not found.
     * @throws IOException
     * @returns The list of instructions after parsing the antbrain.
     */
    public ArrayList proccessBrain(String fileName) throws FileNotFoundException, IOException {

        File file = new File(fileName);
        ArrayList brain = new ArrayList();
        String current;
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while ((current = reader.readLine()) != null) {
            //System.out.println(current);
            String[] s = current.split(" ");
            int st1;
            int st2;
            int i;
            Markers m;
            int st;
            int afterMarker;

            if (s[0].equals("Sense")) {
                sense_dir cuSen = sense_dir.valueOf(s[1]);
                st1 = Integer.parseInt(s[2]);
                st2 = Integer.parseInt(s[3]);
                condition cond = condition.valueOf(s[4]);
                if (cond.equals(condition.Marker)) {
                    afterMarker = Integer.parseInt(s[5]);
                    brain.add(new Sense(cuSen, st1, st2, cond, afterMarker));
                } else {
                    brain.add(new Sense(cuSen, st1, st2, cond));
                }
            } else if (s[0].equals("Mark")) {
                i = Integer.parseInt(s[1]);
                m = new Markers(i);
                st = Integer.parseInt(s[2]);
                brain.add(new Mark(m, st));
            } else if (s[0].equals("Unmark")) {
                i = Integer.parseInt(s[1]);
                m = new Markers(i);
                st = Integer.parseInt(s[2]);
                brain.add(new UnMark(m, st));
            } else if (s[0].equals("PickUp")) {
                st1 = Integer.parseInt(s[1]);
                st2 = Integer.parseInt(s[2]);
                brain.add(new PickUp(st1, st2));
            } else if (s[0].equals("Drop")) {
                st = Integer.parseInt(s[1]);
                brain.add(new Drop(st));
            } else if (s[0].equals("Turn")) {
                Left_or_Right lr = Left_or_Right.valueOf(s[1]);
                st = Integer.parseInt(s[2]);
                brain.add(new Turn(lr, st));
            } else if (s[0].equals("Move")) {
                st1 = Integer.parseInt(s[1]);
                st2 = Integer.parseInt(s[2]);
                brain.add(new Move(st1, st2));
            } else if (s[0].equals("Flip")) {
                i = Integer.parseInt(s[1]);
                st1 = Integer.parseInt(s[2]);
                st2 = Integer.parseInt(s[3]);
                brain.add(new Flip(i, st1, st2));
            } else {
                System.out.println("incorect istruction detected");
            }

        }
        return brain;

    }
}
