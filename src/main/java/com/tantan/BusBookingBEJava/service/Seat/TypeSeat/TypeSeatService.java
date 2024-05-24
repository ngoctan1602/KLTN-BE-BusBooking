package com.tantan.BusBookingBEJava.service.Seat.TypeSeat;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Seat.TypeSeat;
import com.tantan.BusBookingBEJava.exception.CustomException;
import com.tantan.BusBookingBEJava.mapper.Seat.TypeSeat.TypeSeatMapper;
import com.tantan.BusBookingBEJava.repository.TypeSeatRepository;
import com.tantan.BusBookingBEJava.request.Seat.TypeSeat.TypeSeatRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.Set;

@Service
public class TypeSeatService implements ITypeSeatService {
    @Autowired
    private TypeSeatRepository typeSeatRepository;
    @Autowired
    private Validator validator;

    @Override
    public boolean createNewTypeSeat(TypeSeatRequest typeSeatRequest) {
        Set<ConstraintViolation<TypeSeatRequest>> violations = validator.validate(typeSeatRequest);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        TypeSeat typeBus = TypeSeatMapper.INSTANCE.toEntity(typeSeatRequest);
        typeBus.setStatus(Status.CREATE);
        try {
            typeSeatRepository.save(typeBus);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Page<TypeSeat> getAllTypeBus(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("id").descending());
        Page<TypeSeat> typeSeats = typeSeatRepository.findAll(pageable);
        if (typeSeats.hasContent()) {
            return typeSeats;
        }
        throw new CustomException(new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found type seat with pageNumber= " + pageNumber + " and pageSize= " + pageSize, null));
    }

    @Override
    public TypeSeat getTypeSeatById(long id) {
        return typeSeatRepository.findById(id).orElseThrow(
                () -> new CustomException(new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found type seat with pageNumber= " + id, null))
        );
    }
}
