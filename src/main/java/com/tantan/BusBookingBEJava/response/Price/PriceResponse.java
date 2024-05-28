package com.tantan.BusBookingBEJava.response.Price;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PriceResponse {
    private long id;
    private String name;
    //  value %
    private int value;
    private String description;
    private Status status;
}
