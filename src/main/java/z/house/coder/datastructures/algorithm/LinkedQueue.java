package z.house.coder.datastructures.algorithm;

import z.house.coder.datastructures.Queue;
import z.house.coder.datastructures.algorithm.extra.LinkedList;
import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;

public class LinkedQueue<T> implements Queue<T> {
	
	LinkedList<T> linkedList;
	
	public LinkedQueue(){
		linkedList = null;
	}

	@Override
	public void enqueue(T item) throws Full {
		if(linkedList == null) {
			linkedList = new LinkedList<>(item);
		} else {
			linkedList.insertLast(item);
		}
	}

	@Override
	public T dequeue() throws Empty {
		if(linkedList == null) {
			throw new Empty();
		}
		return linkedList.removeFirst();
	}

	@Override
	public T head() throws Empty {
		if(linkedList == null) {
			throw new Empty();
		}
		return linkedList.first();
	}

	@Override
	public int count() {
		if(linkedList == null) {
			return 0;
		}
		return linkedList.size();
	}

}
