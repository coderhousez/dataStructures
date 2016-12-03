package z.house.coder.datastructures.algorithm;

import z.house.coder.datastructures.Stack;

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
	public void push(T item) {		
		stack[++index] = item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		return (T) stack[index--];
	}

	@Override
	public int count() {
		return index + 1;
	}

	
}
