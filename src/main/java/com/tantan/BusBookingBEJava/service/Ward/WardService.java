package com.tantan.BusBookingBEJava.service.Ward;

import com.tantan.BusBookingBEJava.entity.Address.Ward;
import com.tantan.BusBookingBEJava.exception.CustomException;
import com.tantan.BusBookingBEJava.mapper.Ward.WardMapper;
import com.tantan.BusBookingBEJava.repository.WardRepository;
import com.tantan.BusBookingBEJava.response.Address.WardResponse;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class WardService implements IWardService {
    @Autowired
    private WardRepository wardRepository;

    @Override
    public WardResponse getWardById(long id) {
        Ward ward = wardRepository.findById(id).orElseThrow(
                () -> new CustomException(
                        new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found ward by id" + id, null)
                )
        );
        return WardMapper.INSTANCE.toResponse(ward);

    }

    @Override
    public Ward getWardEntityById(long id) {
        return  wardRepository.findById(id).orElseThrow(
                () -> new CustomException(
                        new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found ward by id" + id, null)
                )
        );
    }
}
