package com.tantan.BusBookingBEJava.entity.Bill;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int code;
    private int value;
    private int inventory;
    private Date dateStart;
    private Date dateEnd;
    @OneToMany(mappedBy = "discount")
    private List<Bill> bills = new ArrayList<>();
}
