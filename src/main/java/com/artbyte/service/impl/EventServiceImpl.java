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
        Event event = eventRepository.findByEventName(eventName);
        if(event == null){
            throw new EventException("Evento no encontrado");
        }
        return event;
    }

    @Override
    public Event findById(String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EventException("Evento no encontrado"));
    }

    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Event updateEvent(String id, Event event) {
        Event eventObj = eventRepository.findById(id)
                .orElseThrow(() -> new EventException("Evento no encontrado"));
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
