package com.techelevator.dao;

import com.techelevator.model.Venue;

import java.util.List;

public interface VenueDao {

    List<Venue> getAllVenues();

    Venue getVenueByName(String venue_name);

    void saveVenue(Venue venueToSave);

    void deleteVenue(String venue_name);

    void updateVenue(Venue venueToSave, String venue_name);



}
