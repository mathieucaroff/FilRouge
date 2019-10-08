package filRouge.FilRouge;

public class ArcPullMultiplicity implements ArcPull {
    private int multiplicity = 1;
    private PlaceClass place;

    ArcPullMultiplicity(PlaceClass place, int multiplicity) {
        this.place = place;
        this.multiplicity = multiplicity;
    }

    public boolean active() {
        return place.getCounter() >= multiplicity;
    }

    public void pullCounter() {
        place.removeCounter(multiplicity);
    }

    public void setMultiplicity(int m) {
        this.multiplicity = m;
    }
}
