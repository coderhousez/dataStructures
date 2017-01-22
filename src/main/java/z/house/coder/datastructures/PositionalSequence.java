package z.house.coder.datastructures;

import z.house.coder.datastructures.exceptions.InvalidPositionException;

/**
 * Provides access to elements in this container
 * relative to one another.
 * 
 * @author coder
 *
 */
public interface PositionalSequence<T> {
	
	public Position<T,PositionalSequence<T>> first() throws InvalidPositionException;
	public Position<T,PositionalSequence<T>> last() throws InvalidPositionException;
	public Position<T,PositionalSequence<T>> before(Position<T,PositionalSequence<T>> p) 
			throws InvalidPositionException;
	public Position<T,PositionalSequence<T>> after(Position<T,PositionalSequence<T>> p) 
			throws InvalidPositionException;
	public Position<T,PositionalSequence<T>> replace(Position<T,PositionalSequence<T>> p, 
			Position<T,PositionalSequence<T>> q) throws InvalidPositionException;
	public Position<T,PositionalSequence<T>> swap(Position<T,PositionalSequence<T>>p, 
			Position<T,PositionalSequence<T>> q) throws InvalidPositionException;
	public void insertFirst(T element);
	public void insertLast(T element);
	public void insertBefore(Position<T,PositionalSequence<T>> p, T element) throws InvalidPositionException;
	public void insertAfter(Position<T,PositionalSequence<T>> p, T element) throws InvalidPositionException;
	public void remove(Position<T,PositionalSequence<T>> p) throws InvalidPositionException;
}
