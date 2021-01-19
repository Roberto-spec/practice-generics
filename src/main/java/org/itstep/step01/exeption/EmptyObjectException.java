package org.itstep.step01.exeption;

public class EmptyObjectException extends StadiumException{
    public EmptyObjectException() {
    }

    public EmptyObjectException(String message) {
        super(message);
    }
}
