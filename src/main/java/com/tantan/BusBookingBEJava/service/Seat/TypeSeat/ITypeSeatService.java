package com.tantan.BusBookingBEJava.service.Seat.TypeSeat;
import com.tantan.BusBookingBEJava.entity.Seat.TypeSeat;
import com.tantan.BusBookingBEJava.request.Seat.TypeSeat.TypeSeatRequest;
import org.springframework.data.domain.Page;

public interface ITypeSeatService {
    public boolean createNewTypeSeat(TypeSeatRequest typeSeatRequest);
    public Page<TypeSeat> getAllTypeBus(int pageNumber, int pageSize);
    public TypeSeat getTypeSeatById(long id);
}
