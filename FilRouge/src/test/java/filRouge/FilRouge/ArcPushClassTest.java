package filRouge.FilRouge;

import junit.framework.TestCase;

public class ArcPushClassTest extends TestCase {
	public void testPushCounter() {
		PlaceClass place = new PlaceClass(-2);
		ArcPushClass arc = new ArcPushClass(place, 3);
		assertEquals(place.getCounter(), -2);
		arc.pushCounter();
		assertEquals(place.getCounter(), 1);
		arc.pushCounter();
		assertEquals(place.getCounter(), 4);
		arc.pushCounter();
		assertEquals(place.getCounter(), 7);
		arc.pushCounter();
		assertEquals(place.getCounter(), 10);
	}

	public void testPlaceEquals() {
		PlaceClass placeA = new PlaceClass(2);
		PlaceClass placeB = new PlaceClass(2);
		ArcPushClass arc = new ArcPushClass(placeA, 3);
		assertTrue(arc.placeEquals(placeA));
		assertFalse(arc.placeEquals(placeB));
	}

	public void testSetMultiplicity() {
		PlaceClass place = new PlaceClass(2);
		ArcPushClass arc = new ArcPushClass(place, 10);
		assertEquals(place.getCounter(), 2);
		arc.pushCounter();
		assertEquals(place.getCounter(), 12);
		arc.setMultiplicity(20);
		arc.pushCounter();
		assertEquals(place.getCounter(), 32);
	}
}
