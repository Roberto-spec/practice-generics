package org.itstep.step01.exeption;

public class NotFoundStadiumException extends StadiumException{
    public NotFoundStadiumException() {
    }

    public NotFoundStadiumException(String message) {
        super(message);
    }
}
