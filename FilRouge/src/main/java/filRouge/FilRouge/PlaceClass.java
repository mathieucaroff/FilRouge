package filRouge.FilRouge;

public class PlaceClass implements Place {

	private int counter;
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int c) {
		this.counter = c;
	}
	
	public void addCounter(int c) {
		this.counter += c; 
	}
	
	public void removeConter(int c){
		this.counter -= c;
	} 

}
