package com.spring.andiamo_a_teatro.exception;

import com.spring.andiamo_a_teatro.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnregisteredUserException.class)
    public ResponseEntity<ErrorMessage> unregisteredUserException(UnregisteredUserException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(NonExistentShowException.class)
    public ResponseEntity<ErrorMessage> nonExistentShowException(NonExistentShowException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(NonExistentSeatException.class)
    public ResponseEntity<ErrorMessage> nonExistentSeatException(NonExistentSeatException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(ShowException.class)
    public ResponseEntity<ErrorMessage> showException(ShowException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(SeatException.class)
    public ResponseEntity<ErrorMessage> seatException(SeatException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(TicketException.class)
    public ResponseEntity<ErrorMessage> ticketException(TicketException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.FORBIDDEN, exception.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(message);
    }
}
