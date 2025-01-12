package com.artbyte.service.impl;

import com.artbyte.constans.TicketPriceConstant;
import com.artbyte.exceptions.TicketPriceException;
import com.artbyte.model.TicketPrice;
import com.artbyte.repository.TicketPriceRepository;
import com.artbyte.service.TicketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketPriceServiceImpl implements TicketPriceService {

    private final TicketPriceRepository ticketPriceRepository;

    @Override
    public List<TicketPrice> getAllTicketWithStatusIsActive() {
        List<TicketPrice> list = ticketPriceRepository.findByStatus(TicketPriceConstant.ACTIVE.name);
        if(list.isEmpty()){
            throw new TicketPriceException("No se encontraron precios de boletos con el estado activo.");
        }
        return list;
    }

    @Override
    public TicketPrice getTicketPriceById(String id) {
        return ticketPriceRepository.findById(id)
                .orElseThrow(() -> new TicketPriceException("No se encontro el Ticket Price solicitado por ID"));
    }

    @Override
    public TicketPrice getByTicketType(String ticketType) {
        return ticketPriceRepository.findByTicketType(ticketType)
                .orElseThrow(() -> new TicketPriceException("No se encontro el Ticket Price solicitado por TIPO"));
    }

    @Override
    public TicketPrice createTicketPrice(TicketPrice ticketPrice) {
        return ticketPriceRepository.save(ticketPrice);
    }

    @Override
    public void updateTicketPriceInfo(String ticketPriceId, TicketPrice ticketPrice) {
        TicketPrice ticketPriceObj = ticketPriceRepository.findById(ticketPriceId)
                .orElseThrow(() -> new TicketPriceException("No se encontro el Ticket Price solicitado por ID"));

        ticketPriceObj.setTicketType(ticketPrice.getTicketType());
        ticketPriceObj.setPrice(ticketPrice.getPrice());
        ticketPriceObj.setQuantityAvailable(ticketPrice.getQuantityAvailable());
        ticketPriceObj.setStatus(TicketPriceConstant.ACTIVE.name);
        ticketPriceRepository.save(ticketPriceObj);
    }

    @Override
    public void updateQuantityTicket(String ticketPriceId, boolean addQuantity, Integer quantity) {
        TicketPrice ticketPriceObj = ticketPriceRepository.findById(ticketPriceId)
                .orElseThrow(() -> new TicketPriceException("No se encontró el Ticket Price solicitado por ID"));
        int newQuantity = addQuantity
                ? ticketPriceObj.getQuantityAvailable() + quantity
                : ticketPriceObj.getQuantityAvailable() - quantity;
        if (newQuantity < 0) {
            throw new TicketPriceException("La cantidad no puede ser negativa.");
        }
        ticketPriceObj.setQuantityAvailable(newQuantity);
        ticketPriceRepository.save(ticketPriceObj);
    }

    @Override
    public void changeStatusTicketPrice(String ticketPriceId, int value) {
        if (value != 1 && value != 0) {
            throw new TicketPriceException("El valor de estado proporcionado no es válido.");
        }
        TicketPrice ticketPriceObj = ticketPriceRepository.findById(ticketPriceId)
                .orElseThrow(() -> new TicketPriceException("No se encontró el Ticket Price solicitado por ID"));
        String newStatus = (value == 1) ? TicketPriceConstant.ACTIVE.name : TicketPriceConstant.INACTIVE.name;
        ticketPriceObj.setStatus(newStatus);
        ticketPriceRepository.save(ticketPriceObj);
    }
}
