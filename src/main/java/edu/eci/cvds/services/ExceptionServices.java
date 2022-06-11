package edu.eci.cvds.services;

public class ExceptionServices extends Exception {

    /**
	 * Default generated servial version id
	 */
	private static final long serialVersionUID = 2872498150117457223L;

	public ExceptionServices() {
    }

    public ExceptionServices(String message) {
        super(message);
    }

    public ExceptionServices(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionServices(Throwable cause) {
        super(cause);
    }
    
}
