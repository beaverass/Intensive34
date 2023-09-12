package ru.aston.morozov_aa.task4.work_with_db.exceptions;

public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
