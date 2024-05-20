package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Station.BusStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStationRepository extends JpaRepository<BusStation,Long> {
}
