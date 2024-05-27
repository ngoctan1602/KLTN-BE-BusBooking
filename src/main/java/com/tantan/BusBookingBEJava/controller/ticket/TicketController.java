package com.tantan.BusBookingBEJava.controller.ticket;

import com.tantan.BusBookingBEJava.request.Ticket.TicketRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.Ticket.Ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    @Autowired
    ITicketService iTicketService;
    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createNewTypeSeat(@RequestBody TicketRequest ticketRequest) {
        iTicketService.createNewTicket(ticketRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new BaseResponse(false, HttpStatus.CREATED.value(), "Create new ticket successfully",
                        null)
        );
    }
}
