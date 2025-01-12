package com.artbyte.service;

import com.artbyte.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    Event findByEventName(String eventName);
    Event findById(String id);
    Event findByLocation(String location);
    Event updateEvent(String id, Event event);
    void createEvent(Event event);
    void deleteEvent(String id);
}
