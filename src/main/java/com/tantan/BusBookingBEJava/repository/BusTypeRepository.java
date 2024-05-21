package com.tantan.BusBookingBEJava.repository;

import com.tantan.BusBookingBEJava.entity.Bus.TypeBus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusTypeRepository extends JpaRepository<TypeBus,Long> {
}
