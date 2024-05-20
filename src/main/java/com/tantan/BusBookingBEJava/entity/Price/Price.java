package com.tantan.BusBookingBEJava.entity.Price;

import com.tantan.BusBookingBEJava.entity.Bill.Bill;
import com.tantan.BusBookingBEJava.entity.Company.Company;
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
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    //    value %
    private int value;
    private String description;
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;
    @OneToMany(mappedBy = "price")
    private List<Bill> bills = new ArrayList<>();
}
