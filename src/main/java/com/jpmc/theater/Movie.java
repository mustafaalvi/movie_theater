package com.jpmc.theater;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.lang.Math.max;

public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description; //MA: Missing a getter
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {  return ticketPrice; }

    //MA: method to round double to two decimal places
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    //MA: added extra param to getDiscount() for startTime
    public double calculateTicketPrice(Showing showing) {
        return round(ticketPrice - getDiscount(showing.getSequenceOfTheDay(), showing.getStartTime()),2);
    }

    //MA: added startTime param to implement new feature supporting timeBased Discount
    private double getDiscount(int showSequence, LocalDateTime startTime) { //think of how to incorp IllegalArgException...
        double specialDiscount = 0;
        if (MOVIE_CODE_SPECIAL == specialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        double sequenceDiscount = 0;
        //MA: replaced if-else statements with switch-case. Allows for extesibility should we need to support new sequenceDiscounts in the future.
        switch(showSequence){
            case 1:
                sequenceDiscount = 3;
                break;
            case 2:
                sequenceDiscount = 2;
                break;
            case 7:
                sequenceDiscount = 1;
                break;
            default:
                sequenceDiscount = 0;
                break;

        }

        //MA: added logic to calculate the 11AM-4PM discount
        double timeBasedDiscount = 0;
        int startHour = startTime.getHour();
        if(startHour >= 11 && startHour <= 16){
            timeBasedDiscount = ticketPrice * .25;
        }

        // biggest discount wins
        //MA: refactored to use Math.max() since there are 3 discounts that need to be compared
        return max(timeBasedDiscount, max(specialDiscount, sequenceDiscount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}