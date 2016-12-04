package z.house.coder.datastructures;

import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;

public interface Queue<T> {
	
	/**
	 * Add item to Queue
	 * 
	 * @param item
	 */
	public void enqueue(T item) throws Full;
	
	/**
	 * Removes item from Queue
	 * 
	 * @return T
	 */
	public T dequeue() throws Empty;
	
	/**
	 * Next element to dequeue is returned without removing it.
	 * 
	 * @return T
	 */
	public T head() throws Empty;
	
	/**
	 * Count of items in the Queue
	 * 
	 * The count is incremented only when enqueue is
	 * called and decremented only when dequeue is called.
	 * 
	 * @return int
	 */
	public int count();

}
