package hello.exception;

/**
 * Exception thrown when not result was found (for example findById with null return value)
 */
public class MaxAgeException extends CustomException {
    
    public MaxAgeException() {
        super();
    }

    public MaxAgeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MaxAgeException(final String message) {
        super(message);
    }

    public MaxAgeException(final Throwable cause) {
        super(cause);
    }
    
}