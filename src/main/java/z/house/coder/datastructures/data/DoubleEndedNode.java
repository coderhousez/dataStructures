package z.house.coder.datastructures.data;

public class DoubleEndedNode<T> {

	T element;
	DoubleEndedNode<T> prev;
	DoubleEndedNode<T> next;
	
	public DoubleEndedNode(T element, DoubleEndedNode<T> headNode, DoubleEndedNode<T>tailNode ) {
		this.element = element;
		this.prev = headNode;
		this.prev = tailNode;
	}
	
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public DoubleEndedNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DoubleEndedNode<T> prev) {
		this.prev = prev;
	}

	public DoubleEndedNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleEndedNode<T> next) {
		this.next = next;
	}

	
	
}
