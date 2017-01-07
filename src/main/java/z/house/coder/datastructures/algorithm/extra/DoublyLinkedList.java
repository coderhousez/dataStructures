package z.house.coder.datastructures.algorithm.extra;

import z.house.coder.datastructures.Deque;
import z.house.coder.datastructures.data.DoubleEndedNode;
import z.house.coder.datastructures.exceptions.Empty;
import z.house.coder.datastructures.exceptions.Full;

public class DoublyLinkedList<T> implements Deque<T> {
	
	DoubleEndedNode<T> header;
	DoubleEndedNode<T> trailer;
	int count = 0;
	
	DoublyLinkedList(){
		header = new DoubleEndedNode<T>(null, header, header);
		trailer = header;
	}

	@Override
	public void insertFirst(T element) throws Full {
		if(count == 0) {
			header.setElement(element);
			count++;
		} else {
			DoubleEndedNode<> newNode = new DoubleEndedNode<T>(element, newNode, header);
			header.setPrev(newNode);
			header = newNode;
			trailer = header;
			count++;
		}
		
	}

	@Override
	public void insertLast(T element) throws Full {
		if(count == 0) {
			header.setElement(element);
			count++;
		} else {
			DoubleEndedNode<> newNode = new DoubleEndedNode<T>(element, trailer)
		}
		
	}

	@Override
	public T removeFirst() throws Empty {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() throws Empty {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T first() throws Empty {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T last() throws Empty {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
