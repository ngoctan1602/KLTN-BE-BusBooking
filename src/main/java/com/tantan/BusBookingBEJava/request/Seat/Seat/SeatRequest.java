package com.tantan.BusBookingBEJava.request.Seat.Seat;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Seat.TypeSeat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatRequest {
    private TypeSeat typeSeat;
    private Bus bus;
}
