package ru.aston.artamonov_va.task1.task12.exceptions;

public class TicketException extends RuntimeException {
    private final int exceptionCode;
    private final String exceptionMessage;

    public TicketException(String exceptionMessage, int exceptionCode) {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }


    @Override
    public String getMessage() {
        return "Exception code: " + exceptionCode + " \nException message: " + exceptionMessage;
    }

}

