package antgame;

import antgame2.Color;

/**
 * Class which deals with the markers in the simulation.
 * 
 * @author Arco
 * @author Abdulrahman
 */
public class Markers {
	int n;
	Color c;
	//constructor for markers
	//meanings are defined in antbrain or ant I think
	/**
	 * @param n Unique ID for the marker
	 * @param c Color of the marker
	 */
	public Markers(int n, Color c){
		assert(n>=0 && n<=5);
		
		this.n=n;
		this.c=c;
	}
	//for brainParser use.
	Markers(int i) {
        this.n = i;
    }
	
	public int getNumber(){
		return n;
	}
}
