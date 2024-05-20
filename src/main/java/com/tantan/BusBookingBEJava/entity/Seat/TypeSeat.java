package com.tantan.BusBookingBEJava.entity.Seat;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Company.Company;
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
public class TypeSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Status status;
    private String description;
    private int price;
    @OneToMany(mappedBy = "typeSeat")
    private List<Seat> seatList = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;
}
