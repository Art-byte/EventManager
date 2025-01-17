package com.artbyte.handlers;

import com.artbyte.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Problema al acceder a la base de datos
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDataAccessException(DataAccessException e){
        LOGGER.error("Error al intentar acceder a la base de datos", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al intentar acceder a la base de datos");
    }

    // Cuando se da un error desconocido
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e){
        LOGGER.error("Error desconocido", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocurrio un error desconocido");
    }

    // Excepcion para los datos de events
    @ExceptionHandler(EventException.class)
    public ResponseEntity<String> handleEventException(EventException e){
        LOGGER.error("Event exception: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    // Excepcion para los TicketPrice
    @ExceptionHandler(TicketPriceException.class)
    public ResponseEntity<String> handleTicketPricetException(TicketPriceException e){
        LOGGER.error("TicketType exception: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    //Excepcion para el ticket
    @ExceptionHandler(TicketException.class)
    public ResponseEntity<String> handlerTicketException(TicketException e){
        LOGGER.error("Ticket exception: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    //Excepcion para los esquemas
    @ExceptionHandler(EventSchedulesException.class)
    public ResponseEntity<String> handlerEventSchedulesException(EventException e){
        LOGGER.error("EventSchedules exception: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    //Excepcion para los asientos
    @ExceptionHandler(SeatingException.class)
    public ResponseEntity<String> handlerSeatingException(SeatingException e){
        LOGGER.error("Seating exception: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
}
