package com.artbyte.service;

import com.artbyte.model.TicketPrice;

import java.util.List;

public interface TicketPriceService {

    List<TicketPrice> getAllTicketWithStatusIsActive();
    TicketPrice getTicketPriceById(String id);
    TicketPrice getByTicketType(String ticketType);
    TicketPrice createTicketPrice(TicketPrice ticketPrice);

    void updateTicketPriceInfo(String ticketPriceId, TicketPrice ticketPrice);
    void updateQuantityTicket(String ticketPriceId, boolean addQuantity, Integer quantity);
    void changeStatusTicketPrice(String ticketPriceId, int value);
}
