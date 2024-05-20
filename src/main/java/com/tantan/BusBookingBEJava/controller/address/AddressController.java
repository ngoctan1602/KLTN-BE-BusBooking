package com.tantan.BusBookingBEJava.controller.address;

import com.tantan.BusBookingBEJava.request.Address.AddressRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.Address.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/address")
@RestController
public class AddressController {
    @Autowired
    private IAddressService iAddressService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> getWardById(@Valid @RequestBody AddressRequest addressRequest) {
        iAddressService.createNewAddress(addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new BaseResponse(false, HttpStatus.CREATED.value(), "Create address successfully", null)
        );
    }
}
