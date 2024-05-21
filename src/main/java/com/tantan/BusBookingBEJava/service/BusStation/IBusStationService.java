package com.tantan.BusBookingBEJava.service.BusStation;

import com.tantan.BusBookingBEJava.entity.Station.BusStation;
import com.tantan.BusBookingBEJava.request.BusStation.BusStationRequest;

public interface IBusStationService {
    public boolean createNewBusStation(BusStationRequest busStationRequest);
    public BusStation getBusStationById(long id);
}
