package hello.exception;

/**
 * Exception thrown when not result was found (for example findById with null return value)
 */
public class CustomException extends RuntimeException {
    
    public CustomException() {
        super();
    }

    public CustomException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CustomException(final String message) {
        super(message);
    }

    public CustomException(final Throwable cause) {
        super(cause);
    }
    
}