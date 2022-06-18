package com.techelevator.model;


public class Event {

    private Long event_id;
    private String eventName;
    private String genre;
    private String startTime;
    private String date;
    private String minAge;
    private String eventImg;
    private String venueName;

    public Event(){};

    public Event(Long event_id, String eventName, String genre, String startTime, String date, String minAge, String eventImg, String venueName) {
        this.event_id = event_id;
        this.eventName = eventName;
        this.genre = genre;
        this.startTime = startTime;
        this.date = date;
        this.minAge = minAge;
        this.eventImg = eventImg;
        this.venueName = venueName;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMinAge() {
        return minAge;
    }

    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    public String getEventImg() {
        return eventImg;
    }

    public void setEventImg(String eventImg) {
        this.eventImg = eventImg;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event_id=" + event_id +
                ", eventName='" + eventName + '\'' +
                ", genre='" + genre + '\'' +
                ", startTime='" + startTime + '\'' +
                ", date=" + date +
                ", minAge='" + minAge + '\'' +
                ", eventImg='" + eventImg + '\'' +
                ", venueName='" + venueName + '\'' +
                '}';
    }
}
