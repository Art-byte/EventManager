package com.artbyte.repository;

import com.artbyte.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    Optional<Event> findByEventName(String eventName);
    List<Event> findByLocation(String location);
    boolean existsByEventNameAndLocation(String evenName, String location);
}
