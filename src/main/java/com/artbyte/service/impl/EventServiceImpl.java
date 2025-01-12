package com.artbyte.service.impl;

import com.artbyte.exceptions.EventException;
import com.artbyte.model.Event;
import com.artbyte.repository.EventRepository;
import com.artbyte.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        List<Event> list = eventRepository.findAll();
        if(list.isEmpty()){
            throw new EventException("No se encontraron eventos");
        }
        return list;
    }

    @Override
    public Event findByEventName(String eventName) {
        return eventRepository.findByEventName(eventName)
                .orElseThrow(()-> new EventException("Evento no encontrado por NAME"));
    }

    @Override
    public Event findById(String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EventException("Evento no encontrado por ID"));
    }

    @Override
    public Event findByLocation(String location) {
        return eventRepository.findByLocation(location)
                .orElseThrow(() -> new EventException("Evento no encontrado por LOCATION"));
    }

    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Event updateEvent(String id, Event event) {
        Event eventObj = eventRepository.findById(id)
                .orElseThrow(() -> new EventException("Evento no encontrado por ID"));
        eventObj.setEventName(event.getEventName());
        eventObj.setLocation(event.getLocation());
        eventObj.setEventScheduleId(event.getEventScheduleId());
        eventObj.setTicketPriceId(event.getTicketPriceId());
        eventObj.setSeatingId(event.getSeatingId());
        return eventRepository.save(eventObj);
    }

    @Override
    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }
}
