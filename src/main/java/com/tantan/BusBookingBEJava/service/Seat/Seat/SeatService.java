package com.tantan.BusBookingBEJava.service.Seat.Seat;

import com.tantan.BusBookingBEJava.entity.Seat.Seat;
import com.tantan.BusBookingBEJava.mapper.Seat.Seat.SeatMapper;
import com.tantan.BusBookingBEJava.repository.SeatRepository;
import com.tantan.BusBookingBEJava.request.Seat.Seat.SeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeatService implements ISeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Override
    @Transactional
    public boolean createNewSeat(SeatRequest seatRequest) {
        try {
            Seat seat =  SeatMapper.INSTANCE.toEntity(seatRequest);
            seatRepository.save(seat);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
