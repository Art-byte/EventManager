package com.artbyte.service;


import com.artbyte.model.EventSchedules;

import java.util.Date;
import java.util.List;

public interface EventSchedulesService {

    List<EventSchedules> getAllEvents();
    EventSchedules getById(String id);
    EventSchedules getByBeginDateTime(Date beginDateTime);
    void createNewSchedule(EventSchedules eventSchedules);
    void disableSchedule(String id, String status);
}
