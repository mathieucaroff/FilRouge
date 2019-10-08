package filRouge.FilRouge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class ArcPullAbstract implements ArcPull {
    public abstract boolean active();
    public abstract void pullCounter();
    public void setMultiplicity(int m) {
        throw NotImplementedException;
    }
}
