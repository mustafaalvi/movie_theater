package com.jpmc.theater;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    //change showing.getMovieFee() * aud ====> showing.calculateFee(aud)
    //this will reflect the customer's actual total, with any applicable discounts
    public double totalFee() {
        return showing.calculateFee(audienceCount);
    }
}