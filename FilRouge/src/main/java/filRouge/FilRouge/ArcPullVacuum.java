package filRouge.FilRouge;

public class ArcPullVacuum implements ArcPull {
    private PlaceClass place;

    ArcPullVacuum(PlaceClass place) {
        this.place = place;
    }

    public boolean active() {
        return place.getCounter() > 0;
    }

    public void pullCounter() {
        place.removeCounter(place.getCounter());
    }

    @Override
    public void setMultiplicity(int m) {
        this.muliplicity = m;
    }
}
