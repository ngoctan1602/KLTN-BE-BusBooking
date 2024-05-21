package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
