package ru.aston.morozov_aa.task2.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.morozov_aa.task1.scooter_rental.models.Ride;
import ru.aston.morozov_aa.task1.scooter_rental.models.SimpleRide;
import ru.aston.morozov_aa.task1.scooter_rental.models.User;
import ru.aston.morozov_aa.task1.scooter_rental.services.RideCalculator;
import ru.aston.morozov_aa.task1.scooter_rental.services.SimpleRideCalculator;

public class RideExceptionTest {
    private final RideCalculator rideCalculator = new SimpleRideCalculator();

    @Test
    public void tooSmallRideExceptionTest() {
        User vasiliy = new User(30, "Bochkov", "Vasiliy");
        Ride simpleRide = new SimpleRide(12.0, 0.0, vasiliy, 3);

        Assertions.assertThrows(
                TooSmallRideException.class,
                () -> rideCalculator.calculateRideSum(simpleRide)
        );
    }

    @Test
    public void tooLongRideExceptionTest() {
        User vasiliy = new User(30, "Bochkov", "Vasiliy");
        Ride simpleRide = new SimpleRide(12.0,101.0, vasiliy, 3);

        Assertions.assertThrows(
                TooLongRideException.class,
                () -> rideCalculator.calculateRideSum(simpleRide)
        );
    }


}
