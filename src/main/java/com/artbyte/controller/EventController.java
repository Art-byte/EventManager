package com.artbyte.controller;

import com.artbyte.model.Event;
import com.artbyte.service.EventService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable String eventId){
        Event event = eventService.findById(eventId);
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public ResponseEntity<Event> getEventByName(@RequestParam String eventName){
        Event event = eventService.findByEventName(eventName);
        return ResponseEntity.ok(event);
    }

}
