package com.tantan.BusBookingBEJava.entity.Seat;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Ticket.TicketItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "typeSeatId")
    private TypeSeat typeSeat;
    @ManyToOne
    @JoinColumn(name = "busId")
    private Bus bus;
    @OneToOne(mappedBy = "seat")
    private TicketItem ticketItem;
}
