package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer john = new Customer("John Doe", "id-12345");
    Customer john2 = new Customer("John Doe", "id-12345");
    Customer jacob = new Customer("Jacob Jingle", "id-12345");


    @Test
    void testEquals() {
        assertTrue(!jacob.equals(john));
        assertTrue(john.equals(john2));
    }

    @Test
    void testHashCode() {
        assertTrue(john2.hashCode() == john.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("name: John Doe", john.toString());
        assertEquals("name: Jacob Jingle", jacob.toString());
    }
}