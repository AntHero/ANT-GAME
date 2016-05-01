package antgame;
import java.io.FileNotFoundException;
import java.util.Random;


public class MainMethodTestingSuite {
	
	


	public static void main(String[] argv) throws FileNotFoundException {
//		Color r = new Color (RED);
//		Color c = RED;
//		Ant ant = new Ant(1, Color.RED);
//		System.out.println("1");		
//		RockyCell c = new RockyCell(1,1);
//		Cell d = new ClearCell(2,2,3);
//		System.out.println(c.getCellType().getClass().equals(RockyCell.class));		
//		System.out.println(c.getIsRocky());	
//		System.out.println(d.getIsRocky());	
//		System.out.println("");
//		
//		Random r = new Random();
//		r.setSeed(10);
//		System.out.println(r.nextInt(100));
		
		World w = new World();
		w.randomWorld(1);
		w.visualWorld();
//		ClearCell c = (ClearCell)w.getCell(131,63);
//		System.out.println(c.hasAnt());
//		System.out.println(c.getAnt().getId());
		
		
	}
}
