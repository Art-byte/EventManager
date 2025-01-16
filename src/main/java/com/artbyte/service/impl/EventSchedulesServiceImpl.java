package com.artbyte.service.impl;

import com.artbyte.exceptions.EventSchedulesException;
import com.artbyte.model.EventSchedules;
import com.artbyte.repository.EventSchedulesRepository;
import com.artbyte.service.EventSchedulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class EventSchedulesServiceImpl implements EventSchedulesService {

    private final EventSchedulesRepository eventSchedulesRepository;

    @Override
    public EventSchedules getById(String id) {
        return eventSchedulesRepository.findById(id)
                .orElseThrow(() -> new EventSchedulesException("Esquema no encontrado por ID"));
    }

    @Override
    public EventSchedules findByBeginDateTime(Date beginDateTime) {
        return eventSchedulesRepository.findByBeginDateTime(beginDateTime)
                .orElseThrow(() -> new EventSchedulesException("Esquema no encontrado por FECHA"));
    }

    @Override
    public void createNewSchedule(EventSchedules eventSchedules) {
        eventSchedulesRepository.save(eventSchedules);
    }

    @Override
    public void disableSchedule(String id, String status) {
        EventSchedules schedule = getById(id);
        schedule.setStatus(status);
        eventSchedulesRepository.save(schedule);
    }
}
