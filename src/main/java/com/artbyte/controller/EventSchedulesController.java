package com.artbyte.controller;

import com.artbyte.model.EventSchedules;
import com.artbyte.service.EventSchedulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/art/eventSchedule")
@RequiredArgsConstructor
public class EventSchedulesController {

    private final EventSchedulesService eventSchedulesService;

    @GetMapping("/all")
    public ResponseEntity<List<EventSchedules>> getAllSchedules(){
        List<EventSchedules> list = eventSchedulesService.getAllEvents();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventSchedules> getById(@PathVariable String id){
        EventSchedules event = eventSchedulesService.getById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("/getByDate/{beginDate}")
    public ResponseEntity<EventSchedules> getByDate(@PathVariable Date beginDate){
        EventSchedules event = eventSchedulesService.getByBeginDateTime(beginDate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/created")
    public ResponseEntity<Void> createSchedule(@RequestBody EventSchedules eventSchedules){
        eventSchedulesService.createNewSchedule(eventSchedules);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/schedule/{id}/{status}")
    public ResponseEntity<Void> disableSchedule(@PathVariable String id, @PathVariable String status){
        eventSchedulesService.disableSchedule(id, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
