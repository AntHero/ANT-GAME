/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame;

/**
 *This is an interface which links all the seven instruction under it.
 *This will be used in the brain parser to store the text file of the brain in an array list.
 */
public interface Instructions {

    public class Sense implements Instructions {
        sense_dir p;
        int st1;
        int st2;
        condition c;
        int markerNum;
        public Sense(sense_dir x, int stateNum1, int stateNum2, condition cond) {
            this.p = x;
            this.st1 = stateNum1;
            this.st2 = stateNum2;
            this.c = cond;
        }

        Sense(sense_dir x, int stateNum1, int stateNum2, condition cond, int afterMarker) {
            this.p = x;
            this.st1 = stateNum1;
            this.st2 = stateNum2;
            this.c = cond;
            this.markerNum = afterMarker;
        }
    }

    public class Mark implements Instructions {

        Markers i;
        int st;
        public Mark(Markers x, int stateNum) {
            this.i = x;
            this.st = stateNum;
        }
    }

    public class UnMark implements Instructions {
        Markers i;
        int st;
        public UnMark(Markers x, int stateNum) {
            this.i = x;
            this.st = stateNum;
        }
    }

    public class PickUp implements Instructions {
        int st1;
        int st2;
        public PickUp(int stateNum1, int stateNum2) {
            this.st1 = stateNum1;
            this.st2 = stateNum2;
        }
    }

    public class Drop implements Instructions {
        int st;
        public Drop(int stateNum) {
            this.st = stateNum;
        }
    }

    public class Turn implements Instructions {
        Left_or_Right lr;
        int st2;
        public Turn(Left_or_Right lr, int stateNum) {
            this.lr = lr;
            this.st2 = stateNum;
        }
    }

    public class Move implements Instructions {
        int st1;
        int st2;
        public Move(int stateNum1, int stateNum2) {
            this.st1 = stateNum1;
            this.st2 = stateNum2;
        }
    }

    public class Flip implements Instructions {
        int p;
        int st1;
        int st2;
        public Flip(int x, int stateNum1, int stateNum2) {
            this.p = x;
            this.st1 = stateNum1;
            this.st2 = stateNum2;
        }

    }
}
