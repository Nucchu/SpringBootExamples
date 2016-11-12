package hello.exception;

import javax.xml.bind.ValidationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * RESThub default exception handler for most common exceptions.
 */
@ControllerAdvice
public class ResthubExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value={
            MinAgeException.class,
            MaxAgeException.class,
            CustomException.class
    })
    public ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) {

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status;
       String message="";
        if (ex instanceof MinAgeException) {
            status = HttpStatus.BAD_REQUEST;
            
        }  else if (ex instanceof MaxAgeException) {
            status = HttpStatus.BAD_REQUEST;
        } 
        else if (ex instanceof CustomException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } 
 else {
            logger.warn("Unknown exception type: " + ex.getClass().getName());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, headers, status, request);
        }

        return handleExceptionInternal(ex, buildRestError(ex, status,ex.getMessage()), headers, status, request);
    }

    private RestError buildRestError(Exception ex, HttpStatus status,String message) {
        RestError.Builder builder = new RestError.Builder();
        builder.setCode(status.value()).setStatus(status.getReasonPhrase()).setMessage(message);
        return builder.build();
    }

}