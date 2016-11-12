package hello.exception;
import org.springframework.util.ObjectUtils;

/**
 * Value object use to serialize REST error messages
 * @author Les Hazlewood
 */
public class RestError {

    /** HTTP status reason phrase, form example "Internal Server Error" **/
    private final String status;

    /** HTTP status code **/
    private final int code;

    /** Message for end users **/
    private final String message;

    


    public RestError(String status, int code, String message  ) {
        if (status == null) {
            throw new NullPointerException("HttpStatus argument cannot be null.");
        }
        this.status = status;
        this.code = code;
        this.message = message;
         
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

     
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof RestError) {
            RestError re = (RestError) o;
            return ObjectUtils.nullSafeEquals(getStatus(), re.getStatus()) &&
                    getCode() == re.getCode() &&
                    ObjectUtils.nullSafeEquals(getMessage(), re.getMessage()) ;
        }

        return false;
    }

    @Override
    public int hashCode() {
        //noinspection ThrowableResultOfMethodCallIgnored
        return ObjectUtils.nullSafeHashCode(new Object[]{
                getStatus(), getCode(), getMessage() 
        });
    }

    public String toString() {
        //noinspection StringBufferReplaceableByString
        return new StringBuilder().append(getCode())
                .append(" (").append(getStatus()).append(" )")
                .toString();
    }

    public static class Builder {

        private String status;
        private int code;
        private String message;

        public Builder() {
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setCode(int code) {
            this.code = code;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        

        public RestError build() {
            if (this.status == null) {
                this.status = "Internal Server Error";
            }
            return new RestError(this.status, this.code, this.message);
        }
    }
}