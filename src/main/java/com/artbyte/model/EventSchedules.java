package com.artbyte.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "event_schedules")
public class EventSchedules {

    @Id
    private String id;
    private Date beginDateTime; // Fecha y hora de inicio
    private Date endDateTime;   // Fecha y hora de fin

}
