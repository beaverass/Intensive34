package ru.aston.morozov_aa.task4.work_with_db.exception;

public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
