package z.house.coder.datastructures.algorithm;

import z.house.coder.datastructures.data.Node;

/**
 * Linked List
 * 
 * @author coder
 *
 * @param <T>
 */
public class LinkedList<T> {
	
	Node<T> node;
	int count = 0;
	
	enum Position {
		BEGIN, END
	}
	
	public LinkedList(T element) {
		node = new Node<T>(element);
	}
	
	public LinkedList(Node<T> node) {
		this.node = node;
	}
	
	public void prepend(T item) {
		Node<T> newRoot = new Node<>(item);
		newRoot.setNode(node);
		node = newRoot;
		count++;
	}
	
	public void append(T item) {
		Node<T> lastNode = getLastNode(node);
		lastNode.setNode(new Node<T>(item));
		count++;
	}
	
	private Node<T> getLastNode(Node<T> node) {
		if(node.getNode() != null) {
			return getLastNode(node.getNode());
		}
		return node;
	}
	
	public void insert(int position) {
		
	}
	
	public T remove() {
		return removeAt(Position.BEGIN);
	}
	
	private T removeAt(Position p) {
		if(Position.BEGIN.equals(p) && count > 0) {
			T element = node.getElement();
			node = node.getNode();
			return element;
		}
		return null;
	}
	
	/**
	 * Value of first element in list.
	 * 
	 * @return T
	 */
	public T head() {
		return node.getElement();
	}
	
	public int count() {
		return count;
	}

}
