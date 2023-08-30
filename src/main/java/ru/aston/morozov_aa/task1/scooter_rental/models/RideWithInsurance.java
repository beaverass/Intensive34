package ru.aston.morozov_aa.task1.scooter_rental.models;

public class RideWithInsurance extends Ride{

    public RideWithInsurance(Double routLength, User user, int id) {
        super(routLength, user, id);
        this.setCoefficient(20.0);
    }

    @Override
    public boolean isDiscountWorks() {
        if (this.getRoutLength() > 5) {
            return true;
        }
        return false;
    }

    public Double getDiscount() {
        if (isDiscountWorks()){
            return 10.0;
        }

        return 0.0;
    }
}
