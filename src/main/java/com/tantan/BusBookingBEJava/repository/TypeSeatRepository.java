package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Seat.TypeSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeSeatRepository extends JpaRepository<TypeSeat,Long> {
}
