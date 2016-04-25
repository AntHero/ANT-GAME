package antgame;


public class MainMethodTestingSuite {
	
	


	public static void main(String[] argv) {
//		Color r = new Color (RED);
//		Color c = RED;
//		Ant ant = new Ant(1, Color.RED);
//		System.out.println("1");		
		RockyCell c = new RockyCell(1,1);
		System.out.println(c.getCellType().getClass().equals(RockyCell.class));		
		
	}
}
