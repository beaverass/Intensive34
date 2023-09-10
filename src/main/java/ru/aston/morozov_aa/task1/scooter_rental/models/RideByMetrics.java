package ru.aston.morozov_aa.task1.scooter_rental.models;

public class RideByMetrics extends Ride{

    public RideByMetrics(Double coefficient, Double routLength, User user, int id) {
        super(coefficient, routLength, user, id);
    }

    @Override
    public boolean isDiscountWorks() {
        boolean discountCondition = this.getUser().getAge() > 60;

        if (discountCondition) {
            return true;
        }

        return false;
    }

    @Override
    public Double getDiscount() {
        if(isDiscountWorks()){
            return DiscountSum.RIDE_BY_METRICS_DISCOUNT.getDiscountSum();
        }
        return 0.0;
    }


}
