package z.house.coder.datastructures.algorithm;

public interface LinkedList<T> {
	
	public void prepend(T item);
	
	public void append(T item);
	
	public void insert(int position);
	
	public void remove(int position);
	
	public int count();

}
