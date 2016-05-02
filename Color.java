package antgame;

public enum Color {
	RED, BLACK;
	
	//method to return the opposite color
	//not sure why I had to make this static
	public static Color otherColor(Color c){
		if(c.equals(Color.RED)){
			return Color.BLACK;
		}else{
			return Color.RED;
		}
	}

	
}

