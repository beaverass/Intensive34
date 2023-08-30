package ru.aston.morozov_aa.task1.scooter_rental.models;

public class RideByMetrics extends Ride{

    public RideByMetrics(Double routLength, User user, int id) {
        super(routLength, user, id);
        this.setCoefficient(15.0);
    }

    @Override
    public boolean isDiscountWorks() {
        if (this.getUser().getAge() > 60) {
            return true;
        }
        return false;
    }

    @Override
    public Double getDiscount() {
        if(isDiscountWorks()){
            return 50.0;
        }
        return 0.0;
    }


}
