package com.tantan.BusBookingBEJava.controller.user;

import com.tantan.BusBookingBEJava.request.User.UserRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.User.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("/create")
    private ResponseEntity<BaseResponse> createNewUser(@RequestBody UserRequest userRequest) {
        iUserService.createNewUser(userRequest);
        return ResponseEntity.ok(new BaseResponse(false, HttpStatus.OK.value(), "Create new user successfully", null));
    }
}
