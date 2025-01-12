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
        TicketPrice ticket = getByTicketType(ticketPrice.getTicketType());
        ticket.setStatus(TicketPriceConstant.ACTIVE.name);
        return ticketPriceRepository.save(ticket);
    }

    @Override
    public void updateTicketPriceInfo(String ticketPriceId, TicketPrice ticketPrice) {
        TicketPrice existingTicketPrice = getTicketPriceById(ticketPriceId);
        boolean hasChanges = false;

        if (!existingTicketPrice.getTicketType().equals(ticketPrice.getTicketType())) {
            existingTicketPrice.setTicketType(ticketPrice.getTicketType());
            hasChanges = true;
        }

        if (!existingTicketPrice.getPrice().equals(ticketPrice.getPrice())) {
            existingTicketPrice.setPrice(ticketPrice.getPrice());
            hasChanges = true;
        }

        if (!existingTicketPrice.getQuantityAvailable().equals(ticketPrice.getQuantityAvailable())) {
            existingTicketPrice.setQuantityAvailable(ticketPrice.getQuantityAvailable());
            hasChanges = true;
        }

        if (!existingTicketPrice.getStatus().equals(TicketPriceConstant.ACTIVE.name)) {
            existingTicketPrice.setStatus(TicketPriceConstant.ACTIVE.name);
            hasChanges = true;
        }

        if (hasChanges) {
            ticketPriceRepository.save(existingTicketPrice);
        } else {
            throw new TicketPriceException("No se detectaron cambios para actualizar el Ticket Price.");
        }
    }


    @Override
    public void updateQuantityTicket(String ticketPriceId, boolean addQuantity, Integer quantity) {
        TicketPrice ticketPriceObj = getTicketPriceById(ticketPriceId);
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
        TicketPrice ticketPriceObj = getTicketPriceById(ticketPriceId);
        String newStatus = (value == 1) ? TicketPriceConstant.ACTIVE.name : TicketPriceConstant.INACTIVE.name;
        ticketPriceObj.setStatus(newStatus);
        ticketPriceRepository.save(ticketPriceObj);
    }
}
