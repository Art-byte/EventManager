package com.artbyte.service;


import com.artbyte.model.EventSchedules;

import java.util.Date;

public interface EventSchedulesService {

    EventSchedules getById(String id);
    EventSchedules findByBeginDateTime(Date beginDateTime);
    void createNewSchedule(EventSchedules eventSchedules);
    void disableSchedule(String id, String status);
}
