package com.tantan.BusBookingBEJava.response.Bus.Bus;

import com.tantan.BusBookingBEJava.entity.Bus.TypeBus;

import com.tantan.BusBookingBEJava.response.Bus.TypeBus.TypeBusResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusResponse {
    private long id;
    private String licensePlate;
    private TypeBusResponse typeBus;
}
