package filRouge.FilRouge;

public class ArcPushClass implements ArcPush {
	int multiplicity;
	PlaceClass place;
	public ArcPushClass(PlaceClass p,int m){
		this.multiplicity = m;
		this.place = p;
	}
	public void setMultiplicity(int m) throws UnsupportedOperationException {
		this.multiplicity = m;
	}
	public void pushCounter() {
		this.place.addCounter(multiplicity); 
	}
	public boolean placeEquals(Object other) {
		return place == other;
	}
}
