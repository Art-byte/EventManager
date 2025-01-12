package com.artbyte.service;

import com.artbyte.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    Event getByEventName(String eventName);
    Event getById(String id);
    List<Event> getByLocation(String location);
    void updateEvent(String id, Event event);
    void updateEventSchedule(String id, List<String> eventSchedulesIds);
    void createEvent(Event event);
    void deleteEvent(String id);
}
