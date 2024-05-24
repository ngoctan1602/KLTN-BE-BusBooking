package com.tantan.BusBookingBEJava.entity.Bus;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Company.Company;
import com.tantan.BusBookingBEJava.entity.Review.Review;
import com.tantan.BusBookingBEJava.entity.Route.Route;
import com.tantan.BusBookingBEJava.entity.Seat.Seat;
import com.tantan.BusBookingBEJava.entity.Ticket.Ticket;
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
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    private String name;
    private String licensePlate;
    @OneToMany(mappedBy = "bus")
    private List<Seat> seatList = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "typebus_id")
    private TypeBus typeBus;

    @ManyToMany
    @JoinTable(name = "bus_route",
            joinColumns = @JoinColumn(name = "bus_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "route_id", referencedColumnName = "id")
    )
    private List<Route> routes;
    @OneToMany(mappedBy = "bus")
    private List<Ticket> tickets = new ArrayList<>();
    @OneToMany(mappedBy = "bus")
    private List<Review> reviews = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
