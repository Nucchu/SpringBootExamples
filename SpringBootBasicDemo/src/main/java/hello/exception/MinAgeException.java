package hello.exception;

/**
 * Exception thrown when not result was found (for example findById with null return value)
 */
public class MinAgeException extends CustomException {
    
    public MinAgeException() {
        super();
    }

    public MinAgeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MinAgeException(final String message) {
        super(message);
    }

    public MinAgeException(final Throwable cause) {
        super(cause);
    }
    
}