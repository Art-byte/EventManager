package com.artbyte.service.impl;

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
        return null;
    }

    @Override
    public EventSchedules findByBeginDateTime(Date beginDateTime) {
        return null;
    }

    @Override
    public void createNewSchedule(EventSchedules eventSchedules) {

    }

    @Override
    public void disableSchedule(String status) {

    }
}
