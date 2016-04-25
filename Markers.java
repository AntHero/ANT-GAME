package antgame;

public class Markers {
	int n;
	Color c;
	public Markers(int n, Color c){
		assert(n>=0 && n<=5);
		
		this.n=n;
		this.c=c;
	}
}
