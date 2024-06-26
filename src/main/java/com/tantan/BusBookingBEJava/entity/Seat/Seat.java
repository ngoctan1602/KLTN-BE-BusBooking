package com.tantan.BusBookingBEJava.entity.Seat;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Ticket.TicketItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "typeseat_id")
    private TypeSeat typeSeat;
    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
    @OneToMany(mappedBy = "seat")
    private List<TicketItem> ticketItem= new ArrayList<>();
}
