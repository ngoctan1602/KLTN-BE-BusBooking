package com.tantan.BusBookingBEJava.service.Ticket.TicketItem;

import com.tantan.BusBookingBEJava.entity.Seat.Seat;
import com.tantan.BusBookingBEJava.entity.Ticket.Ticket;
import com.tantan.BusBookingBEJava.entity.Ticket.TicketItem;
import com.tantan.BusBookingBEJava.repository.TicketItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketItemService implements ITicketItemService{
    @Autowired
    private TicketItemRepository ticketItemRepository;

    @Override
    @Transactional
    public boolean createNewTicketItem(Seat seat, Ticket ticket) {
        TicketItem ticketItem = new TicketItem();
        ticketItem.setTicket(ticket);
        ticketItem.setSeat(seat);
        try {
            ticketItemRepository.save(ticketItem);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
