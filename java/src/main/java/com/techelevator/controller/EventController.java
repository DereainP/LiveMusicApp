package com.techelevator.controller;


import com.techelevator.dao.EventDao;
import com.techelevator.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class EventController {

    @Autowired
    EventDao theEvents;

    @GetMapping(path={"/allEvents","/"})
    public List<Event> returnEventData() {
        logTimestamp("Getting all events");
        List<Event> allEvents = theEvents.getAllEvents();

        return allEvents;
    }

    @GetMapping("/event/{event_id}")
    public Event returnEventById(@PathVariable Long event_id){
        logTimestamp("Returning event" + event_id);
        Event event = theEvents.getEventById(event_id);

        return event;
    }

    @PostMapping("/saveEvent")
    public void createEvent(@RequestBody Event newEvent){
        theEvents.saveEvent(newEvent);
        logTimestamp("Creating new event" + newEvent.getEventName());
    }

    @DeleteMapping("/removeEvent/{event_id}")
    public void removeEvent(@PathVariable Long event_id, Principal principal){
        theEvents.deleteEvent(event_id);
        logTimestamp("Removing event" + event_id + "by user" + principal.getName());
    }

    @PutMapping("/editEvent/{event_id}")
    public Event updateEventById(@PathVariable Long event_id, @RequestBody Event updatedEvent){
        logTimestamp("Updating Event" + event_id);
        theEvents.updateEvent(updatedEvent, event_id);
        return returnEventById(event_id);
    }
//    @GetMapping("/event/{event_name}")
//    public Event returnEventByName(@PathVariable String eventName){
//        logTimestamp("Returning event" + eventName);
//        Event event = theEvents.getEventByName(eventName);
//
//        return event;
//    }
//    @GetMapping("/event/{venue_name}")
//    public Event returnEventByVenue(@PathVariable String venueName){
//        logTimestamp("Returning event" + venueName);
//        Event event = theEvents.getEventByVenue(venueName);
//
//        return event;
//    }


    static void logTimestamp(String msg) {    // log timestamp of request to Console
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }

}


