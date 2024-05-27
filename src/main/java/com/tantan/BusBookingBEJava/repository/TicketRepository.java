package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
