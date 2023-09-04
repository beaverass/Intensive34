package ru.aston.morozov_aa.task2.exceptions;

public class RideException extends Exception{
    private final int exceptionCode;

    public RideException(String message, ExceptionCode exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode.getCode();
    }

    public int getExceptionCode() {
        return exceptionCode;
    }
}
