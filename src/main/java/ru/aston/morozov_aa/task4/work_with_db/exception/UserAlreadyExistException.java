package ru.aston.morozov_aa.task4.work_with_db.exception;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
