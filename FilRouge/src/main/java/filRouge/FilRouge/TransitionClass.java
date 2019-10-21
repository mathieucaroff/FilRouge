package filRouge.FilRouge;

import java.util.ArrayList;

class TransitionClass implements Transition {
	private ArrayList<ArcPullAbstract> pull;
	private ArrayList<ArcPushClass> push;

	public TransitionClass(ArrayList<ArcPullAbstract> pull, ArrayList<ArcPushClass> push) {
		super();
		this.pull = pull;
		this.push = push;
	}

	public boolean pullable() {
		boolean result = true;
		for (ArcPullAbstract arc : pull) {
			if (!arc.active()) {
				result = false;
				break;
			}
		}
		return result;
	}

	public void pull() {
		for (ArcPullAbstract arc : pull) {
			arc.pullCounter();
		}
		for (ArcPushClass arc : push) {
			arc.pushCounter();
		}
	}

	public void addArcPull(ArcPullAbstract arc) {
		pull.add(arc);
	}

	public void addArcPush(ArcPushClass arc) {
		push.add(arc);
	}

	public boolean empty() {
		return pull.size() == 0 && push.size() == 0;
	}

	public void maybeRemoveArcPush(ArcPushClass arc) {
		push.remove(arc);
	}

	public void maybeRemoveArcPull(ArcPullAbstract arc) {
		pull.remove(arc);
	}
}
