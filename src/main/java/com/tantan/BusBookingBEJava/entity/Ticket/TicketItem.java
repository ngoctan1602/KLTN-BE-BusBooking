package com.tantan.BusBookingBEJava.entity.Ticket;

import com.tantan.BusBookingBEJava.entity.Bill.Bill;
import com.tantan.BusBookingBEJava.entity.Seat.Seat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class TicketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
}
