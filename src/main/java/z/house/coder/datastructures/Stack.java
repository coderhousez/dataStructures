package z.house.coder.datastructures;

public interface Stack<T> {
	
	/**
	 * Adds item to the top of the Stack.
	 * 
	 * @param item
	 */
	public void push(T item);
	
	/**
	 * Removes item from top of the Stack.
	 * @return
	 */
	public T pop();
	
	/**
	 * Returns count of items in the Stack.
	 * @return
	 */
	public int count();
}
