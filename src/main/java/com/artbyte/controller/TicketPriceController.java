package com.artbyte.controller;

import com.artbyte.model.TicketPrice;
import com.artbyte.service.TicketPriceService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/art/ticketPrice")
@RequiredArgsConstructor
public class TicketPriceController {

    private TicketPriceService ticketPriceService;

    @GetMapping("/ticketsActive")
    public ResponseEntity<List<TicketPrice>> getAllTicketWithStatusIsActive(){
        List<TicketPrice> list = ticketPriceService.getAllTicketWithStatusIsActive();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketPrice> getTicketPriceById(@PathVariable String id){
        TicketPrice ticket = ticketPriceService.getTicketPriceById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/type/{ticketType}")
    public ResponseEntity<TicketPrice> getByTicketType(@PathVariable String ticketType){
        TicketPrice ticket = ticketPriceService.getByTicketType(ticketType);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TicketPrice> createTicketPrice(@RequestBody TicketPrice ticketPrice){
        TicketPrice ticket = ticketPriceService.createTicketPrice(ticketPrice);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @PutMapping("/update/info/{ticketPriceId}")
    public ResponseEntity<Void>updateTicketPriceInfo(@PathVariable String ticketPriceId, @RequestBody TicketPrice ticketPrice){
        ticketPriceService.updateTicketPriceInfo(ticketPriceId, ticketPrice);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/quantity/{ticketPriceId}")
    public ResponseEntity<Void> updateQuantityTicket(@PathVariable String ticketPriceId, @RequestParam boolean addQuantity, @RequestParam Integer quantity){
        ticketPriceService.updateQuantityTicket(ticketPriceId, addQuantity, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/status/{ticketPriceId}")
    public ResponseEntity<Void> changeStatusTicketPrice(@PathVariable String ticketPriceId, @RequestParam int value){
        ticketPriceService.changeStatusTicketPrice(ticketPriceId, value);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
