package com.tantan.BusBookingBEJava.entity.Bill;

import com.tantan.BusBookingBEJava.entity.Price.Price;
import com.tantan.BusBookingBEJava.entity.Ticket.TicketItem;
import com.tantan.BusBookingBEJava.entity.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
    @OneToMany(mappedBy = "bill")
    private List<TicketItem> ticketItem= new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "price_id")
    private Price price;
}
