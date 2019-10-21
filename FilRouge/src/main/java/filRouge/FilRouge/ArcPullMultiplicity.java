package filRouge.FilRouge;

class ArcPullMultiplicity extends ArcPullAbstract {
	private int multiplicity = 1;

	ArcPullMultiplicity(PlaceClass place, int multiplicity) {
		super(place);
		this.multiplicity = multiplicity;
	}

	public boolean active() {
		return getPlace().getCounter() >= multiplicity;
	}

	public void pullCounter() {
		getPlace().removeCounter(multiplicity);
	}

	public void setMultiplicity(int m) {
		this.multiplicity = m;
	}

	int getMultiplicity() {
		return multiplicity;
	}
}
