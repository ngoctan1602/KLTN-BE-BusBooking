package com.tantan.BusBookingBEJava.exception;

import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CustomException extends RuntimeException{
    private BaseResponse baseResponse;
    public CustomException(BaseResponse baseResponse) {
        super(baseResponse.getMessage());
        this.baseResponse = baseResponse;
    }
}