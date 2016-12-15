package z.house.coder.datastructures.algorithm;

import z.house.coder.datastructures.Stack;
import z.house.coder.datastructures.algorithm.extra.LinkedList;
import z.house.coder.datastructures.exceptions.Empty;

public class LinkedStack<T> implements Stack<T>{
	
	LinkedList<T> linkedList;
	
	public LinkedStack() {
		linkedList = null;
	}

	@Override
	public void push(T item) {
		if(linkedList == null) {
			linkedList = new LinkedList<>(item);
		} else {
			linkedList.insertFirst(item);
		}
		
	}

	@Override
	public T pop() throws Empty {
		if(linkedList == null) {
			throw new Empty();
		}
		return linkedList.removeFirst();
	}

	@Override
	public int count() {
		if(linkedList == null) {
			return 0;
		}
		return linkedList.size();
	}

}
