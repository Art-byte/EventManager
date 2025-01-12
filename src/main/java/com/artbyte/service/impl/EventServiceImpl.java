package com.artbyte.service.impl;

import com.artbyte.exceptions.EventException;
import com.artbyte.model.Event;
import com.artbyte.repository.EventRepository;
import com.artbyte.repository.EventSchedulesRepository;
import com.artbyte.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventSchedulesRepository eventSchedulesRepository;

    @Override
    public List<Event> getAllEvents() {
        List<Event> list = eventRepository.findAll();
        if(list.isEmpty()){
            throw new EventException("No se encontraron eventos");
        }
        return list;
    }

    @Override
    public Event getByEventName(String eventName) {
        return eventRepository.findByEventName(eventName)
                .orElseThrow(()-> new EventException("Evento no encontrado por NAME"));
    }

    @Override
    public Event getById(String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EventException("Evento no encontrado por ID"));
    }

    @Override
    public List<Event> getByLocation(String location) {
        List<Event> list = eventRepository.findByLocation(location);
        if(list.isEmpty()){
            throw new EventException("No hay eventos para esta locacion");
        }
        return list;
    }

    @Override
    public void createEvent(Event event) {
        if (eventRepository.existsByEventNameAndLocation(event.getEventName(), event.getLocation())) {
            throw new EventException("Este evento ya existe");
        }
        Event newEvent = Event.builder()
                .eventName(event.getEventName())
                .location(event.getLocation())
                .eventScheduleId(event.getEventScheduleId() != null ? event.getEventScheduleId() : new ArrayList<>())
                .ticketPriceId(event.getTicketPriceId() != null ? event.getTicketPriceId() : new ArrayList<>())
                .seatingId(event.getSeatingId())
                .build();
        eventRepository.save(newEvent);
    }


    @Override
    public void updateEvent(String eventId, Event event) {
        Event existingEvent = getById(eventId);
        Event updatedEvent = Event.builder()
                .id(existingEvent.getId())
                .eventName(event.getEventName() != null ? event.getEventName() : existingEvent.getEventName())
                .location(event.getLocation() != null ? event.getLocation() : existingEvent.getLocation())
                .eventScheduleId(event.getEventScheduleId() != null ? event.getEventScheduleId() : existingEvent.getEventScheduleId())
                .ticketPriceId(event.getTicketPriceId() != null ? event.getTicketPriceId() : existingEvent.getTicketPriceId())
                .seatingId(event.getSeatingId() != null ? event.getSeatingId() : existingEvent.getSeatingId())
                .build();
        eventRepository.save(updatedEvent);
    }


    @Override
    public void updateEventSchedule(String id, List<String> eventSchedulesIds) {
        if (eventSchedulesIds == null || eventSchedulesIds.isEmpty()) {
            throw new EventException("La lista de horarios no puede estar vacía o ser nula");
        }
        for (String scheduleId : eventSchedulesIds) {
            if (!eventSchedulesRepository.existsById(scheduleId)) {
                throw new EventException("El horario con ID " + scheduleId + " no existe");
            }
        }
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventException("Evento no encontrado por ID"));
        event.setEventScheduleId(eventSchedulesIds);
        eventRepository.save(event);
    }


    @Override
    public void deleteEvent(String id) {
        Event event = getById(id);
        eventRepository.deleteById(id);
    }

}
