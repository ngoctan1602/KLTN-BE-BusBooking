package com.tantan.BusBookingBEJava.service.Route;

import com.tantan.BusBookingBEJava.entity.Route.Route;
import com.tantan.BusBookingBEJava.request.RouteRequest.RouteRequest;

public interface IRouteService {
    public boolean createNewRoute(RouteRequest routeRequest);
    public Route getRouteById(long id);
}
