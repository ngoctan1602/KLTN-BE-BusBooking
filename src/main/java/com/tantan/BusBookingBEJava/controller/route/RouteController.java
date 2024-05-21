package com.tantan.BusBookingBEJava.controller.route;

import com.tantan.BusBookingBEJava.request.BusStation.BusStationRequest;
import com.tantan.BusBookingBEJava.request.BusStopRequest.BusStopRequest;
import com.tantan.BusBookingBEJava.request.RouteRequest.RouteRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.BusStop.IBusStopService;
import com.tantan.BusBookingBEJava.service.Route.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {
    @Autowired
    private IRouteService iRouteService;
    @Autowired
    private IBusStopService iBusStopService;
    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createNewRow(@RequestBody RouteRequest routeRequest) {
        iRouteService.createNewRoute(routeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new BaseResponse(false, HttpStatus.CREATED.value(), "Create new Route successfully", null)
        );
    }

}
