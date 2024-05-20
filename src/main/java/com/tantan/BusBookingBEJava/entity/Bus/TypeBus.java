package com.tantan.BusBookingBEJava.entity.Bus;

import com.tantan.BusBookingBEJava.entity.Common.Status;
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
public class TypeBus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int totalSeat;
    private String description;
    private Status status;
    @OneToMany(mappedBy = "typeBus")
    private List<Bus> busList = new ArrayList<>();
}
