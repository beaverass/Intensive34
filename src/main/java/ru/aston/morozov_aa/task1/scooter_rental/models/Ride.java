package ru.aston.morozov_aa.task1.scooter_rental.models;

public abstract class Ride implements Discount{

    private Double coefficient;
    private Double routLength;
    private User user;
    private int id;

    public Ride(Double coefficient, Double routLength, User user, int id) {
        this.coefficient = coefficient;
        this.routLength = routLength;
        this.user = user;
        this.id = id;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Double getRoutLength() {
        return routLength;
    }

    public void setRoutLength(Double routLength) {
        this.routLength = routLength;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
