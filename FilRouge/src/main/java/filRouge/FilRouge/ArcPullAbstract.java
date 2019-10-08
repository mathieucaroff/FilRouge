package filRouge.FilRouge;

public abstract class ArcPullAbstract implements ArcPull {
    public abstract boolean active();
    public abstract void pullCounter();
    public void setMultiplicity(int m) {
        throw new UnsupportedOperationException();
    }
}
