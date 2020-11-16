package ee.bcs.valiit.tasks.BankController2.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> handleApplicationException(ApplicationException e) {
//        System.out.println("Not enough funds.");      // Läheks logisse, mis pole praktiline logi mahu pärast
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse("Server error"), new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
