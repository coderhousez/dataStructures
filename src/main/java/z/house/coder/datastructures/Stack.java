package z.house.coder.datastructures;

import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;

public interface Stack<T> {
	
	/**
	 * Adds item to the top of the Stack.
	 * 
	 * @param item
	 */
	public void push(T item) throws Full;
	
	/**
	 * Removes item from top of the Stack.
	 * @return
	 */
	public T pop() throws Empty;
	
	/**
	 * Returns count of items in the Stack.
	 * @return
	 */
	public int count();
}
