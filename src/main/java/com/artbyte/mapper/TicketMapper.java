package com.artbyte.mapper;


import com.artbyte.model.Event;
import com.artbyte.model.Ticket;
import com.artbyte.records.TicketRecord;
import com.artbyte.service.EventService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketMapper {

    private final EventService eventService;

//    public TicketRecord mapperTicket(Ticket ticket, String seatingName){
//        Event eventObj = eventService.getById(ticket.getId());
//
//        return new TicketRecord(
//                eventObj.getEventName(),
//                eventObj.getLocation(),
//
//
//                ticket.getFullName(),
//                ticket.getEmail(),
//                ticket.getPhone(),
//                seatinName
//        );
//    }

}
