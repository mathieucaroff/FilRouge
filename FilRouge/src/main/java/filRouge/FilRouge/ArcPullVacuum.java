package filRouge.FilRouge;

public class ArcPullVacuum extends ArcPullAbstract {
    ArcPullVacuum(PlaceClass place) {
        super(place);
    }

    public boolean active() {
        return getPlace().getCounter() > 0;
    }

    public void pullCounter() {
    	getPlace().removeCounter(getPlace().getCounter());
    }

    @Override
    public void setMultiplicity(int m) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
