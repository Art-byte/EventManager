package com.artbyte.repository;

import com.artbyte.model.EventSchedules;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface EventSchedulesRepository extends MongoRepository<EventSchedules, String> {
    Optional<EventSchedules> findByBeginDateTime(Date beginDateTime);
}
