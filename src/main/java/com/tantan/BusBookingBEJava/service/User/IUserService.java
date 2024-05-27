package com.tantan.BusBookingBEJava.service.User;

import com.tantan.BusBookingBEJava.request.User.UserRequest;

public interface IUserService {
    public boolean createNewUser(UserRequest userRequest);
}
