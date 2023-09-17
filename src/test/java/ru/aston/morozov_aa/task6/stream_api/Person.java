package ru.aston.morozov_aa.task6.stream_api;

public class Person {

    private String name;
    private String surName;
    private int age;

    @Override
    public String toString() {
        return "\n --->  " +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age;
    }
}
