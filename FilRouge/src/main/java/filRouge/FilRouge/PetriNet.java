package filRouge.FilRouge;

public interface PetriNet {
	Place createPlace();
	Transition createTransition();
	ArcPull createArcPullMultiplicity(Place p, Transition t,int c);
	ArcPull createArcPullZero(Place p, Transition t);
	ArcPull createArcPullVacuum(Place p, Transition t);
	ArcPush createArcPush(Place p, Transition t, int c);
	void deleteArcPull(ArcPull arcpull);
	void deleteArcPush(ArcPush arcpush);
	void deletePlace(Place p);
	void deleteTransition(Transition t);
	void singleStep() throws RuntimeException;
	int loopStep();
}
