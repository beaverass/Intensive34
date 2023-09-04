package ru.aston.morozov_aa.task2.exceptions;

public class TooSmallRideException extends RideException{

    public TooSmallRideException(String message, ExceptionCode code) {
        super(message, code);
    }
}
