package filRouge.FilRouge;

import junit.framework.TestCase;

public class PetriNetClassTest extends TestCase {

	public void testCreatePlace() {
		PetriNetClass petri = new PetriNetClass();
		Place place = petri.createPlace();
		assertEquals(place.getCounter(), 0);
		place.setCounter(3);
		assertEquals(place.getCounter(), 3);
	}

	public void testCreateTransition() {
		PetriNetClass petri = new PetriNetClass();
		Transition transition = petri.createTransition();
		assertTrue(transition.pullable());
		transition.pull();
		assertTrue(transition.pullable());
	}

	public void testCreateArcPush() {
		PetriNetClass petri = new PetriNetClass();
		Place place = petri.createPlace();
		Transition transition = petri.createTransition();
		petri.createArcPush(place, transition, 3);

		transition.pull();
		assertEquals(place.getCounter(), 3);
		transition.pull();
		assertEquals(place.getCounter(), 6);
	}

	public void testCreateArcPullMultiplicity() {
		PetriNetClass petri = new PetriNetClass();
		Place place = petri.createPlace();
		Transition transition = petri.createTransition();
		petri.createArcPullMultiplicity(place, transition, 3);

		place.setCounter(3);
		assertEquals(place.getCounter(), 3);
		assertTrue(transition.pullable());
		transition.pull();
		assertEquals(place.getCounter(), 0);
		assertFalse(transition.pullable());
		transition.pull();
		assertEquals(place.getCounter(), -3);
		assertFalse(transition.pullable());
		transition.pull();
		assertEquals(place.getCounter(), -6);
		assertFalse(transition.pullable());
	}

	public void testCreateArcPullZero() {
		PetriNetClass petri = new PetriNetClass();
		Place place = petri.createPlace();
		Transition transition = petri.createTransition();
		petri.createArcPullZero(place, transition);

		place.setCounter(3);
		assertFalse(transition.pullable());
		transition.pull();
		assertEquals(place.getCounter(), 3);
		place.setCounter(0);
		assertTrue(transition.pullable());
		transition.pull();
		assertEquals(place.getCounter(), 0);
		place.setCounter(-1);
		assertFalse(transition.pullable());
	}

	public void testCreateArcPullVacuum() {
		PetriNetClass petri = new PetriNetClass();
		Place place = petri.createPlace();
		Transition transition = petri.createTransition();
		petri.createArcPullVacuum(place, transition);

		place.setCounter(3);
		assertTrue(transition.pullable());
		transition.pull();
		assertEquals(place.getCounter(), 0);
		assertFalse(transition.pullable());
		transition.pull();
		assertFalse(transition.pullable());
		place.setCounter(-1);
		assertFalse(transition.pullable());
	}

	public void testDeleteArcPush() {
		PetriNetClass petri = new PetriNetClass();
		Place place = petri.createPlace();
		Transition transition = petri.createTransition();
		ArcPush arc = petri.createArcPush(place, transition, 3);
		transition.pull();
		assertEquals(place.getCounter(), 3);
		transition.pull();
		assertEquals(place.getCounter(), 6);
		petri.deleteArcPush(arc);
		assertEquals(place.getCounter(), 6);
		transition.pull();
		assertEquals(place.getCounter(), 6);

		boolean hasThrown = false;
		try {
			petri.deleteArcPush(arc);
		} catch (RuntimeException e) {
			// "Unmanaged arcPush"
			hasThrown = true;
		}
		assertTrue(hasThrown);
	}

	public void testDeleteArcPull() {
		PetriNetClass petri = new PetriNetClass();
		Place place = petri.createPlace();
		Transition transition = petri.createTransition();
		ArcPull arc = petri.createArcPullMultiplicity(place, transition, 3);
		place.setCounter(-3);
		assertEquals(place.getCounter(), -3);
		assertFalse(transition.pullable());
		transition.pull();
		assertEquals(place.getCounter(), -6);
		assertFalse(transition.pullable());
		petri.deleteArcPull(arc);
		assertEquals(place.getCounter(), -6);
		assertTrue(transition.pullable());
		transition.pull();
		assertEquals(place.getCounter(), -6);
		assertTrue(transition.pullable());

		boolean hasThrown = false;
		try {
			petri.deleteArcPull(arc);
		} catch (RuntimeException e) {
			// "Unmanaged place"
			hasThrown = true;
		}
		assertTrue(hasThrown);
	}

	public void testDeletePlace() {
		PetriNetClass petri = new PetriNetClass();
		{
			Place place = petri.createPlace();
			petri.deletePlace(place);

			boolean hasThrown = false;
			try {
				petri.deletePlace(place);
			} catch (RuntimeException e) {
				// "Unmanaged place"
				hasThrown = true;
			}
			assertTrue(hasThrown);
		}

		{
			Place place = petri.createPlace();
			Transition transition = petri.createTransition();
			ArcPush arc = petri.createArcPush(place, transition, 3);

			boolean hasThrown = false;
			try {
				petri.deletePlace(place);
			} catch (RuntimeException e) {
				// "Trying to remove a place that is still used by some arc."
				hasThrown = true;
			}
			assertTrue(hasThrown);

			petri.deleteArcPush(arc);
			petri.deletePlace(place);
		}
	}

	public void testDeleteTransition() {
		PetriNetClass petri = new PetriNetClass();
		{
			Transition transition = petri.createTransition();
			petri.deleteTransition(transition);
		}
		{
			Place place = petri.createPlace();
			Transition transition = petri.createTransition();
			ArcPush arc = petri.createArcPush(place, transition, 3);

			boolean hasThrown = false;
			try {
				petri.deleteTransition(transition);
			} catch (RuntimeException e) {
				// "Trying to remove a transition that is still used by some arc."
				hasThrown = true;
			}
			assertTrue(hasThrown);

			petri.deleteArcPush(arc);
			petri.deleteTransition(transition);
		}
	}

	public void testSingleStep() {
		PetriNetClass petri = new PetriNetClass();
		{
			Transition transition = petri.createTransition();
			petri.singleStep();
			petri.deleteTransition(transition);
		}
		{
			boolean hasThrown = false;
			try {
				petri.singleStep();
			} catch (RuntimeException e) {
				// "Trying to do a step while no transition is pullable."
				hasThrown = true;
			}
			assertTrue(hasThrown);
		}
		{
			Place place = petri.createPlace();
			Transition transition = petri.createTransition();
			petri.createArcPullZero(place, transition);

			place.setCounter(0);
			petri.singleStep();

			place.setCounter(4);
			boolean hasThrown = false;
			try {
				petri.singleStep();
			} catch (RuntimeException e) {
				// "Trying to do a step while no transition is pullable."
				hasThrown = true;
			}
			assertTrue(hasThrown);
		}
	}

	public void testLoopStep() {
		PetriNetClass petri = new PetriNetClass();
		Place place = petri.createPlace();
		Transition transition = petri.createTransition();
		petri.createArcPullMultiplicity(place, transition, 2);

		assertEquals(petri.loopStep(), 0);
		place.setCounter(10);
		assertEquals(petri.loopStep(), 5);
		assertEquals(petri.loopStep(), 0);
	}

}
