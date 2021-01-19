package org.itstep.step01.exeption;

public class InvalidTypeException extends StadiumException{
    public InvalidTypeException() {
    }

    public InvalidTypeException(String message) {
        super(message);
    }
}
