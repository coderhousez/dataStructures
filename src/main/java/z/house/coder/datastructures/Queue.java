package z.house.coder.datastructures;

public interface Queue<T> {
	
	/**
	 * Add item to Queue
	 * 
	 * @param item
	 */
	public void enqueue(T item);
	
	/**
	 * Removes item from Queue
	 * 
	 * If Queue is empty, null.
	 * @return T
	 */
	public T dequeue();
	
	/**
	 * Next element to dequeue is returned without removing it.
	 * 
	 * If queue is empty, null.
	 * @return T
	 */
	public T head();
	
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
