package ru.aston.morozov_aa.task2.exceptions;

public enum ExceptionCode {
    TOO_LONG_RIDE(1),
    TOO_SMALL_RIDE(2);

    private final int code;

    ExceptionCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
