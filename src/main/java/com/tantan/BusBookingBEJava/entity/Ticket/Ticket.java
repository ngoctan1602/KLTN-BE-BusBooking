package com.tantan.BusBookingBEJava.entity.Ticket;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Route.Route;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp departureTime;//xuất bến
    private Timestamp arrivalTime;// cập bến

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
    @OneToMany(mappedBy = "ticket")
    private List<TicketItem> ticketItems = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
