package com.tantan.BusBookingBEJava.controller.bus.bus;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Bus.TypeBus;
import com.tantan.BusBookingBEJava.mapper.Bus.BusMapper;
import com.tantan.BusBookingBEJava.mapper.Bus.TypeBusMapper;
import com.tantan.BusBookingBEJava.request.Bus.Bus.BusRequest;
import com.tantan.BusBookingBEJava.request.Bus.TypeBus.TypeBusRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponseWithPaginate;
import com.tantan.BusBookingBEJava.response.BaseRespone.Paginate;
import com.tantan.BusBookingBEJava.response.Bus.Bus.BusResponse;
import com.tantan.BusBookingBEJava.response.Bus.TypeBus.TypeBusResponse;
import com.tantan.BusBookingBEJava.service.Bus.Bus.IBusService;
import com.tantan.BusBookingBEJava.service.Bus.BusType.IBusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired
    private IBusService iBusService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> getWardById(@RequestBody BusRequest busRequest) {
        iBusService.createNewBus(busRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new BaseResponse(false, HttpStatus.CREATED.value(), "Create bus successfully", null)
        );
    }

    //    @GetMapping("")
//    public ResponseEntity<BaseResponseWithPaginate> getAllTypeBusWithPaginate(
//            @RequestParam(defaultValue = "10") int pageNumber,
//            @RequestParam(defaultValue = "10") int pageSize) {
//        Page<TypeBus> typeBusPage = iBusTypeService.getAllTypeBus(pageNumber, pageSize);
//        List<TypeBusResponse> typeBusResponseList = typeBusPage.
//                getContent().stream().map(TypeBusMapper.INSTANCE::toResponse).toList();
//
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new BaseResponseWithPaginate(false, HttpStatus.OK.value(), "Get all successfully",
//                        new Paginate(pageSize, pageNumber, typeBusPage.getTotalPages()),
//                        typeBusResponseList)
//        );
//    }
//
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getTypeBusById(@PathVariable long id) {
        Bus bus = iBusService.getBusById(id);
        BusResponse busResponse = BusMapper.INSTANCE.toResponse(bus);
        busResponse.setTypeBus(TypeBusMapper.INSTANCE.toResponse(bus.getTypeBus()));
        return ResponseEntity.status(HttpStatus.OK).body(
                new BaseResponse(false, HttpStatus.OK.value(), "Get bus with id = " + id + " successfully",
                        busResponse)
        );
    }
//
//    @PutMapping("/disable/{id}")
//    public ResponseEntity<BaseResponse> disableTypeBus(@PathVariable long id) {
//        iBusTypeService.disableTypeBus(id);
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new BaseResponse(false, HttpStatus.OK.value(), "Disable typebus successfully",
//                        null)
//        );
//    }
//    @PutMapping("/enable/{id}")
//    public ResponseEntity<BaseResponse> enableTypeBus(@PathVariable long id) {
//        iBusTypeService.enableTypeBus(id);
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new BaseResponse(false, HttpStatus.OK.value(), "Enable typebus successfully",
//                        null)
//        );
//    }
}
