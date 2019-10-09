package filRouge.FilRouge;

public abstract class ArcPullAbstract implements ArcPull {
	private PlaceClass place;

	ArcPullAbstract (PlaceClass place) {
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

	protected PlaceClass getPlace() {
		return place;
	}
}
