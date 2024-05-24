package com.tantan.BusBookingBEJava.service.Bus.Bus;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Bus.TypeBus;
import com.tantan.BusBookingBEJava.entity.Route.Route;
import com.tantan.BusBookingBEJava.entity.Seat.Seat;
import com.tantan.BusBookingBEJava.entity.Seat.TypeSeat;
import com.tantan.BusBookingBEJava.exception.CustomException;
import com.tantan.BusBookingBEJava.mapper.Bus.BusMapper;
import com.tantan.BusBookingBEJava.repository.BusRepository;
import com.tantan.BusBookingBEJava.request.Bus.Bus.BusRequest;
import com.tantan.BusBookingBEJava.request.Seat.Seat.SeatRequest;
import com.tantan.BusBookingBEJava.request.Seat.TypeSeat.TypeSeatRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.Bus.BusType.IBusTypeService;
import com.tantan.BusBookingBEJava.service.Route.IRouteService;
import com.tantan.BusBookingBEJava.service.Seat.Seat.ISeatService;
import com.tantan.BusBookingBEJava.service.Seat.TypeSeat.ITypeSeatService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BusService implements IBusService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private IBusTypeService busTypeService;
    @Autowired
    private ITypeSeatService typeSeatService;
    @Autowired
    private IRouteService routeService;
    @Autowired
    private ISeatService iSeatService;
    @Autowired
    Validator validator;

    @Override
    public boolean createNewBus(BusRequest busRequest) {
        Set<ConstraintViolation<BusRequest>> violations = validator.validate(busRequest);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        //Find typebus and typeseat
        TypeBus typeBus = busTypeService.getTypeBusById(busRequest.getIdTypeBus());
        TypeSeat typeSeat = typeSeatService.getTypeSeatById(busRequest.getIdTypeSeat());
        // New bus
        Bus bus = BusMapper.INSTANCE.toEntity(busRequest);
        bus.setTypeBus(typeBus);

        //add route to bus
        List<Route> routes = new ArrayList<>();
        for (Long idRoute : busRequest.getListIdRoute()) {
            Route route = routeService.getRouteById(idRoute);
            routes.add(route);
        }
        bus.setRoutes(routes);
        try {
            Bus busCreated = busRepository.save(bus);
            //Create Seat
            for (int i = 1; i <= typeBus.getTotalSeat(); i++) {
                SeatRequest seatRequest = new SeatRequest(typeSeat, busCreated);
                iSeatService.createNewSeat(seatRequest);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }


        return false;
    }

    @Override
    public List<Seat> getAllSeatInBus(long idBus) {
        return getBusById(idBus).getSeatList();
    }

    @Override
    public Bus getBusById(long idBus) {
        return busRepository.findById(idBus).orElseThrow(
                () -> new CustomException(
                        new BaseResponse(true, HttpStatus.OK.value(), "Not found bus with id = " + idBus, null)
                )
        );
    }
}
