package com.tantan.BusBookingBEJava.service.Address;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.request.Address.AddressRequest;
import jakarta.validation.Valid;

public interface IAddressService {
    public Address createNewAddress(AddressRequest addressRequest);
}
