package com.tantan.BusBookingBEJava.service.Address;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.entity.Address.Ward;
import com.tantan.BusBookingBEJava.exception.CustomException;
import com.tantan.BusBookingBEJava.exception.ValidationException;
import com.tantan.BusBookingBEJava.mapper.Address.AddressMapper;
import com.tantan.BusBookingBEJava.repository.AddressRepository;
import com.tantan.BusBookingBEJava.request.Address.AddressRequest;
import com.tantan.BusBookingBEJava.response.Address.AddressResponse;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.Ward.IWardService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private IWardService iWardService;
    @Autowired
    private Validator validator;

    @Override
    @Transactional
    public Address createNewAddress(AddressRequest addressRequest) {
        Ward ward = iWardService.getWardEntityById(addressRequest.getIdWard());
        //Validator address request
        Set<ConstraintViolation<AddressRequest>> violations = validator.validate(addressRequest);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        try {
            Address address = new Address();
            address.setWard(ward);
            address.setRoad(addressRequest.getRoad());
            address.setFullName(addressRequest.getRoad() + ", " + ward.getFullAddress());
            return addressRepository.save(address);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public AddressResponse mapRequestToResponse(Address address) {
        AddressResponse addressResponse = AddressMapper.INSTANCE.toResponse(address);
        addressResponse.setIdWard(address.getWard().getId());
        return addressResponse;
    }
}
