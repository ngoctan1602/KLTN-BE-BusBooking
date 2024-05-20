package com.tantan.BusBookingBEJava.response.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardResponse {
    private long id;
    private String engName;
    private String vniName;
    private String fullAddress;
}
