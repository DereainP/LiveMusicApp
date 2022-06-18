package com.techelevator.dao;

import com.techelevator.model.Event;

import java.util.List;

public interface EventDao {
     List<Event> getAllEvents();

     Event getEventById(Long event_id);

     void saveEvent(Event eventToSave);

     void deleteEvent(Long event_id);

     void updateEvent(Event eventToSave, Long event_id);

     Event getEventByName(String eventName);

     Event getEventByVenue(String venueName);



}
