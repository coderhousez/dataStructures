package z.house.coder.datastructures;

import z.house.coder.datastructures.exceptions.InvalidRankException;

public interface RankedSequence<T> {
	
	public T elementAtRank(int rank) throws InvalidRankException;
	
	public T replaceElementAtRank(int rank) throws InvalidRankException;
	
	public void insertElementAtRank(int rank, T element) throws InvalidRankException;
	
	public T removeElementAtRank(int rank, T element) throws InvalidRankException;

}
