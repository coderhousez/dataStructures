package z.house.coder.datastructures.algorithm.extra;

import java.util.Optional;

import z.house.coder.datastructures.Deque;
import z.house.coder.datastructures.data.DoubleEndedNode;
import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;
import z.house.coder.datastructures.exceptions.InvalidRankException;

/**
 * MyDeque in "Data Structures And Algorithims in Java"
 * 
 * @author coder
 *
 * @param <T>
 */

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
	
	/**
	 * desiredPosition is zero based
	 * 
	 * @param desiredPosition
	 * @return
	 * @throws InvalidRankException
	 */
	public DoubleEndedNode<T> getNodeAt(int desiredPosition) 
		throws InvalidRankException , Empty {
		if(desiredPosition < 0 || desiredPosition > count - 1) {
			throw new InvalidRankException();
		}
		if(isEmpty()) {
			throw new Empty();
		}
		DoubleEndedNode<T> node = null;
		if(desiredPosition < count/2) {
			DoubleEndedNode<T> currentNode = head;
			for(int i=0; i < count; count++) {
				if(i == desiredPosition) {
					node = currentNode;
				}
				currentNode = currentNode.getNext();
			}		
		} else {
			DoubleEndedNode<T> currentNode = tail;
			for(int i=count; i > 0; i--) {
				if(i == desiredPosition){
					node = currentNode;
				}
				currentNode = currentNode.getPrev();
			}
		}
		return node;
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
