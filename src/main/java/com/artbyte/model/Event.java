package com.artbyte.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "event")
public class Event {

    @Id
    private String id;
    private String eventName;
    private String location;
    private List<Date> dateEvent;
    private Integer seating;
    private List<String> ticketPrice;
}
