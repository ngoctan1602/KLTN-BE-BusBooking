package com.tantan.BusBookingBEJava.controller.busstation;

import com.tantan.BusBookingBEJava.request.BusStation.BusStationRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.BusStation.IBusStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/busstation")
public class BusStationController {
    @Autowired
    private IBusStationService iBusStationService;
    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createNewBusStation( @RequestBody BusStationRequest busStationRequest) {
        iBusStationService.createNewBusStation(busStationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new BaseResponse(false, HttpStatus.CREATED.value(), "Create new BusStation successfully", null)
        );
    }
}
