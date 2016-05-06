package antgame;

import java.io.FileNotFoundException;

import org.junit.Test;

import junit.framework.TestCase;

public class WorldTest extends TestCase {
	public WorldTest(){
		
	}
	
	@Test
	public void testSomeAntAt_antAt_setAntAt_clearAntAt() throws FileNotFoundException{
		Position p = new Position(1,1);
		Ant a = new Ant(0, Color.RED);
		World w = new World();
		w.randomWorld("rw", 0);
		assertFalse(w.someAntAt(p));
		assert(w.antAt(p)==null);		
		w.setAntAt(p, a);
		assertTrue(w.someAntAt(p));
		assertEquals(w.antAt(p), a);		
		w.clearAntAt(p);
		assertFalse(w.someAntAt(p));
		assert(w.antAt(p)==null);			
	}
	
	public void test_findAnt_antHillAt_antIsAlive_() throws FileNotFoundException{
		World w = new World();
		w.randomWorld("rw", 0);
		Position p = w.findAnt(0);
		Ant a = w.antAt(p);
		assert(w.anthillAt(p, a.getColor()));
		assertTrue(w.antIsAlive(0));
		
		w.killAntAt(p);
		assertFalse(w.antIsAlive(0));
	}
	
	public void testfoodAt_setfoodAt() throws FileNotFoundException{
		World w = new World();
		w.randomWorld("rw", 0);
		Position p = new Position(1,1);
		
		assert(w.foodAt(p)==0);
		w.setFoodAt(p, 5);
		assert(w.foodAt(p)!=0);		
	}
	
}
