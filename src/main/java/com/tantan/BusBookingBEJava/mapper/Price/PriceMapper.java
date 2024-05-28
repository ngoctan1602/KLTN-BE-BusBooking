package com.tantan.BusBookingBEJava.mapper.Price;

import com.tantan.BusBookingBEJava.entity.Price.Price;
import com.tantan.BusBookingBEJava.request.Price.PriceRequest;
import com.tantan.BusBookingBEJava.response.Price.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
    @Mapping(source = "name",target = "name")
    @Mapping(source = "value",target = "value")
    @Mapping(source = "description",target = "description")
    Price toEntity(PriceRequest priceRequest);
    @Mapping(source = "name",target = "name")
    @Mapping(source = "id",target = "id")
    @Mapping(source = "value",target = "value")
    @Mapping(source = "description",target = "description")
    @Mapping(source = "status",target = "status")
    PriceResponse toResponse(Price price);
}
