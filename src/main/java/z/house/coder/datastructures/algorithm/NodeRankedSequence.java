package z.house.coder.datastructures.algorithm;

import z.house.coder.datastructures.RankedSequence;
import z.house.coder.datastructures.algorithm.extra.DoublyLinkedList;
import z.house.coder.datastructures.exceptions.InvalidRankException;

public class NodeRankedSequence<T> extends DoublyLinkedList<T> implements
		RankedSequence<T> {
	
	
	public NodeRankedSequence(){
		super();
	}

	@Override
	public T elementAtRank(int rank) throws InvalidRankException {
		return null;
	}

	@Override
	public T replaceElementAtRank(int rank) throws InvalidRankException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertElementAtRank(int rank, T element)
			throws InvalidRankException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeElementAtRank(int rank, T element)
			throws InvalidRankException {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
