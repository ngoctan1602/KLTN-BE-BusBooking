package com.tantan.BusBookingBEJava.mapper.Ward;

import com.tantan.BusBookingBEJava.entity.Address.Ward;
import com.tantan.BusBookingBEJava.response.Address.WardResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WardMapper {
    WardMapper INSTANCE = Mappers.getMapper(WardMapper.class) ;
    @Mapping(source = "id", target = "id")
    @Mapping(source = "engName", target = "engName")
    @Mapping(source = "vniName", target = "vniName")
    @Mapping(source = "fullAddress", target = "fullAddress")
    WardResponse toResponse(Ward wardResponse);
}
