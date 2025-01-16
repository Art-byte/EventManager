package com.artbyte.mapper;


import com.artbyte.model.Event;
import com.artbyte.model.EventSchedules;
import com.artbyte.model.Ticket;
import com.artbyte.model.TicketPrice;
import com.artbyte.records.TicketRecord;
import com.artbyte.service.EventSchedulesService;
import com.artbyte.service.EventService;
import com.artbyte.service.TicketPriceService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketMapper {

    private final TicketPriceService ticketPriceService;
    private final EventService eventService;
    private final EventSchedulesService eventSchedulesService;

    public TicketRecord mapperTicket(Ticket ticket, String seatingName){
        Event eventObj = eventService.getById(ticket.getId());
        EventSchedules eventScheduleObj = eventSchedulesService.getById(ticket.getEventScheduleId());
        TicketPrice ticketPriceObj = ticketPriceService.getTicketPriceById(ticket.getTicketPriceId());
        return new TicketRecord(
                eventObj.getEventName(),
                eventObj.getLocation(),

                eventScheduleObj.getBeginDateTime(),
                eventScheduleObj.getEndDateTime(),

                ticketPriceObj.getTicketType(),
                ticketPriceObj.getPrice(),

                ticket.getTotalTicketsPay(),
                ticket.getFullName(),
                ticket.getEmail(),
                ticket.getPhone(),
                seatingName
        );
    }

}
