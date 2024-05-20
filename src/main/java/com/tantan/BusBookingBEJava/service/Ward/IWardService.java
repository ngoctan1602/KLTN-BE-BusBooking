package com.tantan.BusBookingBEJava.service.Ward;

import com.tantan.BusBookingBEJava.entity.Address.Ward;
import com.tantan.BusBookingBEJava.response.Address.WardResponse;

public interface IWardService {
    public WardResponse getWardById(long id);
    public Ward getWardEntityById(long id);
}
