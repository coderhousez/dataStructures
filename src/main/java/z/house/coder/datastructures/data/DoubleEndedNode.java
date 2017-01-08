package z.house.coder.datastructures.data;

import java.util.Optional;

public class DoubleEndedNode<T> {

	Optional<T> element;
	DoubleEndedNode<T> prev;
	DoubleEndedNode<T> next;
	
	public DoubleEndedNode() {
		element = Optional.empty();
		prev = null;
		next = null;
	}
	
	public DoubleEndedNode(Optional<T> element, 
			DoubleEndedNode<T> prev, 
			DoubleEndedNode<T> next ) {
		this.element = element;
		this.prev = prev;
		this.prev = next;
	}
	
	public Optional<T> getElement() {
		return element;
	}

	public void setElement(Optional<T> element) {
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
