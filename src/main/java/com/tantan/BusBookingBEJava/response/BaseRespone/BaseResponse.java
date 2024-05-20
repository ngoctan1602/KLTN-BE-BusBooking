package com.tantan.BusBookingBEJava.response.BaseRespone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private boolean error;
    private int statusCode;
    private String message;
    private Object data;
}
