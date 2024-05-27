package com.tantan.BusBookingBEJava.request.Ticket;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketRequest {
    private String departureTime;//xuất bến
    private String arrivalTime;// cập bến
    private long idBus;
    private long idRoute;
}
