package com.tantan.BusBookingBEJava.mapper.Seat.Seat;

import com.tantan.BusBookingBEJava.entity.Seat.Seat;
import com.tantan.BusBookingBEJava.entity.Seat.TypeSeat;
import com.tantan.BusBookingBEJava.request.Seat.Seat.SeatRequest;
import com.tantan.BusBookingBEJava.request.Seat.TypeSeat.TypeSeatRequest;
import com.tantan.BusBookingBEJava.response.Seat.TypeSeat.TypeSeatResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);
    @Mapping(source = "typeSeat", target = "typeSeat")
    @Mapping(source = "bus", target = "bus")
    Seat toEntity (SeatRequest seatRequest);

}