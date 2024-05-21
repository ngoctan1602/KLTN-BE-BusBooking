package com.tantan.BusBookingBEJava.request.RouteRequest;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.request.BusStopRequest.BusStopRequest;
import com.tantan.BusBookingBEJava.request.BusStopRequest.BusStopRouteRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RouteRequest {
    private String name;
    private String description;
    private List<BusStopRouteRequest> busStopRouteRequests;
}
