package filRouge.FilRouge;

import junit.framework.TestCase;

public class ArcPullZeroTest extends TestCase {

	public void testSetMultiplicity() {
		PlaceClass place = new PlaceClass(0);
		ArcPullZero arc = new ArcPullZero(place);

		boolean hasThrown = false;
		try {
			arc.setMultiplicity(4);
		} catch (UnsupportedOperationException e) {
			// arcPullZeros do not have any multiplicity
			hasThrown = true;
		}
		assertTrue(hasThrown);
	}
}
