package ru.aston.morozov_aa.task4.work_with_db.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
