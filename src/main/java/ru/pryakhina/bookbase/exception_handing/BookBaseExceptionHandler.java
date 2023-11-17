package ru.pryakhina.bookbase.exception_handing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookBaseExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BookBaseIncorrectData> handleException(
            NoSuchAuthorException exception
    ){
        BookBaseIncorrectData data = new BookBaseIncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BookBaseIncorrectData> handleException(
            Exception exception
    ){
        BookBaseIncorrectData data = new BookBaseIncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
