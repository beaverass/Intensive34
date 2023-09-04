package ru.aston.morozov_aa.task2.exceptions;

public class TooLongRideException extends RideException{

    public TooLongRideException(String message, ExceptionCode code) {
        super(message, code);
    }
}
