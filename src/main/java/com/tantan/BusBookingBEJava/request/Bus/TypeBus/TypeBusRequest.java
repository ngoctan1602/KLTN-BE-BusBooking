package com.tantan.BusBookingBEJava.request.Bus.TypeBus;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import jakarta.validation.constraints.Max;
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
public class TypeBusRequest {
    @NotNull(message = "Name must not null")
    private String name;
    @Min(value = 0,message = "Min totalSeat =0")
    @Max(value = 50,message = "Max totalSeat =50")
    private int totalSeat;
    private String description;
}
