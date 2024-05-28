package com.tantan.BusBookingBEJava.service.Price;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Company.Company;
import com.tantan.BusBookingBEJava.entity.Price.Price;
import com.tantan.BusBookingBEJava.exception.CustomException;
import com.tantan.BusBookingBEJava.mapper.Price.PriceMapper;
import com.tantan.BusBookingBEJava.repository.PriceRepository;
import com.tantan.BusBookingBEJava.request.Price.PriceRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.Company.ICompanyService;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class PriceService implements IPriceService {
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private ICompanyService iCompanyService;
    @Autowired
    Validator validator;

    @Override
    @Transactional
    public boolean createNewPriceWithCompany(PriceRequest priceRequest) {
        Set<ConstraintViolation<PriceRequest>> violations = validator.validate(priceRequest);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        Company company = iCompanyService.getCompanyWithId(priceRequest.getIdCompany());
        Price price = PriceMapper.INSTANCE.toEntity(priceRequest);
        price.setCompany(company);
        price.setStatus(Status.WAITING);
        try {
            priceRepository.save(price);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Price getPriceWithId(long idPrice) {
        return priceRepository.findById(idPrice).orElseThrow(
                () -> new CustomException(
                        new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found price with id = " + idPrice, null)
                )
        );
    }

    @Override
    public Page<Price> getPriceWithStatus(int pageNumber, int pageSize, Status status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("id").descending());
        Page<Price> pricePage = priceRepository.findByStatus(status, pageable);
        if (pricePage.hasContent()) {
            return pricePage;
        }
        throw new CustomException(
                new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found price with pageNumber = " + pageNumber + " and pageSize = " + pageSize + " and status is " + status, null)
        );
    }

    @Override
    public Page<Price> getAllPrice(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("id").descending());
        Page<Price> pricePage = priceRepository.findAll(pageable);
        if (pricePage.hasContent()) {
            return pricePage;
        }
        throw new CustomException(
                new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found price with pageNumber = " + pageNumber + " and pageSize = " + pageSize, null)
        );
    }

    @Override
    public boolean enablePrice(long idPrice) {
        Price price = getPriceWithId(idPrice);
        price.setStatus(Status.ENABLE);
        try {
            priceRepository.save(price);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
