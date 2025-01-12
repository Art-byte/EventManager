package com.artbyte.repository;

import com.artbyte.model.TicketPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketPriceRepository extends MongoRepository<TicketPrice, String> {
    List<TicketPrice> findByStatus(String status);
    Optional<TicketPrice> findByTicketType(String ticketType);
}
