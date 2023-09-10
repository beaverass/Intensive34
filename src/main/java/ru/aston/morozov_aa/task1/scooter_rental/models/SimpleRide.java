package ru.aston.morozov_aa.task1.scooter_rental.models;

public class SimpleRide extends Ride{

    public SimpleRide(Double coefficient, Double routLength, User user, int id) {
        super(coefficient, routLength, user, id);
    }

    @Override
    public boolean isDiscountWorks() {
        boolean discountCondition = this.getRoutLength() == 10;

        if (discountCondition) {
            return true;
        }
        return false;
    }

    public Double getDiscount() {
        if (isDiscountWorks()){
            return DiscountSum.SIMPLE_RIDE_DISCOUNT.getDiscountSum();
        }
        return 0.0;
    }
}
