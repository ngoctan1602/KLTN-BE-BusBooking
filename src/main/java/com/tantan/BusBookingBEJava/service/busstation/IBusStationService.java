package com.tantan.BusBookingBEJava.service.busstation;

import com.tantan.BusBookingBEJava.request.BusStation.BusStationRequest;

public interface IBusStationService {
    public boolean createNewBusStation(BusStationRequest busStationRequest);
}
