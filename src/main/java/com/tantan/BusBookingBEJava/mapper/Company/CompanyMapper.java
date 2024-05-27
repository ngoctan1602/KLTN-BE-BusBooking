package com.tantan.BusBookingBEJava.mapper.Company;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Company.Company;
import com.tantan.BusBookingBEJava.request.Company.CompanyRequest;
import com.tantan.BusBookingBEJava.response.Company.CompanyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    @Mapping(source = "name", target = "name")
    Company toEntity(CompanyRequest companyRequest);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "logo", target = "logo")
    @Mapping(source = "status", target = "status")
    CompanyResponse toResponse(Company company);
}
