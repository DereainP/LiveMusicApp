package com.techelevator.dao;


import com.techelevator.model.Event;
import com.techelevator.model.EventDoesNotExistException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Component
public class jdbcEventDao implements  EventDao{

    private JdbcTemplate template;

    public jdbcEventDao(DataSource dataSource){ template = new JdbcTemplate(dataSource);}

    @Override
    public List<Event> getAllEvents() {
        List<Event> eventList = new ArrayList<>();
        String sql = "Select * from event";
        SqlRowSet results = template.queryForRowSet(sql);
        while(results.next()){
            eventList.add(mapResultsToEvent(results));
        }
        return eventList;
    }

    @Override
    public Event getEventById(Long event_id) {
        String sql = "Select * from event where event_id = ?";
        SqlRowSet result = template.queryForRowSet(sql,event_id);
        if(result.next()){
            return mapResultsToEvent(result);
        }else{
            throw new EventDoesNotExistException();
        }
    }

    @Override
    public void saveEvent(Event eventToSave) {
        String sql = "Insert into event (event_Name, genre, start_time, date, min_age, event_img, venue_name)"
                + "values(?,?,?,?,?,?,?)";
        template.update(sql, eventToSave.getEventName(),eventToSave.getGenre(),eventToSave.getStartTime(),
                eventToSave.getDate(),eventToSave.getMinAge(),eventToSave.getEventImg(),eventToSave.getVenueName());
    }

    @Override
    public void deleteEvent(Long event_id) {
            String sql = "delete from event where event_id = ?";
            template.update(sql, event_id);
    }

    @Override
    public void updateEvent(Event eventToSave, Long event_id) {
        String sql = "Update event set event_name = ?, genre = ?, start_time = ?, date = ?,"
                + "min_age = ?, event_img = ?, venue_name = ?";
        template.update(sql, eventToSave.getEventName(), eventToSave.getGenre(), eventToSave.getStartTime(),
                eventToSave.getDate(), eventToSave.getMinAge(), eventToSave.getEventImg(), eventToSave.getVenueName());
    }

    @Override
    public Event getEventByName(String eventName) {
        String sql = "Select * from event where event_name = ?";
        SqlRowSet result = template.queryForRowSet(sql,eventName);
        if(result.next()){
            return mapResultsToEvent(result);
        }else{
            throw new EventDoesNotExistException();
        }
    }


    @Override
    public Event getEventByVenue(String venueName) {
        String sql = "Select * from event where venue_name = ?";
        SqlRowSet result = template.queryForRowSet(sql,venueName);
        if(result.next()){
            return mapResultsToEvent(result);
        }else{
            throw new EventDoesNotExistException();
        }
    }


    private Event mapResultsToEvent(SqlRowSet result){
        Event retrievedEvent = null;
        Long event_id = result.getLong("event_id");
        String eventName = result.getString("event_name");
        String genre = result.getString("genre");
        String startTime = result.getString("start_time");
        String date = result.getString("date");
        String minAge = result.getString("min_age");
        String eventImg = result.getString("event_img");
        String venueName = result.getString("venue_name");

        retrievedEvent = new Event(event_id,eventName,genre,startTime,date,minAge,eventImg,venueName);
        return retrievedEvent;

    }
}
