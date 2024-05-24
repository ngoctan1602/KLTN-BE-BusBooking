package com.tantan.BusBookingBEJava.mapper.Seat.TypeSeat;

import com.tantan.BusBookingBEJava.entity.Seat.TypeSeat;
import com.tantan.BusBookingBEJava.request.Seat.TypeSeat.TypeSeatRequest;
import com.tantan.BusBookingBEJava.response.Seat.TypeSeat.TypeSeatResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface TypeSeatMapper {
    TypeSeatMapper INSTANCE = Mappers.getMapper(TypeSeatMapper.class);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    TypeSeat toEntity (TypeSeatRequest typeSeatRequest);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "status", target = "status")
    TypeSeatResponse toResponse (TypeSeat typeSeat);
}

