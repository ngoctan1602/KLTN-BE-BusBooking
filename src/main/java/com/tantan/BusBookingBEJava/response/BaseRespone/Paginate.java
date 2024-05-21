package com.tantan.BusBookingBEJava.response.BaseRespone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paginate {
    private int pageSize;
    private int pageNumber;
    private int totalPage;
}
