package com.tantan.BusBookingBEJava.response.Bus.TypeBus;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeBusResponse {
    private long id;
    private String name;
    private int totalSeat;
    private String description;
    private Status status;
}
