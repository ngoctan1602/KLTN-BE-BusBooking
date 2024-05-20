package com.tantan.BusBookingBEJava.controller.address;

import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.Ward.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/ward")
@RestController
public class WardController {
    @Autowired
    private IWardService iWardService;
    @GetMapping("")
    public ResponseEntity<BaseResponse> getWardById(@RequestParam long wardId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(
                new BaseResponse(false, HttpStatus.OK.value(), "Get ward by id successfully",   iWardService.getWardById(wardId))
        );
    }
}
