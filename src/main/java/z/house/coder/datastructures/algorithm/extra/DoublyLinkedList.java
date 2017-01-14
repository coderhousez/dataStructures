package z.house.coder.datastructures.algorithm.extra;

import java.util.Optional;

import z.house.coder.datastructures.Deque;
import z.house.coder.datastructures.RankedSequence;
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

public class DoublyLinkedList<T> implements Deque<T> , RankedSequence<T> {
	
	DoubleEndedNode<T> head;
	DoubleEndedNode<T> tail;
	Integer counter =new Integer(0);;
	
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
		counter = Integer.valueOf(size() + 1);
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
		counter = Integer.valueOf(size() + 1);
	}

	@Override
	public T removeFirst() throws Empty {
		if(counter.intValue() == 0) {
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
		counter = Integer.valueOf(size() - 1);
		return oldNextElement.orElse(null);
	}

	@Override
	public T removeLast() throws Empty {
		if(counter.intValue() == 0) {
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
		counter = Integer.valueOf(size() - 1);
		return oldPrevElement.orElse(null);
	}
	
	/**
	 * desiredPosition is zero based
	 * non-destructive
	 * 
	 * @param desiredPosition
	 * @return
	 * @throws InvalidRankException
	 */
	private DoubleEndedNode<T> getNodeAt(int desiredPosition) 
		throws InvalidRankException , Empty {
		if(desiredPosition < 0 || desiredPosition > size() - 1) {
			throw new InvalidRankException();
		}
		if(isEmpty()) {
			throw new Empty();
		}
		DoubleEndedNode<T> node = null;
		if(desiredPosition <= size()/2) {
			DoubleEndedNode<T> currentNode = head;
			for(int i=0; i < size(); i++) {
				if(i == desiredPosition) {
					node = currentNode.getNext();
					break;
				} else {
					currentNode = currentNode.getNext();
				}
			}		
		} else {
			DoubleEndedNode<T> currentNode = tail;
			for(int i=size()-1; i >= 0; i--) {
				if(i == desiredPosition){
					node = currentNode.getPrev();
					break;
				} else {
					currentNode = currentNode.getPrev();
				}
			}
		}
		return node;
	}

	@Override
	public T first() throws Empty {
		if(size() == 0) {
			throw new Empty();
		}
		return head.getNext().getElement().orElse(null);
	}

	@Override
	public T last() throws Empty {
		if(size() == 0) {
			throw new Empty();
		}
		return tail.getPrev().getElement().orElse(null);
	}

	@Override
	public int size() {
		return counter.intValue();
	}

	@Override
	public boolean isEmpty() {
		return counter.intValue() == 0;
	}

	@Override
	public T elementAtRank(int rank) throws InvalidRankException {
		T element = null;
		try {
			element = getNodeAt(rank).getElement().get();
		} catch(Empty e) {
			throw new InvalidRankException();
		}
		return element;
	}

	@Override
	public T replaceElementAtRank(int rank, T element)
			throws InvalidRankException {
		Optional<T> oldElement = Optional.empty();
		try {
			DoubleEndedNode<T> node = getNodeAt(rank);
			oldElement = node.getElement();
			node.setElement(Optional.of(element));
		} catch(Empty e) {
			throw new InvalidRankException(e.getMessage());
		}
		return oldElement.get();
	}

	@Override
	public void insertElementAtRank(int rank, T element)
			throws InvalidRankException {
		DoubleEndedNode<T> newNode = new DoubleEndedNode<>();
		newNode.setElement(Optional.of(element));
		try {
			// preserve rank node
			DoubleEndedNode<T> rankedNode = getNodeAt(rank);
			DoubleEndedNode<T> previousNode = rankedNode.getPrev();
			// update DoublyLinkedList
			newNode.setPrev(previousNode);
			newNode.setNext(rankedNode);
			rankedNode.setPrev(newNode);
			previousNode.setNext(newNode);
		} catch(Empty e) {
			throw new InvalidRankException();
		}
		counter = Integer.valueOf(size() + 1);
	}

	@Override
	public T removeElementAtRank(int rank) throws InvalidRankException {
		Optional<T> element = Optional.empty();
		try {
			// preserve
			DoubleEndedNode<T> rankedNode = getNodeAt(rank);
			DoubleEndedNode<T> prevNode = rankedNode.getPrev();
			DoubleEndedNode<T> nextNode = rankedNode.getNext();
			element = rankedNode.getElement();
			// update
			prevNode.setNext(nextNode);
			nextNode.setPrev(prevNode);
			rankedNode.setPrev(null);
			rankedNode.setNext(null);
			rankedNode.setElement(Optional.empty());
		} catch(Empty e) {
			throw new InvalidRankException();
		}
		counter = Integer.valueOf(size() - 1);
		
		return element.get();
	}

}
