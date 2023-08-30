package ru.aston.morozov_aa.task1.scooter_rental.services;

import ru.aston.morozov_aa.task1.scooter_rental.models.Ride;

import java.util.List;

public class SimpleRideCalculator implements RideCalculator {

    @Override
    public Double calculateDailyRidesSum(List<Ride> rides) {
        Double sum = 0.0;

        for (Ride ride : rides) {
            sum += calculateRideSum(ride);
        }

        return sum;
    }

    @Override
    public Double calculateRideSum(Ride ride) {
        Double price = ride.getCoefficient() * ride.getRoutLength();

        if(ride.isDiscountWorks()){
            return price - calculateDiscount(price, ride.getDiscount());
        }

        return price;
    }

    private Double calculateDiscount(Double price, Double discount){
        return price * discount / 100;
    }


}
