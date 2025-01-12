package com.artbyte.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ticket_price")
public class TicketPrice {
    @Id
    private String id;
    private String ticketType;
    private Double price;
    private Integer quantityAvailable;
    private String status;
}
