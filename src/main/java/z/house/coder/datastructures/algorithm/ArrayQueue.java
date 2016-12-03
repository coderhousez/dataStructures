package z.house.coder.datastructures.algorithm;

import z.house.coder.datastructures.Queue;

/**
 * Simple array based Queue
 *
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {
	
	Object [] queue;
	int head = -1;
	int count = 0;

	public ArrayQueue() {
		queue = new Object[5];
	}
	
	public ArrayQueue(int size) {
		queue = new Object[size];
	}
	
	@Override
	public void enqueue(T item) {
		head = next(head+count);
		queue[head] = item;
		count++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T dequeue() {
		if(count > 0) {
			Object o = head();
			head = next(head);
			count--;
			return (T) o;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T head() {
		return count == 0 ? null : (T) queue[head];
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
