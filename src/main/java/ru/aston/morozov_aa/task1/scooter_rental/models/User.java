package ru.aston.morozov_aa.task1.scooter_rental.models;

public class User {
    private int age;
    private String surName;
    private String name;

    public User(int age, String surName, String name) {
        this.age = age;
        this.surName = surName;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (surName != null ? !surName.equals(user.surName) : user.surName != null) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
