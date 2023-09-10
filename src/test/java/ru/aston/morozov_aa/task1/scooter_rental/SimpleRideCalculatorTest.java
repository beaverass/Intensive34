package ru.aston.morozov_aa.task1.scooter_rental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.morozov_aa.task1.scooter_rental.models.*;
import ru.aston.morozov_aa.task1.scooter_rental.services.RideCalculator;
import ru.aston.morozov_aa.task1.scooter_rental.services.SimpleRideCalculator;
import ru.aston.morozov_aa.task2.exceptions.RideException;
import ru.aston.morozov_aa.task2.exceptions.TooLongRideException;
import ru.aston.morozov_aa.task2.exceptions.TooSmallRideException;

import java.util.ArrayList;
import java.util.List;

public class SimpleRideCalculatorTest {

    private final RideCalculator rideCalculator = new SimpleRideCalculator();

    @Test
    public void calculateDailyRidesSumTest() throws TooLongRideException, TooSmallRideException {
        User ivan = new User(30, "Ivanov", "Ivan");
        User petr = new User(30, "Petrov", "Petr");
        User vasiliy = new User(30, "Bochkov", "Vasiliy");

        Ride rideByMetrics = new RideByMetrics(15.0,12.0, ivan, 1);
        Ride rideWithInsurance = new RideWithInsurance(20.0, 4.0, petr, 2);
        Ride simpleRide = new SimpleRide(12.0, 5.0, vasiliy, 3);

        List<Ride> rides = new ArrayList<>();
        rides.add(rideWithInsurance);
        rides.add(simpleRide);
        rides.add(rideByMetrics);


        Assertions.assertEquals(320, rideCalculator.calculateDailyRidesSum(rides));
    }

    @Test
    public void calculateRideSumTest() throws TooLongRideException, TooSmallRideException {
        User vasiliy = new User(30, "Bochkov", "Vasiliy");
        Ride simpleRide = new SimpleRide(12.0, 5.0, vasiliy, 3);

        Assertions.assertEquals(60, rideCalculator.calculateRideSum(simpleRide));
    }

    @Test
    public void calculateRideSumWithDiscountTest() throws TooLongRideException, TooSmallRideException {
        User petr = new User(30, "Petrov", "Petr");
        Ride rideWithInsurance = new RideWithInsurance(20.0,6.0, petr, 2);
        Assertions.assertEquals(108, rideCalculator.calculateRideSum(rideWithInsurance));

    }

    @Test
    public void calculateDailyRidesSumWithDiscountTest() throws TooLongRideException, TooSmallRideException {
        User ivan = new User(70, "Ivanov", "Ivan");
        User petr = new User(30, "Petrov", "Petr");
        User vasiliy = new User(30, "Bochkov", "Vasiliy");

        Ride rideByMetrics = new RideByMetrics(15.0, 12.0, ivan, 1);
        Ride rideWithInsurance = new RideWithInsurance(20.0, 7.0, petr, 2);
        Ride simpleRide = new SimpleRide(12.0, 10.0, vasiliy, 3);

        List<Ride> rides = new ArrayList<>();
        rides.add(rideWithInsurance);
        rides.add(simpleRide);
        rides.add(rideByMetrics);


        Assertions.assertEquals(276, rideCalculator.calculateDailyRidesSum(rides));

    }



}
