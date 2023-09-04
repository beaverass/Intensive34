package ru.aston.morozov_aa.task1.scooter_rental.models;

public enum DiscountSum {

    RIDE_BY_METRICS_DISCOUNT(50.0),
    SIMPLE_RIDE_DISCOUNT(50.0),
    RIDE_WITH_INSURANCE_DISCOUNT(10.0);

    private final Double discountSum;

    DiscountSum(Double discountSum) {
        this.discountSum = discountSum;
    }

    public Double getDiscountSum() {
        return discountSum;
    }
}
