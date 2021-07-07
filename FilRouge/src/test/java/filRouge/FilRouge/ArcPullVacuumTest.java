package filRouge.FilRouge;

import junit.framework.TestCase;

public class ArcPullVacuumTest extends TestCase {

	public void testSetMultiplicity() {
		PlaceClass place = new PlaceClass(0);
		ArcPullVacuum arc = new ArcPullVacuum(place);

		boolean hasThrown = false;
		try {
			arc.setMultiplicity(4);
		} catch (UnsupportedOperationException e) {
			// arcPullVacuums do not have any multiplicity
			hasThrown = true;
		}
		assertTrue(hasThrown);
	}

}
