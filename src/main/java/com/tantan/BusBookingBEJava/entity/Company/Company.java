package com.tantan.BusBookingBEJava.entity.Company;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Price.Price;
import com.tantan.BusBookingBEJava.entity.Seat.TypeSeat;
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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;
    private String logo;
    private Status status;
    @OneToMany(mappedBy = "company")
    private List<Bus> busList = new ArrayList<>();
    @OneToMany(mappedBy = "company")
    private List<TypeSeat> typeSeats = new ArrayList<>();
    @OneToMany(mappedBy = "company")
    private List<Price> prices = new ArrayList<>();
}
