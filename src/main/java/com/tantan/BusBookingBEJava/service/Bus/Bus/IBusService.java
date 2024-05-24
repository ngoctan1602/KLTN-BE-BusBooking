package com.tantan.BusBookingBEJava.service.Bus.Bus;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Seat.Seat;
import com.tantan.BusBookingBEJava.request.Bus.Bus.BusRequest;

import java.util.List;

public interface IBusService {
    public boolean createNewBus(BusRequest busRequest);
    public List<Seat> getAllSeatInBus(long idBus);
    public Bus getBusById(long idBus);
}
