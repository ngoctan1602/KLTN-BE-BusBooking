package com.tantan.BusBookingBEJava.request.User;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String fullName;
    private Date birthDate;
    private long idWard;
    private String road;
}
