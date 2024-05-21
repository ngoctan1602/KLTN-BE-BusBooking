package com.tantan.BusBookingBEJava.mapper.Bus;

import com.tantan.BusBookingBEJava.entity.Bus.TypeBus;
import com.tantan.BusBookingBEJava.request.Bus.TypeBus.TypeBusRequest;
import com.tantan.BusBookingBEJava.response.Bus.TypeBus.TypeBusResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface TypeBusMapper {
    TypeBusMapper INSTANCE = Mappers.getMapper(TypeBusMapper.class) ;
    @Mapping(source = "name", target = "name")
    @Mapping(source = "totalSeat", target = "totalSeat")
    @Mapping(source = "description", target = "description")
    TypeBus toEntity(TypeBusRequest addressRequest);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "totalSeat", target = "totalSeat")
    @Mapping(source = "description", target = "description")
    TypeBusResponse toResponse(TypeBus typeBus);
}
