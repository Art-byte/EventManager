package com.artbyte.service.impl;

import com.artbyte.exceptions.TicketException;
import com.artbyte.model.Event;
import com.artbyte.model.Ticket;
import com.artbyte.repository.EventRepository;
import com.artbyte.repository.TicketRepository;
import com.artbyte.service.TickerService;
import com.artbyte.service.TicketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TickerService {

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        //Validamos que exista el evento
        if(!validateEventAvailable(ticket.getEventId())){
            throw new TicketException("El evento no esta disponible");
        }

        Ticket createdTicket = Ticket.builder()
                .fullName(ticket.getFullName())
                .email(ticket.getEmail())
                .phone(ticket.getPhone())
                .eventId(ticket.getEventId())
                .ticketPriceId(ticket.getTicketPriceId())
                .seatingName(ticket.getSeatingName())
                .totalTicketsPay(ticket.getTotalTicketsPay())
                .createAt(new Date())
                .build();
        ticketRepository.save(createdTicket);
        return createdTicket;
    }

    private boolean validateEventAvailable(String eventId){
         return eventRepository.existsById(eventId);
    }
}
