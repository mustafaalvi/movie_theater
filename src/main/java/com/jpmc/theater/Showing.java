package com.jpmc.theater;

import java.time.LocalDateTime;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getSequenceOfTheDay() { return sequenceOfTheDay; }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    //MA:renamed to more accurately reflect method's function
    public double getMoviePrice() { return movie.getTicketPrice(); }

    //MA: changed access to package-protected so it can be accessed & used by Reservation class
    double calculateFee(int audienceCount) {
        return movie.calculateTicketPrice(this) * audienceCount;
    }

}
