package com.tantan.BusBookingBEJava.entity.Route;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Ticket.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
@Getter
@Setter
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private Status status;
    @OneToMany(mappedBy = "route")
    private List<BusStop> busStops = new ArrayList<>();
    @ManyToMany
    private List<Bus> busList = new ArrayList<>();
    @OneToMany(mappedBy = "route")
    private List<Ticket> tickets = new ArrayList<>();
}
