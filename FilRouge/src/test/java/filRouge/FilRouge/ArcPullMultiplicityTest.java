package filRouge.FilRouge;

import junit.framework.TestCase;

public class ArcPullMultiplicityTest extends TestCase {
	public void testActive() {
		PlaceClass place = new PlaceClass(2);
		ArcPullAbstract arc0 = new ArcPullMultiplicity(place, 0);
		ArcPullAbstract arc1 = new ArcPullMultiplicity(place, 1);
		ArcPullAbstract arc2 = new ArcPullMultiplicity(place, 2);
		ArcPullAbstract arc3 = new ArcPullMultiplicity(place, 3);
		ArcPullAbstract arc4 = new ArcPullMultiplicity(place, 4);
		ArcPullAbstract arc5 = new ArcPullMultiplicity(place, 5);
		assertTrue(arc0.active());
		assertTrue(arc1.active());
		assertTrue(arc2.active());
		assertFalse(arc3.active());
		assertFalse(arc4.active());
		assertFalse(arc5.active());
	}

	public void testPullCounter() {
		PlaceClass place = new PlaceClass(2);
		ArcPullMultiplicity arc = new ArcPullMultiplicity(place, 1);
		assertEquals(arc.getPlace().getCounter(), 2);
		arc.pullCounter();
		assertEquals(arc.getPlace().getCounter(), 1);
	}

	public void testSetMultiplicity() {
		PlaceClass place = new PlaceClass(0);
		ArcPullMultiplicity arc = new ArcPullMultiplicity(place, 1);
		arc.setMultiplicity(4);
		arc.pullCounter();
		assertEquals(arc.getPlace().getCounter(), -4);
	}
}
