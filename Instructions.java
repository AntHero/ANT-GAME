
package antgame;

/**
 *This is an interface which links all the seven instruction under it.
 *This will be used in the brain parser to store the text file of the brain in an array list.
 * 
 * @author Abdulrahman
 */
public interface Instructions {
    
    /**
     * Instructions for the ant to sense its cells.
     */
    public class Sense implements Instructions {
        sense_dir p;
        int st1;
        int st2;
        Condition c;
        int markerNum;
        /**
         * @param x The direction the ant will be facing when 'sensing'
         * @param stateNum1 State in the FSA
         * @param stateNum2 State in the FSA
         * @param cond The cell's condition
         */
        public Sense(sense_dir x, int stateNum1, int stateNum2, Condition cond) {
            this.p = x;
            this.st1 = stateNum1;
            this.st2 = stateNum2;
            this.c = cond;
        }
        
        /**
         * @param x The direction the ant will be facing when 'sensing'
         * @param stateNum1 State in the FSA
         * @param stateNum2 State in the FSA
         * @param cond The cell's condition
         * @param afterMarker The number of the marker
         */
        Sense(sense_dir x, int stateNum1, int stateNum2, Condition cond, int afterMarker) {
            this.p = x;
            this.st1 = stateNum1;
            this.st2 = stateNum2;
            this.c = cond;
            this.markerNum = afterMarker;
        }
    }
    
    /**
     * Instructions for the ant to mark a cell
     */
    public class Mark implements Instructions {

        Markers i;
        int st;
        /**
         * @param The type of marker to place
         * @param stateNum The state in the FSA
         */
        public Mark(Markers x, int stateNum) {
            this.i = x;
            this.st = stateNum;
        }
    }
    
    /**
     * Instructions for the ant to unmark a cell
     */
     public class UnMark implements Instructions {
        Markers i;
        int st;
        
        /**
         * @param x The marker to remove
         * @param stateNum The state in the FSA
         */
        public UnMark(Markers x, int stateNum) {
            this.i = x;
            this.st = stateNum;
        }
    }
    
    /**
     * Instructions for an ant to pick up food.
     */
    public class PickUp implements Instructions {
        int st1;
        int st2;
        /**
         * @param stateNum1 State in the FSA
         * @param stateNum2 State in the FSA
         */
        public PickUp(int stateNum1, int stateNum2) {
            this.st1 = stateNum1;
            this.st2 = stateNum2;
        }
    }
    
    /**
     * Instructions for an ant to drop its food
     */
    public class Drop implements Instructions {
        int st;
        /**
         * @param stateNum State in the FSA
         */
        public Drop(int stateNum) {
            this.st = stateNum;
        }
    }
    
    /**
     * Instructions for the ant to turn
     */
    public class Turn implements Instructions {
        Left_or_Right lr;
        int st2;
        /**
         * @param lr The value 'Left' or 'Right'
         * @param stateNum
         */
        public Turn(Left_or_Right lr, int stateNum) {
            this.lr = lr;
            this.st2 = stateNum;
        }
    }
    
    /**
     * Instructions for the ant to move
     */
    public class Move implements Instructions {
        int st1;
        int st2;
        /**
         * @param stateNum1
         * @param stateNum2
         */
        public Move(int stateNum1, int stateNum2) {
            this.st1 = stateNum1;
            this.st2 = stateNum2;
        }
    }
    
    /**
     * Pick a random number, and change state depending on whether x = 0 or not.
     */
    public class Flip implements Instructions {
        int p;
        int st1;
        int st2;
        /**
         * @param x The random number
         * @param stateNum1 Go to this state if x = 0
         * @param stateNum2 Go to this state otherwise
         */
         public Flip(int x, int stateNum1, int stateNum2) {
            this.p = x;
            this.st1 = stateNum1;
            this.st2 = stateNum2;
        }

    }
}
