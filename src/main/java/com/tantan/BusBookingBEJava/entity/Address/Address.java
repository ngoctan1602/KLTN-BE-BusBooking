package com.tantan.BusBookingBEJava.entity.Address;

import com.tantan.BusBookingBEJava.entity.Company.Company;
import com.tantan.BusBookingBEJava.entity.Station.BusStation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String road;
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;
    @OneToOne(mappedBy = "address")
    private BusStation busStation;
    @OneToOne(mappedBy = "address")
    private Company company;
}
