package antgame;

import java.util.Random;

public class RandomInt {
	public RandomInt() {

	}

	
	public int randomint(int n, int seed) {
		Random r = new Random();
		r.setSeed(seed);
		return r.nextInt(n);	//returns from 0 to n inclusive. so maybe add +1 to n?
		
	}

	// THIS METHOD DOES NOT WORK AS OF YET, NEED HELP!
	// Could not get his math stuff to work
	// instead just using Random java class

	// public int randomint(int n, int seed) {
	// int init = seed;
	// int xSeries = 0;
	//
	// for (int i = 0; i < n; i++) {
	// init = init * 22695477 + 1;
	// if (i >= 4) {
	// xSeries = (init / 65536) % 16384;
	// if (i == 4) {
	// System.out.println(xSeries);
	// }
	//
	// }
	// }
	// return xSeries % n;
}
