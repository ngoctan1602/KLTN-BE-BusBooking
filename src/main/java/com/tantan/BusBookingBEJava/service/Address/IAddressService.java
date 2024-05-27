package com.tantan.BusBookingBEJava.service.Address;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.request.Address.AddressRequest;
import com.tantan.BusBookingBEJava.response.Address.AddressResponse;
import jakarta.validation.Valid;

public interface IAddressService {
    public Address createNewAddress(AddressRequest addressRequest);
    public AddressResponse mapRequestToResponse(Address address);
}
