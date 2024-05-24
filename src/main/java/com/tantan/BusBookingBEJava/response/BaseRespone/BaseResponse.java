package com.tantan.BusBookingBEJava.response.BaseRespone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse implements Serializable {
    private boolean error;
    private int statusCode;
    private String message;
    private Object data;
}
