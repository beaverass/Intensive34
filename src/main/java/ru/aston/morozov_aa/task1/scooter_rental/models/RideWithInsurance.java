package ru.aston.morozov_aa.task1.scooter_rental.models;

public class RideWithInsurance extends Ride{

    public RideWithInsurance(Double coefficient, Double routLength, User user, int id) {
        super(coefficient, routLength, user, id);
    }

    @Override
    public boolean isDiscountWorks() {
        boolean discountCondition = this.getRoutLength() > 5;

        if (discountCondition) {
            return true;
        }

        return false;
    }

    public Double getDiscount() {
        if (isDiscountWorks()){
            return DiscountSum.RIDE_WITH_INSURANCE_DISCOUNT.getDiscountSum();
        }

        return 0.0;
    }
}
