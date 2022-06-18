package com.techelevator.model;

public class Venue {

    private String venue_name;
    private String city;
    private String stateAbv;
    private String venueImg;

    public Venue(){}

    public Venue(String venue_name, String city, String stateAbv, String venueImg) {
        this.venue_name = venue_name;
        this.city = city;
        this.stateAbv = stateAbv;
        this.venueImg = venueImg;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbv() {
        return stateAbv;
    }

    public void setStateAbv(String stateAbv) {
        this.stateAbv = stateAbv;
    }

    public String getVenueImg() {
        return venueImg;
    }

    public void setVenueImg(String venueImg) {
        this.venueImg = venueImg;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venue_name='" + venue_name + '\'' +
                ", city='" + city + '\'' +
                ", stateAbv='" + stateAbv + '\'' +
                ", venueImg='" + venueImg + '\'' +
                '}';
    }
}
