package filRouge.FilRouge;

public class PlaceClass implements Place {

	private int counter;

	public PlaceClass(int counter) {
		super();
		this.counter = counter;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int c) {
		this.counter = c;
	}

	public void addCounter(int c) {
		this.counter += c;
	}

	public void removeCounter(int c) {
		this.counter -= c;
	}

}
