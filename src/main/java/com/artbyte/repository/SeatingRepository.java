package com.artbyte.repository;

import com.artbyte.model.Seating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatingRepository extends MongoRepository<Seating, String> {
}
