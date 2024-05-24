package com.tantan.BusBookingBEJava.response.Seat.TypeSeat;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeSeatResponse {
    private long id;
    private String name;
    private Status status;
    private String description;
    private int price;
}
