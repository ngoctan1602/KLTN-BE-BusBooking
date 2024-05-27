package com.tantan.BusBookingBEJava.service.Ticket.TicketItem;

import com.tantan.BusBookingBEJava.entity.Seat.Seat;
import com.tantan.BusBookingBEJava.entity.Ticket.Ticket;

public interface ITicketItemService {
    public boolean createNewTicketItem(Seat seat, Ticket ticket);
}
