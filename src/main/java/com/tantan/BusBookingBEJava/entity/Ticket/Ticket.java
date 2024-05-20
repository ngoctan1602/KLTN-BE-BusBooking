package com.tantan.BusBookingBEJava.entity.Ticket;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @ManyToOne
    @JoinColumn(name = "busId")
    private Bus bus;
    @OneToMany(mappedBy = "ticket")
    private List<TicketItem> ticketItems = new ArrayList<>();
}
