package hr.tis.dmx.restapi.exception;

public class ProductCreationException extends Exception {
	public ProductCreationException(String message) {
		super(message);
	}

	public ProductCreationException(String message, Throwable cause) {
		super(message, cause);
	}
}