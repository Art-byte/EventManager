package com.artbyte.repository;

import com.artbyte.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    Optional<Event> findByEventName(String eventName);
    Optional<Event> findByLocation(String location);
}
