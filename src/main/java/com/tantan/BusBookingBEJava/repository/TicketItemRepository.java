package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Ticket.TicketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketItemRepository extends JpaRepository<TicketItem,Long> {
}
