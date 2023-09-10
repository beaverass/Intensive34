package ru.aston.morozov_aa.task1.scooter_rental.services;

import ru.aston.morozov_aa.task1.scooter_rental.models.Ride;
import ru.aston.morozov_aa.task2.exceptions.TooLongRideException;
import ru.aston.morozov_aa.task2.exceptions.TooSmallRideException;

import java.util.List;

public interface RideCalculator {

    public Double calculateRideSum(Ride ride) throws TooLongRideException, TooSmallRideException;

    public Double calculateDailyRidesSum(List<Ride> rides) throws TooLongRideException, TooSmallRideException;

}
