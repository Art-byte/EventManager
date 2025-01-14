package com.artbyte.records;

import java.util.Date;

public record TicketRecord(
        //Event
        String eventName,
        String eventLocation,

        //Event Schedules
        Date beginDateTime,
        Date endDateTime,

        //TicketPrice
        String ticketType,
        String ticketPrice,

        //Ticket
        Integer totalTickets,
        String fullName,
        String email,
        String phone,
        String seatingName
) {}
