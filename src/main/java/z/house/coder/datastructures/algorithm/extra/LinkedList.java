package z.house.coder.datastructures.algorithm.extra;

import z.house.coder.datastructures.Deque;
import z.house.coder.datastructures.data.Node;
import z.house.coder.datastructures.exceptions.Empty;

/**
 * Linked List
 * 
 * @author coder
 *
 * @param <T>
 */
public class LinkedList<T> implements Deque<T> {
	
	Node<T> node;
	int count = 0;
	
	public LinkedList(T element) {
		node = new Node<T>(element);
		count = 1;
	}
	
	@Override
	public void insertFirst(T element) {
		if(count == 0) {
			node = new Node<T>(element);
		} else {
			Node<T> newRoot = new Node<>(element);
			newRoot.setNode(node);
			node = newRoot;
		}
		count++;		
	}
	
	@Override
	public void insertLast(T item) {
		if(count == 0) {
			insertFirst(item);
		} else {
			Node<T> lastNode = getNodeAt(count);
			lastNode.setNode(new Node<T>(item));
			count++;
		}
	}
	
	/**
	 * Returns node based in position in the List
	 * 
	 * List begins at 1
	 * desiredPosition >= 1
	 * desiredPosition <= count
	 * Ignores desiredPositions that are out of range.
	 * 
	 * @param desiredPosition
	 * @return Node<T>
	 */
	private Node<T> getNodeAt(int desiredPosition) {
		Node<T> currentNode = node;
		int currentPosition = 1;
		while(node != null && desiredPosition >= 1 && desiredPosition <= count) {
			if(desiredPosition == currentPosition) {
				break;
			}
			currentNode = currentNode.getNode();
			currentPosition++;
		}
		return currentNode;
	}
	
	public T removeFirst() throws Empty {
		if(isEmpty()) {
			throw new Empty();
		}
		T element = node.getElement();
		node = node.getNode();
		count--;
		return element;
	}
	
	public T removeLast() throws Empty {
		if(isEmpty()) {
			throw new Empty();
		}
		Node<T> n = getNodeAt(count - 1);
		Node<T> last = n.getNode();
		n.setNode(null);
		count--;
		return last.getElement();
	}

	@Override
	public T first() throws Empty {
		if(isEmpty()) {
			throw new Empty();
		}
		return node.getElement();
	}

	@Override
	public T last() throws Empty {
		if(isEmpty()) {
			throw new Empty();
		}
		return getNodeAt(count).getElement();
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}


}
