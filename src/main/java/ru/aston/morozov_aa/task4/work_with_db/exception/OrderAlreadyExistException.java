package ru.aston.morozov_aa.task4.work_with_db.exception;

public class OrderAlreadyExistException extends Exception{
    public OrderAlreadyExistException(String message) {
        super(message);
    }
}
