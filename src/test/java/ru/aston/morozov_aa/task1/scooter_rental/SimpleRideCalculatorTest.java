package ru.aston.morozov_aa.task1.scooter_rental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.morozov_aa.task1.scooter_rental.models.*;
import ru.aston.morozov_aa.task1.scooter_rental.services.RideCalculator;
import ru.aston.morozov_aa.task1.scooter_rental.services.SimpleRideCalculator;

import java.util.ArrayList;
import java.util.List;

public class SimpleRideCalculatorTest {

    private final RideCalculator rideCalculator = new SimpleRideCalculator();

    @Test
    public void calculateDailyRidesSumTest(){
        User ivan = new User(30, "Ivanov", "Ivan");
        User petr = new User(30, "Petrov", "Petr");
        User vasiliy = new User(30, "Bochkov", "Vasiliy");

        Ride rideByMetrics = new RideByMetrics(12.0, ivan, 1);
        Ride rideWithInsurance = new RideWithInsurance(4.0, petr, 2);
        Ride simpleRide = new SimpleRide(5.0, vasiliy, 3);

        List<Ride> rides = new ArrayList<>();
        rides.add(rideWithInsurance);
        rides.add(simpleRide);
        rides.add(rideByMetrics);


        Assertions.assertEquals(320, rideCalculator.calculateDailyRidesSum(rides));
    }

    @Test
    public void calculateRideSumTest(){
        User vasiliy = new User(30, "Bochkov", "Vasiliy");
        Ride simpleRide = new SimpleRide(5.0, vasiliy, 3);

        Assertions.assertEquals(60, rideCalculator.calculateRideSum(simpleRide));
    }

    @Test
    public void calculateRideSumWithDiscountTest(){
        User petr = new User(30, "Petrov", "Petr");
        Ride rideWithInsurance = new RideWithInsurance(6.0, petr, 2);
        Assertions.assertEquals(108, rideCalculator.calculateRideSum(rideWithInsurance));

    }

    @Test
    public void calculateDailyRidesSumWithDiscountTest(){
        User ivan = new User(70, "Ivanov", "Ivan");
        User petr = new User(30, "Petrov", "Petr");
        User vasiliy = new User(30, "Bochkov", "Vasiliy");

        Ride rideByMetrics = new RideByMetrics(12.0, ivan, 1);
        Ride rideWithInsurance = new RideWithInsurance(7.0, petr, 2);
        Ride simpleRide = new SimpleRide(10.0, vasiliy, 3);

        List<Ride> rides = new ArrayList<>();
        rides.add(rideWithInsurance);
        rides.add(simpleRide);
        rides.add(rideByMetrics);


        Assertions.assertEquals(276, rideCalculator.calculateDailyRidesSum(rides));


    }



}
