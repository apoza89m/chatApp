package chatApp.exceptions;

public class ConversacionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConversacionException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConversacionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ConversacionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ConversacionException(String message) {
		super("Excepción generada en la clase Modelo:" + message);
	}

	public ConversacionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
