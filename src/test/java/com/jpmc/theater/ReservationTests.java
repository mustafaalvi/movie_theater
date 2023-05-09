package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTests {

    @Test
    //MA: changed LocalDateTime.now() to be a fixed time so that the test is less volatile
    void totalFee() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 10, 1),
                1,
                LocalDateTime.of(2023, 05,10, 13,2,3)
        );
        assertEquals(21, new Reservation(customer, showing, 3).totalFee());
    }
}
