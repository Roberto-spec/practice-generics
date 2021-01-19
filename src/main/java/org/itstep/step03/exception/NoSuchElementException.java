package org.itstep.step03.exception;

public class NoSuchElementException extends PairsException{
    public NoSuchElementException() {
    }

    public NoSuchElementException(String message) {
        super(message);
    }
}
