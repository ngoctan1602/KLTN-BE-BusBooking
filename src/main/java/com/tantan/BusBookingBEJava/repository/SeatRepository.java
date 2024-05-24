package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}
