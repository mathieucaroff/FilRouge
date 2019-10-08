package filRouge.FilRouge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ArcPullZero extends ArcPullMultiplicity {
    ArcPullZero() {
        super(0);
    }

    public boolean active() {
        return place.getCounter() == multiplicity;
    }

    @Override
    public void setMultiplicity(int m) {
        throw NotImplementedException;
    }
}
