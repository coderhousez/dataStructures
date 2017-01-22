package z.house.coder.datastructures.exceptions;

@SuppressWarnings("serial")
public class InvalidPositionException extends DataStructureException{

	public InvalidPositionException() {
		super();
	}
	
	public InvalidPositionException(String message) {
		super(message);
	}
}
