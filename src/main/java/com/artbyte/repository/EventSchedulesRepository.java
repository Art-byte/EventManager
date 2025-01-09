package com.artbyte.repository;

import com.artbyte.model.EventSchedules;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventSchedulesRepository extends MongoRepository<EventSchedules, String> {
}
