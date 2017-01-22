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
		PositionalDoubleEndedNode<T> newNode = new PositionalDoubleEndedNode<>(this);
		newNode.setElement(Optional.of(element));
		// TODO: fix API for PositionalDoubleEndedNode getNext()
		DoubleEndedNode<T> nextNode = head.getNext();
		head.setNext(newNode);
		nextNode.setPrev(newNode);
		newNode.setPrev(head);
		newNode.setNext(nextNode);
		count++;
	}

	@Override
	public void insertLast(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBefore(Position<T, PositionalSequence<T>> p, T element)
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAfter(Position<T, PositionalSequence<T>> p, T element)
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Position<T, PositionalSequence<T>> p)
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		
	}

}
