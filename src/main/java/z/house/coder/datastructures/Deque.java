package z.house.coder.datastructures;

import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;

/**
 * Interface for Double Ended Queue
 * 
 * @author coder
 *
 * @param <T>
 */
public interface Deque<T> {
	
	public void insertFirst(T element) throws Full;
	
	public void insertLast(T element) throws Full;
	
	public T removeFirst() throws Empty;
	
	public T removeLast() throws Empty;
	
	public T first() throws Empty;
	
	public T last() throws Empty;
	
	public int size();
	
	public boolean isEmpty();

}
