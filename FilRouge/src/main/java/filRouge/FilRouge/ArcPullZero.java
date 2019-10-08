package filRouge.FilRouge;

public class ArcPullZero extends ArcPullMultiplicity {
    ArcPullZero(PlaceClass place) {
        super(place, 0);
    }

    public boolean active() {
        return getPlace().getCounter() == getMultiplicity();
    }

    @Override
    public void setMultiplicity(int m) {
        throw new UnsupportedOperationException();
    }
}
