package com.artbyte.controller;

import com.artbyte.model.Event;
import com.artbyte.service.EventService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/art/events")
@RequiredArgsConstructor
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final EventService eventService;

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/eventLocation/")
    public ResponseEntity<List<Event>> getEventLocation(@RequestParam String location){
        List<Event> events = eventService.getByLocation(location);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<Event> getEventById(@RequestParam String eventId){
        Event event = eventService.getById(eventId);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/eventName/")
    public ResponseEntity<Event> getEventByName(@RequestParam String eventName){
        Event event = eventService.getByEventName(eventName);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<Void> createEvent(@RequestBody Event event){
        eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateEventInfo(@PathVariable String id, @RequestBody Event event){
        eventService.updateEvent(id, event);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
