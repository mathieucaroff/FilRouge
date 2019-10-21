package filRouge.FilRouge;

/**
 * This class holds the generic operations on ArcPull objects and what can
 * be factorized between all children classes.
 */

abstract class ArcPullAbstract implements ArcPull {
	private PlaceClass place;

	ArcPullAbstract(PlaceClass place) {
		this.place = place;
	}

	public abstract boolean active();

	public abstract void pullCounter();

	public void setMultiplicity(int m) {
		throw new UnsupportedOperationException();
	}

	public boolean placeEquals(PlaceClass other) {
		return place == other;
	}

	PlaceClass getPlace() {
		return place;
	}
}
