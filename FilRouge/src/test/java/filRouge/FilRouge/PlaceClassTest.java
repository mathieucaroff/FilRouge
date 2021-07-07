package filRouge.FilRouge;

import junit.framework.TestCase;

public class PlaceClassTest extends TestCase {
	public void testGetCounter() {
		assertEquals(new PlaceClass(7).getCounter(), 7);
	}

	public void testSetCounter() {
		PlaceClass p = new PlaceClass(9);
		p.setCounter(3);
		assertEquals(p.getCounter(), 3);
	}

	public void testSetNegCounter() {
		PlaceClass p = new PlaceClass(9);
		p.setCounter(-5);
		assertEquals(p.getCounter(), -5);
	}

	public void testAddCounter() {
		PlaceClass p = new PlaceClass(2);
		p.addCounter(4);
		assertEquals(p.getCounter(), 6);
	}

	public void testAddNegCounter() {
		PlaceClass p = new PlaceClass(2);
		p.addCounter(-4);
		assertEquals(p.getCounter(), -2);
	}

	public void testRemoveCounter() {
		PlaceClass p = new PlaceClass(1);
		p.removeCounter(4);
		assertEquals(p.getCounter(), -3);
	}

	public void testRemoveNegCounter() {
		PlaceClass p = new PlaceClass(1);
		p.removeCounter(-4);
		assertEquals(p.getCounter(), 5);
	}
}
