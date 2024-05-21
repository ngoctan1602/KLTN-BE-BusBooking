package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Route.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,Long> {
}
