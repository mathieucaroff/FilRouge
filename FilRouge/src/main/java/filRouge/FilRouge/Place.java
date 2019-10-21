package filRouge.FilRouge;

/**
 * This interface defines the operations accessible a user can use on a Place.
 */

 /**
  * A place is an element of the Petri network which can hold counters.
  */
public interface Place {

	int getCounter();
	void setCounter(int c);

}
