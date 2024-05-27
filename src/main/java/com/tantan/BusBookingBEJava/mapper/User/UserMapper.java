package com.tantan.BusBookingBEJava.mapper.User;

import com.tantan.BusBookingBEJava.entity.User.User;
import com.tantan.BusBookingBEJava.request.User.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(source = "fullName",target = "fullName")
    @Mapping(source = "birthDate",target = "birthDate")
    User toEntity(UserRequest userRequest);
}
