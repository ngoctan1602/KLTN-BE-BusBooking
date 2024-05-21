package com.tantan.BusBookingBEJava.service.BusStop;

import com.tantan.BusBookingBEJava.entity.Route.BusStop;
import com.tantan.BusBookingBEJava.entity.Station.BusStation;
import com.tantan.BusBookingBEJava.repository.BusStopRepository;
import com.tantan.BusBookingBEJava.request.BusStopRequest.BusStopRequest;
import com.tantan.BusBookingBEJava.service.BusStation.IBusStationService;
import com.tantan.BusBookingBEJava.service.Route.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusStopService implements IBusStopService {
    @Autowired
    private BusStopRepository busStopRepository;
    @Autowired
    private IBusStationService iBusStationService;
    @Autowired
    private IRouteService iRouteService;

    @Override
    public boolean createNewBusStop(BusStopRequest busStopRequest) {
        BusStop busStop = new BusStop();
        busStop.setBusStopId(busStopRequest.getBusStopId());
        busStop.setIndexStation(busStopRequest.getIndex());
        busStop.setBusStation(iBusStationService.getBusStationById(busStopRequest.getBusStopId().getIdBusStation()));
        busStop.setRoute(iRouteService.getRouteById(busStopRequest.getBusStopId().getIdRoute()));
        try {
            busStopRepository.save(busStop);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
