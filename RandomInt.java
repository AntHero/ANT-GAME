package antgame;

import java.util.Random;	//uses Random class from java

public class RandomInt {
	public RandomInt() {

	}
	
	//paramaters take an int n for the number you want to return from 0 to n (inclusive)
	//int seed to ensure dependability for tests
	public int randomint(int n, int seed) {
		Random r = new Random();
		r.setSeed(seed);
		return r.nextInt(n);	//returns from 0 to n inclusive. so maybe add +1 to n?
		
	}
}
	
	
	//HIS DIRECTIONS SD MADE NO SENSE, IF YOU WANT TO FIGURE IT OUT GO AHEAD!

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
