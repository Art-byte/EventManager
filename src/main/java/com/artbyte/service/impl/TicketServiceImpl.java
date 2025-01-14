package com.artbyte.service.impl;

import com.artbyte.model.Ticket;
import com.artbyte.repository.TicketRepository;
import com.artbyte.service.EventService;
import com.artbyte.service.TickerService;
import com.artbyte.service.TicketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TickerService {

    private final TicketRepository ticketRepository;
    private final EventService eventService;
    private final TicketPriceService ticketPriceService;

    @Override
    public Ticket createTicket(Ticket ticket) {
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
}
