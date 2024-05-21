package com.tantan.BusBookingBEJava.service.BusStop;

import com.tantan.BusBookingBEJava.request.BusStopRequest.BusStopRequest;

public interface IBusStopService {
   public boolean createNewBusStop(BusStopRequest busStopRequest);
}
