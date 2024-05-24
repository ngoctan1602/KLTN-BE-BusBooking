package com.tantan.BusBookingBEJava.controller.seat;

import com.tantan.BusBookingBEJava.entity.Seat.TypeSeat;
import com.tantan.BusBookingBEJava.mapper.Seat.TypeSeat.TypeSeatMapper;
import com.tantan.BusBookingBEJava.request.Seat.TypeSeat.TypeSeatRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponseWithPaginate;
import com.tantan.BusBookingBEJava.response.BaseRespone.Paginate;
import com.tantan.BusBookingBEJava.service.Seat.TypeSeat.ITypeSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/typeseat")
public class TypeSeatController {
    @Autowired
    private ITypeSeatService iTypeSeatService;

    @GetMapping("")
    public ResponseEntity<BaseResponseWithPaginate> getAllTypeSeat(@RequestParam(defaultValue = "1") int pageNumber,
                                                                   @RequestParam(defaultValue = "10") int pageSize) {
        Page<TypeSeat> typeSeatPage = iTypeSeatService.getAllTypeBus(pageNumber, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(
                new BaseResponseWithPaginate(false, HttpStatus.OK.value(), "Get all type seat successfully",
                        new Paginate(pageNumber, pageNumber, typeSeatPage.getTotalPages()),
                        typeSeatPage.getContent().stream().map(TypeSeatMapper.INSTANCE::toResponse).toList())
        );
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createNewTypeSeat(@RequestBody TypeSeatRequest typeSeatRequest) {
        iTypeSeatService.createNewTypeSeat(typeSeatRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new BaseResponse(false, HttpStatus.CREATED.value(), "Create new type seat successfully",
                        null)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> createNewTypeSeat(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new BaseResponse(false, HttpStatus.OK.value(), "Get type seat with id = "+id+" successfully",
                        TypeSeatMapper.INSTANCE.toResponse(iTypeSeatService.getTypeSeatById(id)))
        );
    }
}
