package filRouge.FilRouge;

/**
 * This class defines the execution of the ArcPush operations, and implement the
 * methods needed by TransitionClass.
 */

class ArcPushClass implements ArcPush {
	private int multiplicity;
	private PlaceClass place;

	ArcPushClass(PlaceClass p, int m) {
		this.multiplicity = m;
		this.place = p;
	}

	public void setMultiplicity(int m) throws UnsupportedOperationException {
		this.multiplicity = m;
	}

	public void pushCounter() {
		this.place.addCounter(multiplicity);
	}

	public boolean placeEquals(Object other) {
		return place == other;
	}
}
