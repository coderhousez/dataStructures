package z.house.coder.datastructures.algorithm;

import java.util.Optional;

import z.house.coder.datastructures.Position;
import z.house.coder.datastructures.PositionalSequence;
import z.house.coder.datastructures.data.DoubleEndedNode;
import z.house.coder.datastructures.data.PositionalDoubleEndedNode;
import z.house.coder.datastructures.exceptions.InvalidPositionException;

public class NodePositionalSequence<T> implements PositionalSequence<T> {
	
	PositionalDoubleEndedNode<T> head, tail;
	Integer count = new Integer(0);
	
	public NodePositionalSequence() {
		this.head = new PositionalDoubleEndedNode<T>(this);
		this.tail = new PositionalDoubleEndedNode<T>(this);
		head.setNext(tail);
		tail.setPrev(head);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Position<T, PositionalSequence<T>> first() throws InvalidPositionException {
		if(count == 0) {
			throw new InvalidPositionException();
		}
		return (Position<T, PositionalSequence<T>>) head.getNext();
	}

	@Override
	public Position<T, PositionalSequence<T>> last()
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<T, PositionalSequence<T>> before(
			Position<T, PositionalSequence<T>> p)
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<T, PositionalSequence<T>> after(
			Position<T, PositionalSequence<T>> p)
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<T, PositionalSequence<T>> replace(
			Position<T, PositionalSequence<T>> p,
			Position<T, PositionalSequence<T>> q)
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<T, PositionalSequence<T>> swap(
			Position<T, PositionalSequence<T>> p,
			Position<T, PositionalSequence<T>> q)
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFirst(T element) {
		try {
			insertAfter(head, element);
		} catch(Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void insertLast(T element) {
		try {
			insertBefore(tail,element);
		} catch(Exception e) {
			throw new RuntimeException();
		}
		
	}

	@Override
	public void insertBefore(Position<T, PositionalSequence<T>> p, T element)
			throws InvalidPositionException {
		PositionalDoubleEndedNode<T> currentNode = (PositionalDoubleEndedNode<T>) p;
		PositionalDoubleEndedNode<T> newNode = new PositionalDoubleEndedNode<>(this);
		newNode.setElement(Optional.of(element));
		DoubleEndedNode<T> prevNode = currentNode.getPrev();
		currentNode.setPrev(newNode);
		prevNode.setNext(newNode);
		newNode.setPrev(prevNode);
		newNode.setNext(currentNode);
		count++;
	}

	@Override
	public void insertAfter(Position<T, PositionalSequence<T>> p, T element)
			throws InvalidPositionException {
		PositionalDoubleEndedNode<T> currentNode = (PositionalDoubleEndedNode<T>) p;
		PositionalDoubleEndedNode<T> newNode = new PositionalDoubleEndedNode<>(this);
		newNode.setElement(Optional.of(element));
		// TODO: fix API for PositionalDoubleEndedNode getNext()
		DoubleEndedNode<T> nextNode = currentNode.getNext();
		currentNode.setNext(newNode);
		nextNode.setPrev(newNode);
		newNode.setPrev(currentNode);
		newNode.setNext(nextNode);
		count++;
		
	}

	@Override
	public void remove(Position<T, PositionalSequence<T>> p)
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		
	}
	
	public int count() {
		return this.count.intValue();
	}

}
