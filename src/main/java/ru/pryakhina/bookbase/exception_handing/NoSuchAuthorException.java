package ru.pryakhina.bookbase.exception_handing;

public class NoSuchAuthorException extends RuntimeException{
    public NoSuchAuthorException(String message) {
        super(message);
    }
}
