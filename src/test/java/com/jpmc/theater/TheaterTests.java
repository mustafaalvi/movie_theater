package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
//      System.out.println("You have to pay " + reservation.getTotalFee());

        //MA: Changed 50=>37.5, because John should get discount, also rearranged param order for expected/actual
        assertEquals(37.52, reservation.totalFee());
    }

    @Test
    void reservationExceptionWhenInvalidSequence(){
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        assertThrows(IllegalStateException.class, () ->theater.reserve(john, 20, 4));
    }

    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }

    @Test
    void printMovieScheduleJSONException() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }


}
