package filRouge.FilRouge;

public class ArcPullMultiplicity extends ArcPullAbstract {
    private int multiplicity = 1;
    private PlaceClass place;

    ArcPullMultiplicity(PlaceClass place, int multiplicity) {
        this.place = place;
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

	public PlaceClass getPlace() {
		return place;
	}
}
