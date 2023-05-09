package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTests {


    @Test
    void testSpecialMovieDiscount() {
        LocalDateTime time = LocalDateTime.of(2023, 05,10, 1,2,3);
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 1);
        Showing showing = new Showing(spiderMan, 7, time);

        assertEquals(8, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void test7thMovieDiscount() {
        LocalDateTime time = LocalDateTime.of(2023, 05,10, 1,2,3);
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 0);
        Showing showing = new Showing(spiderMan, 7, time);

        assertEquals(9, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void testTimeBasedDiscount() {
        LocalDateTime time = LocalDateTime.of(2023, 05,10, 13,2,3);
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 0);
        Showing showing = new Showing(spiderMan, 7, time);

        assertEquals(7.5, spiderMan.calculateTicketPrice(showing));
    }


    @Test
    void testEquals() {
        LocalDateTime time = LocalDateTime.of(2023, 05,10, 1,2,3);
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 1);
        Movie spiderManNoCode = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 1);

        assertTrue(spiderMan.equals(spiderManNoCode));

    }

    @Test
    void testHashCode() {
        LocalDateTime time = LocalDateTime.of(2023, 05,10, 1,2,3);
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 1);
        Movie spiderManNoCode = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 1);

        assertTrue(spiderMan.hashCode() == spiderManNoCode.hashCode());
    }

    @Test
    void testGetTitle(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 1);
        assertEquals("Spider-Man: No Way Home",spiderMan.getTitle());
    }

    @Test
    void testGetRunningTime(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 1);
        assertEquals(90,spiderMan.getRunningTime().toMinutes());
    }

    @Test
    void testGetTicketPrice(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 1);
        assertEquals(10,spiderMan.getTicketPrice());
    }


}
