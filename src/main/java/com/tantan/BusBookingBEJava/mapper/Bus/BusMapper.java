package com.tantan.BusBookingBEJava.mapper.Bus;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.request.Bus.Bus.BusRequest;
import com.tantan.BusBookingBEJava.response.Bus.Bus.BusResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BusMapper {
    BusMapper INSTANCE = Mappers.getMapper(BusMapper.class);
    @Mapping(source = "licensePlate",target = "licensePlate")
    Bus toEntity(BusRequest busRequest);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "licensePlate",target = "licensePlate")
    BusResponse toResponse(Bus bus);
}
