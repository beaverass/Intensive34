package ru.aston.morozov_aa.task1.scooter_rental.services;

import ru.aston.morozov_aa.task1.scooter_rental.models.Ride;

import java.util.List;

public interface RideCalculator {

    public Double calculateRideSum(Ride ride);

    public Double calculateDailyRidesSum(List<Ride> rides);

}
