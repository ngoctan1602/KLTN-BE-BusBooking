package com.tantan.BusBookingBEJava.request.Seat.TypeSeat;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeSeatRequest {
    @NotNull(message = "Name must not null")
    private String name;
    private String description;
    @NotNull(message = "Price must not null")
    @Min(value = 1, message = "Price must >0")
    private int price;
}
