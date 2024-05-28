package com.tantan.BusBookingBEJava.controller.price;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Price.Price;
import com.tantan.BusBookingBEJava.mapper.Price.PriceMapper;
import com.tantan.BusBookingBEJava.request.Price.PriceRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponseWithPaginate;
import com.tantan.BusBookingBEJava.response.BaseRespone.Paginate;
import com.tantan.BusBookingBEJava.response.Price.PriceResponse;
import com.tantan.BusBookingBEJava.service.Price.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/price")
public class PriceController {
    @Autowired
    private IPriceService iPriceService;

    @GetMapping("")
    public ResponseEntity<BaseResponseWithPaginate> getAllPrice(@RequestParam(defaultValue = "1") int pageNumber,
                                                                @RequestParam(defaultValue = "10") int pageSize) {
        Page<Price> pricePage = iPriceService.getAllPrice(pageNumber, pageSize);
        List<PriceResponse> priceResponses = pricePage.stream().map(
                PriceMapper.INSTANCE::toResponse
        ).toList();
        return ResponseEntity.ok(
                new BaseResponseWithPaginate(false, HttpStatus.OK.value(), "Get price successfully",
                        new Paginate(pageSize, pageNumber, pricePage.getTotalPages()),
                        priceResponses)
        );
    }

    @GetMapping("/status")
    public ResponseEntity<BaseResponseWithPaginate> getPriceWithStatus(
            @RequestParam(defaultValue = "1") Status status,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<Price> pricePage = iPriceService.getPriceWithStatus(pageNumber, pageSize,status);
        List<PriceResponse> priceResponses = pricePage.stream().map(
                PriceMapper.INSTANCE::toResponse
        ).toList();
        return ResponseEntity.ok(
                new BaseResponseWithPaginate(false, HttpStatus.OK.value(), "Get all with status of price of company successfully",
                        new Paginate(pageSize, pageNumber, pricePage.getTotalPages()),
                        priceResponses)
        );
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createNewPrice(@RequestBody PriceRequest priceRequest) {
        iPriceService.createNewPriceWithCompany(priceRequest);
        return ResponseEntity.ok(
                new BaseResponse(false, HttpStatus.OK.value(), "Create new price successfully", null)
        );
    }
}
