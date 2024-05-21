package com.tantan.BusBookingBEJava.service.Route;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Route.BusStopId;
import com.tantan.BusBookingBEJava.entity.Route.Route;
import com.tantan.BusBookingBEJava.exception.CustomException;
import com.tantan.BusBookingBEJava.repository.RouteRepository;
import com.tantan.BusBookingBEJava.request.BusStopRequest.BusStopRequest;
import com.tantan.BusBookingBEJava.request.BusStopRequest.BusStopRouteRequest;
import com.tantan.BusBookingBEJava.request.RouteRequest.RouteRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.BusStop.IBusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RouteService implements IRouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private IBusStopService iBusStopService;

    @Override
    @Transactional
    public boolean createNewRoute(RouteRequest routeRequest) {
        //CreateNewRoute
        Route route = new Route();
        route.setName(routeRequest.getName());
        route.setDescription(routeRequest.getDescription());
        route.setStatus(Status.CREATE);
        Route newRoute = routeRepository.save(route);
        //Foreach BusStop
        try {
            for (BusStopRouteRequest busStop : routeRequest.getBusStopRouteRequests()) {
                //create new BusStopId with newRoute id and busStopId and index
                BusStopId busStopId = new BusStopId(busStop.getBusStationId(), newRoute.getId());
                BusStopRequest busStopRequest = new BusStopRequest(busStopId, busStop.getIndex());
                iBusStopService.createNewBusStop(busStopRequest);
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Route getRouteById(long id) {
        return routeRepository.findById(id).orElseThrow(
                () -> new CustomException(
                        new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found route with id" + id, null)
                )
        );
    }
}
