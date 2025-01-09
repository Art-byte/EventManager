package com.artbyte.repository;

import com.artbyte.model.TicketPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPriceRepository extends MongoRepository<TicketPrice, String> {
}
