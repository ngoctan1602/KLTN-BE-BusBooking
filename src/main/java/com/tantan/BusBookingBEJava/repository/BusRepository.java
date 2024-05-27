package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Bus.Bus;
import com.tantan.BusBookingBEJava.entity.Route.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
    Bus findByIdAndRoutes(long id, Route route);
}
