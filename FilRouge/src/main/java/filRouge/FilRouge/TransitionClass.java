package filRouge.FilRouge;

import java.util.ArrayList;

public class TransitionClass implements Transition {
	private ArrayList<ArcPullAbstract> pull;
	private ArrayList<ArcPushClass> push;
	
	public TransitionClass(ArrayList<ArcPullAbstract> pull, ArrayList<ArcPushClass> push) {
		super();
		this.pull = pull;
		this.push = push;
	}

	public boolean pullable() {
		boolean result = true;
		for (ArcPullAbstract arc: pull) {
			if (!arc.active()) {
				result = false;
				break;
			}
		}
		return result;
	}

	public void pull() {
		for(ArcPullAbstract arc: pull) {
			arc.pullCounter();
		}
		for (ArcPushClass arc: push) {
			arc.pushCounter();
		}
	}	
	
}
