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
@Document(collection = "ticket")
public class Ticket {

    @Id
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String eventId; //Id del Evento seleccionado
    private String ticketPriceId; //Id del boleto seleccionado
    private List<String> seatingName; // Asiendo o asientos asignados ejem A1, A2, A3
    private Integer totalTicketsPay; //Total de boletos comprados
    private Date createAt;
}
