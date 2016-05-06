package antgame;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class AntTest extends TestCase {
	Ant a = new Ant(0, Color.RED);

	public AntTest() {

	}

	@Test
	public void testAntContructDirection() {
		assert(a.getDirection() == 0);
	}

	public void testTurn() {
		assert(a.turn(LoR.Left, 0) == 5);
		assert(a.turn(LoR.Right, 0) == 1);
	}

	public void testSensedCell(){
		//odd x axis
		assertEquals(a.sensedCell(new Position(1,1), 0, Sense_dir.Here), new Position(1,1));
		assertEquals(a.sensedCell(new Position(1,1), 0, Sense_dir.Ahead), new Position(2,1));
		assertEquals(a.sensedCell(new Position(1,1), 0, Sense_dir.LeftAhead), new Position(2,0));
		assertEquals(a.sensedCell(new Position(1,1), 0, Sense_dir.RightAhead), new Position(2,2));

		//even x axis
		assertEquals(a.sensedCell(new Position(2,2), 0, Sense_dir.Here), new Position(2, 2));
		assertEquals(a.sensedCell(new Position(2,2), 0, Sense_dir.Ahead), new Position(3, 2));
		assertEquals(a.sensedCell(new Position(2,2), 0, Sense_dir.LeftAhead), new Position(2,1));
		assertEquals(a.sensedCell(new Position(2,2), 0, Sense_dir.RightAhead),new Position(2,3));
	}
}
