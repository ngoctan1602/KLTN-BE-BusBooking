package com.tantan.BusBookingBEJava.mapper.Address;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.entity.Address.Ward;
import com.tantan.BusBookingBEJava.request.Address.AddressRequest;
import com.tantan.BusBookingBEJava.response.Address.AddressResponse;
import com.tantan.BusBookingBEJava.response.Address.WardResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class) ;
    @Mapping(source = "id", target = "id")
    @Mapping(source = "road", target = "road")
    @Mapping(source = "fullName", target = "fullName")
    AddressResponse toResponse(Address address);
}
