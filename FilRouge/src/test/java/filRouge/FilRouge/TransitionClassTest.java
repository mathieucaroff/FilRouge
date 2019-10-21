package filRouge.FilRouge;

import junit.framework.TestCase;

public class TransitionClassTest extends TestCase {
	void testPullable() {
		TransitionClass transition = new TransitionClass();
		assertTrue(transition.pullable());
		PlaceClass place = new PlaceClass(0);
		ArcPullAbstract arc = new ArcPullMultiplicity(place, 2);
		transition.addArcPull(arc);
		assertFalse(transition.pullable());
	}

	void testPull() {
		TransitionClass transition = new TransitionClass();
		PlaceClass place = new PlaceClass(10);
		ArcPullAbstract arc = new ArcPullMultiplicity(place, 2);
		transition.addArcPull(arc);
		transition.pull();
		assertEquals(place.getCounter(), 8);
		transition.pull();
		transition.pull();
		transition.pull();
		assertEquals(place.getCounter(), 2);
	}
}
