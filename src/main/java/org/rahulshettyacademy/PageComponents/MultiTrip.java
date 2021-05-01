package org.rahulshettyacademy.PageComponents;

import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;

public class MultiTrip implements SearchFlightAvail {


    @Override
    public void checkAvail(String origin, String destination) {
        System.out.println("I am inside multi trip");
    }
}
