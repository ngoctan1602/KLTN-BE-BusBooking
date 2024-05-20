package com.tantan.BusBookingBEJava.response.BaseRespone;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Paginate {
    private int pageSize;
    private int pageNumber;
    private int totalPage;
}
