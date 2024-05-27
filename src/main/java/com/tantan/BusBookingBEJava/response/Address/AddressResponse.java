package com.tantan.BusBookingBEJava.response.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressResponse {
    private long id;
    private String road;
    private String fullName;
    private long idWard;
}
