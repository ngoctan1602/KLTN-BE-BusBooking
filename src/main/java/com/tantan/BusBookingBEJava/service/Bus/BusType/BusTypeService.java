package com.tantan.BusBookingBEJava.service.Bus.BusType;

import com.tantan.BusBookingBEJava.entity.Bus.TypeBus;
import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.exception.CustomException;
import com.tantan.BusBookingBEJava.mapper.Bus.TypeBusMapper;
import com.tantan.BusBookingBEJava.repository.BusTypeRepository;
import com.tantan.BusBookingBEJava.request.Bus.TypeBus.TypeBusRequest;
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
public class BusTypeService implements IBusTypeService {
    @Autowired
    private BusTypeRepository busTypeRepository;
    @Autowired
    private Validator validator;

    @Override
    public boolean createNewTypeBus(TypeBusRequest typeBusRequest) {
        //validate typebusRequest
        Set<ConstraintViolation<TypeBusRequest>> violations = validator.validate(typeBusRequest);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        //Map request to entity
        TypeBus typeBus = TypeBusMapper.INSTANCE.toEntity(typeBusRequest);
        typeBus.setStatus(Status.CREATE);
        //Save entity
        try {
            busTypeRepository.save(typeBus);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Page<TypeBus> getAllTypeBus(int pageNumber, int pageSize) {
        if (pageNumber == 0) {
            throw new CustomException(new BaseResponse(true, HttpStatus.BAD_REQUEST.value(), "PageNumber must >0", null));
        }
        if (pageSize == 0) {
            throw new CustomException(new BaseResponse(true, HttpStatus.BAD_REQUEST.value(), "PageSize must >0", null));
        }
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("id").descending());
        Page<TypeBus> typeBusPage = busTypeRepository.findAll(pageable);
        if (typeBusPage.hasContent()) {
            return typeBusPage;
        }
        throw new CustomException(new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found type bus with pageNumber and pageSize", null));
    }

    @Override
    public TypeBus getTypeBusById(long id) {
        return busTypeRepository.findById(id).orElseThrow(
                () -> new CustomException(new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found type bus with id= " + id, null))
        );
    }

    @Override
    public boolean disableTypeBus(long id) {
        TypeBus typeBus = getTypeBusById(id);
        typeBus.setStatus(Status.DISABLE);
        try {
            busTypeRepository.save(typeBus);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public boolean enableTypeBus(long id) {
        TypeBus typeBus = getTypeBusById(id);
        typeBus.setStatus(Status.ENABLE);
        try {
            busTypeRepository.save(typeBus);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
