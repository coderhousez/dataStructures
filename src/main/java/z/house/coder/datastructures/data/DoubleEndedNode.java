package z.house.coder.datastructures.data;

public class DoubleEndedNode<T> {

	T element;
	Node<T> headNode;
	Node<T> tailNode;
	
	public DoubleEndedNode(T element) {
		this.element = element;
	}
	
	public DoubleEndedNode(T element, Node<T> headNode, Node<T>tailNode ) {
		this.element = element;
		this.headNode = headNode;
		this.tailNode = tailNode;
	}
	
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public Node<T> getHeadNode() {
		return headNode;
	}

	public void setHeadNode(Node<T> headNode) {
		this.headNode = headNode;
	}

	public Node<T> getTailNode() {
		return tailNode;
	}

	public void setTailNode(Node<T> tailNode) {
		this.tailNode = tailNode;
	}
	
	
}
