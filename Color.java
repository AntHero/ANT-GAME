package antgame;

public enum Color {
	RED, BLACK;
	
	public Color other_color(Color c){
		if(c.equals(Color.RED)){
			return Color.BLACK;
		}else{
			return Color.RED;
		}
	}

	
}

//public class Color {
//	ColorType ct;
//	
//	public Color(ColorType ct){
//		this.ct = ct;
//	}
//}
//
//
//
//	public ColorType other_color(Color c){
//		if(c.getColorType().equals(ColorType.RED)){
//			return ColorType.BLACK;
//		}else{
//			return ColorType.RED;
//		}
//		
//	}
//	
//	public ColorType getColorType(){
//		return ct;
//	}
//	
//}
