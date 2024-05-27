package com.tantan.BusBookingBEJava.service.Ticket.Ticket;

import com.tantan.BusBookingBEJava.request.Ticket.TicketRequest;

public interface ITicketService {
    public boolean createNewTicket(TicketRequest ticketRequest);
}
