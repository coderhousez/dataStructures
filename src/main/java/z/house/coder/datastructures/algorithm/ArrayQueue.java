package z.house.coder.datastructures.algorithm;

import z.house.coder.datastructures.Queue;
import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;

/**
 * Simple array based Queue
 *
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {
	
	Object [] queue;
	int head =  0;
	int tail = 0;
	int count = 0;

	public ArrayQueue() {
		queue = new Object[5];
	}
	
	public ArrayQueue(int size) {
		queue = new Object[size];
	}
	
	@Override
	public void enqueue(T item) throws Full {
		if(count == queue.length) {
			throw new Full("Exceeding queue size of " + queue.length);
		} else {
			if(count > 0) {
				tail = next(tail);
			}
			queue[tail] = item;
			count++;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T dequeue() throws Empty {
		if(count == 0) {
			throw new Empty();
		}
		Object o = head();
		if(head == tail) {
			head = 0;
			tail = 0;
		} else {
			head = next(head);
		}
		count--;
		return (T) o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T head() throws Empty {
		if(count == 0) {
			throw new Empty();
		}
		return (T) queue[head];
	}

	@Override
	public int count() {
		return count;
	}
	
	/**
	 * @param position
	 * Zero based position
	 * 
	 * @return
	 */
	private int next(int position) {
		if(position < (queue.length - 1)) {
			return position + 1;
		}
		if(position >= (queue.length -1)){
			return (position + count) % queue.length;
		}
		return 0;
	}

}
