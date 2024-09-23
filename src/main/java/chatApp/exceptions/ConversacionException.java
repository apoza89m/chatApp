package chatApp.exceptions;

public class ConversacionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConversacionException(String message) {
		super("Excepción generada en la clase Modelo: " + message);
	}

}
