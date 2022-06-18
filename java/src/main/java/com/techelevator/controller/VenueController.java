package com.techelevator.controller;


import com.techelevator.dao.VenueDao;
import com.techelevator.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
//@PreAuthorize("isAuthenticated")
public class VenueController {

    @Autowired
    VenueDao theVenue;

    @GetMapping(path= {"/allVenues", "/"})
    public List<Venue> returnVenueData() {
        logTimestamp("Getting all venues");
        List<Venue> allVenues = theVenue.getAllVenues();

        return  allVenues;
    }

    @GetMapping("/venue/{venue_name}")
    public Venue returnVenueByName(@PathVariable String venue_name){
        logTimestamp("Returning venue" + venue_name);

        Venue venue = theVenue.getVenueByName(venue_name);

        return venue;

    }

    @PostMapping("/saveVenue")
    public void createVenue(@RequestBody Venue newVenue){
        theVenue.saveVenue(newVenue);
        logTimestamp("Creating new venue" + newVenue.getVenue_name());
    }

    @DeleteMapping("removeVenue/{venue_name}")
    public void removeVenue(@PathVariable String venue_name, Principal principal){
        theVenue.deleteVenue(venue_name);
        logTimestamp("Removing venue" + venue_name + "by user" + principal.getName());
    }

    @PutMapping("/editVenue/{venue_name}")
    public Venue updateVenueByName(@PathVariable String venue_name, @RequestBody Venue updatedVenue){
        logTimestamp("Updating venue " + venue_name );
        theVenue.updateVenue(updatedVenue, venue_name);
        return returnVenueByName(venue_name);
    }

    static void logTimestamp(String msg) {    // log timestamp of request to Console
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }
}
