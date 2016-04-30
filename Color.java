package antgame;

public enum Color {
	RED, BLACK;
	
	//method to return the opposite color
	public Color other_color(Color c){
		if(c.equals(Color.RED)){
			return Color.BLACK;
		}else{
			return Color.RED;
		}
	}

	
}

