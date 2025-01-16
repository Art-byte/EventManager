//package com.artbyte.mapper;
//
//
//import com.artbyte.model.Event;
//import com.artbyte.model.EventSchedules;
//import com.artbyte.model.Ticket;
//import com.artbyte.records.TicketRecord;
//import com.artbyte.service.EventSchedulesService;
//import com.artbyte.service.EventService;
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//public class TicketMapper {
//
//    private final EventService eventService;
//    private final EventSchedulesService eventSchedulesService;
//
//    public TicketRecord mapperTicket(Ticket ticket, String seatingName){
//        Event eventObj = eventService.getById(ticket.getId());
//        EventSchedules eventScheduleObj = eventSchedulesService.getById(ticket.getEventScheduleId());
//
//        return new TicketRecord(
//                eventObj.getEventName(),
//                eventObj.getLocation(),
//
//                eventScheduleObj.getBeginDateTime(),
//                eventScheduleObj.getEndDateTime(),
//
//
//                ticket.getFullName(),
//                ticket.getEmail(),
//                ticket.getPhone(),
//                seatinName
//        );
//    }
//
//}
