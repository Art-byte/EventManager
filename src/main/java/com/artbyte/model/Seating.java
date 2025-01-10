package com.artbyte.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "seating")
public class Seating {

    @Id
    private String id;
    private List<SeatingName> seatingNames;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class SeatingName{
        private String id;
        private String name; //A1, A2, etc...
        private Integer status; //Vendido, Reservado, Disponible
        private String seatingCode; //Codigo autogenerado
        private boolean isChecked; //Cuando el boleto sea escaneado

    }
}
