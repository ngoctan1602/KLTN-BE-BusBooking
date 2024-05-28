package com.tantan.BusBookingBEJava.request.Price;

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
public class PriceRequest {
    @NotNull(message = "name must not null")
    private String name;
    //  value %
    @NotNull(message = "value must not null")
    @Min(value = 0, message = "min value = 0%")
    @Max(value = 100, message = "max value = 0%")
    private int value;
    private String description;
    private long idCompany;
}
