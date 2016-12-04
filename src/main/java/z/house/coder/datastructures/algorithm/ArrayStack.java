package z.house.coder.datastructures.algorithm;

import z.house.coder.datastructures.Stack;
import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;

/**
 * Simple array based Stack
 *
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {
	
	Object [] stack;
	int index = -1;
	
	public ArrayStack() {
		stack = new Object [5];
	}
	
	public ArrayStack(int size) {
		stack = new Object[size];
	}

	@Override
	public void push(T item) throws Full {
		if(stack.length == count()) {
			throw new Full("Stack only allows " + stack.length + " elements");
		}
		stack[++index] = item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() throws Empty {
		if(count() == 0) {
			throw new Empty();
		}
		return (T) stack[index--];
	}

	@Override
	public int count() {
		return index + 1;
	}

	
}
