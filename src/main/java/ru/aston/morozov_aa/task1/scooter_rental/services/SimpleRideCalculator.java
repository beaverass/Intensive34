package ru.aston.morozov_aa.task1.scooter_rental.services;

import ru.aston.morozov_aa.task1.scooter_rental.models.Ride;
import ru.aston.morozov_aa.task2.exceptions.ExceptionCode;
import ru.aston.morozov_aa.task2.exceptions.TooLongRideException;
import ru.aston.morozov_aa.task2.exceptions.TooSmallRideException;

import java.util.List;

public class SimpleRideCalculator implements RideCalculator {

    @Override
    public Double calculateDailyRidesSum(List<Ride> rides) throws TooLongRideException, TooSmallRideException {
        Double sum = 0.0;

        for (Ride ride : rides) {
            sum += calculateRideSum(ride);
        }

        return sum;
    }

    @Override
    public Double calculateRideSum(Ride ride) throws TooLongRideException, TooSmallRideException {

        if(ride.getRoutLength() > 100){
            throw new TooLongRideException("Ride length " + ride.getRoutLength() + " is too long", ExceptionCode.TOO_LONG_RIDE);
        }

        if(ride.getRoutLength() < 1){
            throw new TooSmallRideException("Ride length " + ride.getRoutLength() + " is too small", ExceptionCode.TOO_SMALL_RIDE);
        }

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
