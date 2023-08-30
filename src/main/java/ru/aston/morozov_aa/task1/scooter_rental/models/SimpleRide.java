package ru.aston.morozov_aa.task1.scooter_rental.models;

public class SimpleRide extends Ride{

    public SimpleRide(Double routLength, User user, int id) {
        super(routLength, user, id);
        this.setCoefficient(12.0);
    }

    @Override
    public boolean isDiscountWorks() {
        if (this.getRoutLength() == 10) {
            return true;
        }
        return false;
    }

    public Double getDiscount() {
        if (isDiscountWorks()){
            return 50.0;
        }
        return 0.0;
    }
}
