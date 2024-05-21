package com.tantan.BusBookingBEJava.request.BusStopRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusStopRouteRequest {
    private long busStationId;
    private int index;
}
