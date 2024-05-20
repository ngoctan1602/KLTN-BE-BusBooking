package com.tantan.BusBookingBEJava.request.BusStation;

import com.tantan.BusBookingBEJava.request.Address.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusStationRequest {
    private String name;
    private AddressRequest addressRequest;
}
