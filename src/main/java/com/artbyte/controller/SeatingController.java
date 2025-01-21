package com.artbyte.controller;

import com.artbyte.model.Seating;
import com.artbyte.service.SeatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/art/seatings")
@RequiredArgsConstructor
public class SeatingController {

    private SeatingService seatingService;

    @GetMapping("/seating/{id}")
    public ResponseEntity<Seating> getSeatingById(@PathVariable String id){
        Seating seating = seatingService.getSeatingById(id);
        return new ResponseEntity<>(seating, HttpStatus.OK);
    }

    @GetMapping("/seating/{seatingId}/seatingName/{seatingName}")
    public ResponseEntity<Seating.SeatingName> getSeatingNameByName(
            @PathVariable String seatingId,
            @PathVariable String seatingName){
        Seating.SeatingName seatingData = seatingService.getSeatingNameByName(seatingId, seatingName);
        return new ResponseEntity<>(seatingData, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createSeating(@RequestBody Seating seating){
        seatingService.createSeating(seating);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/changeStatus/{idSeating}/{nameSeating}/{status}")
    public ResponseEntity<Void> changeStatusToSeating(
            @PathVariable String idSeating,
            @PathVariable String nameSeating,
            @PathVariable Integer status){
        seatingService.changeStatusToSeating(idSeating, nameSeating, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/checkedTicket/{idSeating}/{nameSeating}/{status}")
    public ResponseEntity<Void> changeCheckedFromTicket(
            @PathVariable String idSeating,
            @PathVariable String nameSeating,
            boolean checked){
        seatingService.changeCheckedFromTicket(idSeating, nameSeating, checked);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
