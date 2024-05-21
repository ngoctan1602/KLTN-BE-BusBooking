package com.tantan.BusBookingBEJava.request.BusStopRequest;

import com.tantan.BusBookingBEJava.entity.Route.BusStopId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusStopRequest {
    private BusStopId busStopId;
    private int index;
}
