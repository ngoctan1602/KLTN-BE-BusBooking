package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Route.BusStop;
import com.tantan.BusBookingBEJava.entity.Route.BusStopId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop, BusStopId> {
}
