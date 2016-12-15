package z.house.coder.datastructures.data;

/**
 * Node
 *
 * Use in linked data structures.
 */
public class Node<T> 
{
	T element;
	Node<T> node;
	
	public Node(T element) {
		this.element = element;
		node = null;
	}
	
	public Node(T element, Node<T> node) {
		this.element = element;
		this.node = node;
	}
	public T getElement() {
		return element;
	}
	public Node<T> getNode() {
		return node;
	}
	public void setNode(Node<T> node) {
		this.node = node;
	}
	
}
