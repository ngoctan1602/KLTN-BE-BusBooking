package com.tantan.BusBookingBEJava.entity.Address;

import com.tantan.BusBookingBEJava.entity.Company.Company;
import com.tantan.BusBookingBEJava.entity.Station.BusStation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String engName;
    private String vniName;
    private String fullAddress;
    @ManyToOne
    @JoinColumn(name = "districtId")
    private District district ;

    @OneToMany(mappedBy = "ward")
    private List<Address>addresses = new ArrayList<>();


}
