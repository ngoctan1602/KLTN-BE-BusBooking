package com.tantan.BusBookingBEJava.service.busstation;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Station.BusStation;
import com.tantan.BusBookingBEJava.repository.BusStationRepository;
import com.tantan.BusBookingBEJava.request.BusStation.BusStationRequest;
import com.tantan.BusBookingBEJava.service.Address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusStationService implements IBusStationService {
    @Autowired
    private BusStationRepository busStationRepository;
    @Autowired
    private IAddressService addressService;

    @Override
    public boolean createNewBusStation(BusStationRequest busStationRequest) {
        Address address = addressService.createNewAddress(busStationRequest.getAddressRequest());
        try {
            BusStation busStation = new BusStation();
            busStation.setName(busStationRequest.getName());
            busStation.setAddress(address);
            busStation.setStatus(Status.CREATE);
            busStationRepository.save(busStation);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
