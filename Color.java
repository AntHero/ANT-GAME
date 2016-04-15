package antgame;

public class Color {
	ColorType ct;
	
	public Color(ColorType ct){
		this.ct = ct;
	}

	public ColorType other_color(Color c){
		if(c.getColorType().equals(ColorType.RED)){
			return ColorType.BLACK;
		}else{
			return ColorType.RED;
		}
		
	}
	
	public ColorType getColorType(){
		return ct;
	}
	
}
