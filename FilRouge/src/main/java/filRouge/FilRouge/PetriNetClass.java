package filRouge.FilRouge;

import java.util.ArrayList;
import java.util.Random;

public class PetriNetClass implements PetriNet {

	private ArrayList<PlaceClass> placeList;
	private ArrayList<TransitionClass> transitionList;
	private ArrayList<ArcPushClass> arcPushList;
	private ArrayList<ArcPullAbstract> arcPullList;

	public PetriNetClass(ArrayList<PlaceClass> placeList, ArrayList<TransitionClass> transitionList,
			ArrayList<ArcPullAbstract> arcPullList, ArrayList<ArcPushClass> arcPushList) {
		super();
		this.placeList = placeList;
		this.transitionList = transitionList;
		this.arcPullList = arcPullList;
		this.arcPushList = arcPushList;
	}

	@Override
	public Place createPlace() {
		PlaceClass place = new PlaceClass();
		placeList.add(place);
		return place;
	}

	@Override
	public Transition createTransition() {
		TransitionClass transition = new TransitionClass(new ArrayList<ArcPullAbstract>(), new ArrayList<ArcPushClass>());
		transitionList.add(transition);
		return transition;
	}

	public ArcPush createArcPush(Place place, Transition transition, int multiplicity) {
		PlaceClass placeC = placeCast(place);
		TransitionClass transitionC = transitionCast(transition);

		ArcPushClass arc = new ArcPushClass(placeC, multiplicity);

		transitionC.addArcPush(arc);

		return arc;
	}

	private interface ArcPullFactory {
		ArcPullAbstract create(PlaceClass p);
	}

	private ArcPull createArcPull(Place place, Transition transition, ArcPullFactory b) {
		PlaceClass placeC = placeCast(place);
		TransitionClass transitionC = transitionCast(transition);

		ArcPullAbstract arc = b.create(placeC);

		transitionC.addArcPull(arc);

		return arc;
	}

	@Override
	public ArcPull createArcPullMultiplicity(Place p, Transition t, int multiplicity) throws RuntimeException {
		return createArcPull(p, t,
			(PlaceClass placeC) -> new ArcPullMultiplicity(placeC, multiplicity)
		);
	}

	@Override
	public ArcPull createArcPullZero(Place p, Transition t) {
		return createArcPull(p, t,
			(PlaceClass placeC) -> new ArcPullZero(placeC)
		);
	}

	@Override
	public ArcPull createArcPullVacuum(Place p, Transition t) {
		return createArcPull(p, t,
			(PlaceClass placeC) -> new ArcPullVacuum(placeC)
		);
	}

	@Override
	public void deleteArcPush(ArcPush arc) {
		ArcPushClass arcC = arcPushCast(arc);
		for (TransitionClass transition: transitionList) {
			transition.maybeRemoveArcPush(arcC);
		}
		arcPushList.remove(arc);
	}

	@Override
	public void deleteArcPull(ArcPull arc) {
		ArcPullAbstract arcC = arcPullCast(arc);
		for (TransitionClass transition: transitionList) {
			transition.maybeRemoveArcPull(arcC);
		}
		arcPullList.remove(arc);
	}

	@Override
	public void deletePlace(Place p) {
		PlaceClass placeC = placeCast(p);
		for (ArcPushClass arc: arcPushList) {
			if (arc.placeEquals(placeC)) {
				throw new RuntimeException(
					"Trying to remove a place that is still used by some arc."
				);
			}
		}
		for (ArcPullAbstract arc: arcPullList) {
			if (arc.placeEquals(placeC)) {
				throw new RuntimeException(
					"Trying to remove a place that is still used by some arc."
				);
			}
		}
		placeList.remove(placeC);
	}

	@Override
	public void deleteTransition(Transition t) {
		TransitionClass transitionC = transitionCast(t);
		if (!transitionC.empty()) {
			throw new RuntimeException(
				"Trying to remove a transition that still has arcs attached."
			);
		}
		transitionList.remove(transitionC);
	}

	@Override
	public void singleStep() throws RuntimeException {
		ArrayList<TransitionClass> pullable = new ArrayList<TransitionClass>();
		for (TransitionClass transition: transitionList) {
			if (transition.pullable()) {
				pullable.add(transition);
			}
		}
		if (pullable.size() == 0) {
			throw new RuntimeException(
				"Trying to do a step while no transition is pullable."
			);
		}
		Random rand = new Random();
		TransitionClass transition = pullable.get(rand.nextInt(pullable.size()));
		transition.pull();
	}

	@Override
	public int loopStep() {
		int counter = 0;
		try {
			while (true) {
				singleStep();
				counter++;
			}
		} catch (RuntimeException e) {}
		return counter;
	}

	private PlaceClass placeCast(Place place) {
		PlaceClass placeC;
		if (!(place instanceof PlaceClass)) {
			throw new RuntimeException("Unhandleded place implementation");
		} else {
			if (!placeList.contains(place)) {
				throw new RuntimeException("Unmanaged place");
			} else {
				placeC = (PlaceClass) place;
			}
		}
		return placeC;
	}

	private TransitionClass transitionCast(Transition transition) {
		TransitionClass transitionC;
		
		if (!(transition instanceof TransitionClass)) {
			throw new RuntimeException("Unhandleded transition implementation");
		} else if (!transitionList.contains(transition)) {
			throw new RuntimeException("Unmanaged transition");
		} else {
			transitionC = (TransitionClass) transition;
		}
		return transitionC;
	}
	
	private ArcPushClass arcPushCast(ArcPush arc) {
		ArcPushClass arcC;
		
		if (!(arc instanceof ArcPushClass)) {
			throw new RuntimeException("Unhnadled arcPush implementation");
		} else if (!arcPushList.contains(arc)) {
			throw new RuntimeException("Unmanaged arcPush");
		} else {
			arcC = (ArcPushClass) arc;
		}
		return arcC;
	}
	
	private ArcPullAbstract arcPullCast(ArcPull arc) {
		ArcPullAbstract arcC;
		
		if (!(arc instanceof ArcPullAbstract)) {
			throw new RuntimeException("Unhnadled arcPull implementation");
		} else if (!arcPullList.contains(arc)) {
			throw new RuntimeException("Unmanaged arcPull");
		} else {
			arcC = (ArcPullAbstract) arc;
		}

		return arcC;
	}
}
