package z.house.coder.datastructures.data;

import z.house.coder.datastructures.Position;
import z.house.coder.datastructures.PositionalSequence;

public class PositionalDoubleEndedNode<T> extends DoubleEndedNode<T> implements Position<T,PositionalSequence<T>>{

	private PositionalSequence<T> container;
	
	public PositionalDoubleEndedNode(PositionalSequence<T> container) {
		super();
		this.container = container;
	}
	
	@Override
	public PositionalSequence<T> getContainer() {
		return container;
	}

}
