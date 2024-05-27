package com.tantan.BusBookingBEJava.service.Ticket.Ticket;

import com.tantan.BusBookingBEJava.common.ConvertStringToTimestamp;
import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Route.Route;
import com.tantan.BusBookingBEJava.entity.Seat.Seat;
import com.tantan.BusBookingBEJava.entity.Ticket.Ticket;
import com.tantan.BusBookingBEJava.repository.TicketRepository;
import com.tantan.BusBookingBEJava.request.Ticket.TicketRequest;
import com.tantan.BusBookingBEJava.service.Bus.Bus.IBusService;
import com.tantan.BusBookingBEJava.service.Route.IRouteService;
import com.tantan.BusBookingBEJava.service.Ticket.TicketItem.ITicketItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TicketService implements ITicketService {

    @Autowired
    IRouteService iRouteService;
    @Autowired
    IBusService iBusService;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ITicketItemService iTicketItemService;

    @Override
    @Transactional
    public boolean createNewTicket(TicketRequest ticketRequest) {
        Route route = iRouteService.getRouteById(ticketRequest.getIdRoute());
        // create new ticket
        Bus bus = iBusService.getBusByIdAndRoute(ticketRequest.getIdBus(), route);
        Ticket ticket = createNewTicketWithRequest(ticketRequest,bus,route);
        for (Seat seat : bus.getSeatList())
        {
            iTicketItemService.createNewTicketItem(seat,ticket);
        }
        return false;
    }

    private Ticket createNewTicketWithRequest(TicketRequest ticketRequest,Bus bus, Route route)
    {
        Timestamp timestamp = new ConvertStringToTimestamp().convert(ticketRequest.getArrivalTime());
        Ticket ticket = new Ticket();
        ticket.setBus(bus);
        ticket.setRoute(route);
        ticket.setDepartureTime(timestamp);
//        ticket.setArrivalTime(ticketRequest.getArrivalTime());
        return ticketRepository.save(ticket);
    }
}
