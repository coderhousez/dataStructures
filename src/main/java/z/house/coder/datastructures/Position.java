package z.house.coder.datastructures;

import java.util.Optional;

/**
 * Represent an element within a container 
 * by implementing this interface.
 * 
 * @author coder
 *
 */
public interface Position<T,C> {

	/**
	 * Element at this position in
	 * the container.
	 * @return T
	 */
	public Optional<T> getElement();
	
	/**
	 * Returns container that
	 * holds element at this positon.
	 * @return C
	 */
	public C getContainer();
	
}
