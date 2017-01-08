package z.house.coder.datastructures.algorithm.extra;

import java.util.Optional;

import z.house.coder.datastructures.Deque;
import z.house.coder.datastructures.data.DoubleEndedNode;
import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;

public class DoublyLinkedList<T> implements Deque<T> {
	
	DoubleEndedNode<T> head;
	DoubleEndedNode<T> tail;
	int count = 0;
	
	public DoublyLinkedList(){
		head = new DoubleEndedNode<T>();
		tail = new DoubleEndedNode<T>();
		head.setNext(tail);
		tail.setPrev(head);
	}

	@Override
	public void insertFirst(T element) throws Full {
		DoubleEndedNode<T> newNode = new DoubleEndedNode<T>();
		if(element != null) {
			newNode.setElement(Optional.of(element));
		}
		DoubleEndedNode<T> oldNext = head.getNext();
		head.setNext(newNode);
		newNode.setPrev(head);
		newNode.setNext(oldNext);
		oldNext.setPrev(newNode);
		count++;
	}

	@Override
	public void insertLast(T element) throws Full {
		DoubleEndedNode<T> newNode = new DoubleEndedNode<T>();
		if(element != null) {
			newNode.setElement(Optional.of(element));
		}
		DoubleEndedNode<T> oldPrev = tail.getPrev();
		tail.setPrev(newNode);
		newNode.setNext(tail);
		newNode.setPrev(oldPrev);
		oldPrev.setNext(newNode);
		count++;
	}

	@Override
	public T removeFirst() throws Empty {
		if(count == 0) {
			throw new Empty();
		}
		DoubleEndedNode<T> oldNext = head.getNext();
		DoubleEndedNode<T> newNext = oldNext.getNext();
		Optional<T> oldNextElement = oldNext.getElement();
		head.setNext(newNext);
		newNext.setPrev(head);
		oldNext.setPrev(null);
		oldNext.setNext(null);
		oldNext.setElement(Optional.empty());
		count--;
		return oldNextElement.orElse(null);
	}

	@Override
	public T removeLast() throws Empty {
		if(count == 0) {
			throw new Empty();
		}
		DoubleEndedNode<T> oldPrev = tail.getPrev();
		DoubleEndedNode<T> newPrev = oldPrev.getPrev();
		Optional<T> oldPrevElement = oldPrev.getElement();
		tail.setPrev(newPrev);
		newPrev.setNext(tail);
		oldPrev.setPrev(null);
		oldPrev.setNext(null);
		oldPrev.setElement(Optional.empty());
		count--;
		return oldPrevElement.orElse(null);
	}

	@Override
	public T first() throws Empty {
		if(count == 0) {
			throw new Empty();
		}
		return head.getNext().getElement().orElse(null);
	}

	@Override
	public T last() throws Empty {
		if(count == 0) {
			throw new Empty();
		}
		return tail.getPrev().getElement().orElse(null);
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
